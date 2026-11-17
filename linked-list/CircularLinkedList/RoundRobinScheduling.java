package com.gla.CircularLinkedList;
import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}
public class RoundRobinScheduling {
    static Process head = null;
    static Scanner sc = new Scanner(System.in);

    static void addProcess() {

        System.out.print("Enter Process ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Burst Time: ");
        int burst = sc.nextInt();

        System.out.print("Enter Priority: ");
        int priority = sc.nextInt();

        Process newProcess = new Process(id, burst, priority);

        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;

            while (temp.next != head)
                temp = temp.next;

            temp.next = newProcess;
            newProcess.next = head;
        }

        System.out.println("Process Added Successfully!");
    }

    static void deleteProcess(int id) {

        if (head == null)
            return;

        Process current = head;
        Process prev = null;

        do {

            if (current.processId == id) {

                if (current == head) {

                    if (head.next == head) {
                        head = null;
                    } else {
                        Process last = head;

                        while (last.next != head)
                            last = last.next;

                        head = head.next;
                        last.next = head;
                    }

                } else {
                    prev.next = current.next;
                }

                return;
            }

            prev = current;
            current = current.next;

        } while (current != head);
    }

    static void displayProcesses() {

        if (head == null) {
            System.out.println("No Processes!");
            return;
        }

        Process temp = head;

        System.out.println("\nCurrent Processes:");

        do {
            System.out.println("PID : " + temp.processId +
                    "  Remaining Time : " + temp.remainingTime +
                    "  Priority : " + temp.priority);

            temp = temp.next;

        } while (temp != head);
    }

    static void roundRobin() {

        if (head == null) {
            System.out.println("No Processes!");
            return;
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        int time = 0;
        int completed = 0;

        int total = 0;
        Process temp = head;

        do {
            total++;
            temp = temp.next;
        } while (temp != head);

        while (completed < total) {

            Process current = head;

            do {

                if (current.remainingTime > 0) {

                    if (current.remainingTime > quantum) {
                        time += quantum;
                        current.remainingTime -= quantum;
                    } else {
                        time += current.remainingTime;
                        current.remainingTime = 0;

                        current.turnAroundTime = time;
                        current.waitingTime = time - current.burstTime;

                        completed++;
                    }

                }

                current = current.next;

            } while (current != head);

            displayProcesses();
        }

        double totalWT = 0;
        double totalTAT = 0;

        temp = head;

        if (temp != null) {
            do {
                totalWT += temp.waitingTime;
                totalTAT += temp.turnAroundTime;
                temp = temp.next;
            } while (temp != head);
        }

        System.out.println("\nAverage Waiting Time = " + (totalWT / total));
        System.out.println("Average Turn Around Time = " + (totalTAT / total));

        while (head != null) {
            deleteProcess(head.processId);
        }

        System.out.println("All Processes Executed.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Round Robin Scheduling =====");
            System.out.println("1. Add Process");
            System.out.println("2. Execute Round Robin");
            System.out.println("3. Display Processes");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProcess();
                    break;

                case 2:
                    roundRobin();
                    break;

                case 3:
                    displayProcesses();
                    break;

                case 4:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }
}
