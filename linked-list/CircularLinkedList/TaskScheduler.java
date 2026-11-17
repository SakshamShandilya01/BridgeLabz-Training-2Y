package com.gla.CircularLinkedList;
import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
public class TaskScheduler {
    static Task head = null;
    static Scanner sc = new Scanner(System.in);

    static Task createTask() {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Task Name: ");
        String name = sc.next();

        System.out.print("Enter Priority: ");
        String priority = sc.next();

        System.out.print("Enter Due Date: ");
        String dueDate = sc.next();

        return new Task(id, name, priority, dueDate);
    }

    static void insertBeginning() {
        Task newTask = createTask();

        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }

        System.out.println("Task Added Successfully!");
    }

    static void insertEnd() {
        Task newTask = createTask();

        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newTask;
            newTask.next = head;
        }

        System.out.println("Task Added Successfully!");
    }

    static void insertPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Task newTask = createTask();
        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        System.out.println("Task Added Successfully!");
    }

    static void deleteTask() {
        if (head == null) {
            System.out.println("Task List is Empty!");
            return;
        }

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        Task current = head;
        Task prev = null;

        do {
            if (current.taskId == id) {

                if (current == head) {

                    if (head.next == head) {
                        head = null;
                    } else {
                        Task last = head;

                        while (last.next != head) {
                            last = last.next;
                        }

                        head = head.next;
                        last.next = head;
                    }

                } else {
                    prev.next = current.next;
                }

                System.out.println("Task Deleted Successfully!");
                return;
            }

            prev = current;
            current = current.next;

        } while (current != head);

        System.out.println("Task Not Found!");
    }

    static Task currentTask = null;

    static void viewCurrentTask() {

        if (head == null) {
            System.out.println("No Tasks Available!");
            return;
        }

        if (currentTask == null)
            currentTask = head;

        System.out.println("Task ID : " + currentTask.taskId);
        System.out.println("Task Name : " + currentTask.taskName);
        System.out.println("Priority : " + currentTask.priority);
        System.out.println("Due Date : " + currentTask.dueDate);

        currentTask = currentTask.next;
    }

    static void displayTasks() {

        if (head == null) {
            System.out.println("No Tasks Available!");
            return;
        }

        Task temp = head;

        do {
            System.out.println("----------------------");
            System.out.println("Task ID : " + temp.taskId);
            System.out.println("Task Name : " + temp.taskName);
            System.out.println("Priority : " + temp.priority);
            System.out.println("Due Date : " + temp.dueDate);

            temp = temp.next;

        } while (temp != head);
    }

    static void searchByPriority() {

        if (head == null) {
            System.out.println("No Tasks Available!");
            return;
        }

        System.out.print("Enter Priority: ");
        String priority = sc.next();

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                System.out.println("----------------------");
                System.out.println("Task ID : " + temp.taskId);
                System.out.println("Task Name : " + temp.taskName);
                System.out.println("Due Date : " + temp.dueDate);
                found = true;
            }

            temp = temp.next;

        } while (temp != head);

        if (!found)
            System.out.println("No Task Found!");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Task Scheduler =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Task ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertBeginning();
                    break;

                case 2:
                    insertEnd();
                    break;

                case 3:
                    insertPosition();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    viewCurrentTask();
                    break;

                case 6:
                    displayTasks();
                    break;

                case 7:
                    searchByPriority();
                    break;

                case 8:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);
    }

}
