package com.gla.DoublyLinkedList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    String status;
    Book next;
    Book prev;

    Book(String title, String author, String genre, int bookId, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.status = status;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagementSystem {
    static Book head = null;
    static Book tail = null;
    static Scanner sc = new Scanner(System.in);

    static Book createBook() {
        System.out.print("Enter Book Title: ");
        String title = sc.next();

        System.out.print("Enter Author: ");
        String author = sc.next();

        System.out.print("Enter Genre: ");
        String genre = sc.next();

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Availability Status: ");
        String status = sc.next();

        return new Book(title, author, genre, id, status);
    }

    static void insertBeginning() {
        Book newBook = createBook();

        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }

        System.out.println("Book Added Successfully!");
    }

    static void insertEnd() {
        Book newBook = createBook();

        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }

        System.out.println("Book Added Successfully!");
    }

    static void insertPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Book newBook = createBook();
        Book temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        if (temp.next == null) {
            temp.next = newBook;
            newBook.prev = temp;
            tail = newBook;
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }

        System.out.println("Book Added Successfully!");
    }

    static void deleteBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book temp = head;

        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book Not Found!");
            return;
        }

        if (temp == head)
            head = temp.next;

        if (temp == tail)
            tail = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;

        System.out.println("Book Deleted Successfully!");
    }

    static void searchByTitle() {
        System.out.print("Enter Book Title: ");
        String title = sc.next();

        Book temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book Not Found!");
    }

    static void searchByAuthor() {
        System.out.print("Enter Author: ");
        String author = sc.next();

        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book Not Found!");
    }

    static void updateStatus() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                System.out.print("Enter New Availability Status: ");
                temp.status = sc.next();
                System.out.println("Status Updated Successfully!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book Not Found!");
    }

    static void displayBook(Book temp) {
        System.out.println("----------------------");
        System.out.println("Book ID : " + temp.bookId);
        System.out.println("Title : " + temp.title);
        System.out.println("Author : " + temp.author);
        System.out.println("Genre : " + temp.genre);
        System.out.println("Status : " + temp.status);
    }

    static void displayForward() {
        if (head == null) {
            System.out.println("Library is Empty!");
            return;
        }

        Book temp = head;

        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    static void displayReverse() {
        if (tail == null) {
            System.out.println("Library is Empty!");
            return;
        }

        Book temp = tail;

        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    static void countBooks() {
        int count = 0;

        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Books = " + count);
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove Book");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");

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
                    deleteBook();
                    break;
                case 5:
                    searchByTitle();
                    break;
                case 6:
                    searchByAuthor();
                    break;
                case 7:
                    updateStatus();
                    break;
                case 8:
                    displayForward();
                    break;
                case 9:
                    displayReverse();
                    break;
                case 10:
                    countBooks();
                    break;
                case 11:
                    System.out.println("Program Ended.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);
    }

}
