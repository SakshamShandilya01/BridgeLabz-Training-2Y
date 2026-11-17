package com.gla.DoublyLinkedList;
import java.util.Scanner;

class State {
    String text;
    State next;
    State prev;

    State(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}
public class TextEditorUndoRedo {
    static State head = null;
    static State tail = null;
    static State current = null;
    static int count = 0;
    static final int LIMIT = 10;

    static Scanner sc = new Scanner(System.in);

    static void addState() {

        System.out.print("Enter Text: ");
        sc.nextLine();
        String text = sc.nextLine();

        if (current != tail && current != null) {
            current.next = null;
            tail = current;
        }

        State newState = new State(text);

        if (head == null) {
            head = tail = current = newState;
            count++;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        count++;

        if (count > LIMIT) {
            head = head.next;
            head.prev = null;
            count--;
        }

        System.out.println("State Added Successfully!");
    }

    static void undo() {

        if (current == null || current.prev == null) {
            System.out.println("Undo Not Possible!");
            return;
        }

        current = current.prev;
        System.out.println("Undo Successful!");
    }

    static void redo() {

        if (current == null || current.next == null) {
            System.out.println("Redo Not Possible!");
            return;
        }

        current = current.next;
        System.out.println("Redo Successful!");
    }

    static void displayCurrentState() {

        if (current == null) {
            System.out.println("No Text Available!");
            return;
        }

        System.out.println("Current Text:");
        System.out.println(current.text);
    }

    static void displayHistory() {

        if (head == null) {
            System.out.println("No History Available!");
            return;
        }

        State temp = head;

        System.out.println("History:");

        while (temp != null) {

            if (temp == current)
                System.out.println("-> " + temp.text);
            else
                System.out.println("   " + temp.text);

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Text Editor Undo / Redo =====");
            System.out.println("1. Add New Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addState();
                    break;

                case 2:
                    undo();
                    break;

                case 3:
                    redo();
                    break;

                case 4:
                    displayCurrentState();
                    break;

                case 5:
                    displayHistory();
                    break;

                case 6:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }

}
