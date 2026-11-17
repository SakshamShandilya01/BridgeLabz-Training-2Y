package com.gla.DoublyLinkedList;
import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
public class MovieManagementSystem {
    static Movie head = null;
    static Movie tail = null;
    static Scanner sc = new Scanner(System.in);

    static Movie createMovie() {
        System.out.print("Enter Movie Title: ");
        String title = sc.next();

        System.out.print("Enter Director: ");
        String director = sc.next();

        System.out.print("Enter Year of Release: ");
        int year = sc.nextInt();

        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();

        return new Movie(title, director, year, rating);
    }

    static void insertBeginning() {
        Movie newMovie = createMovie();

        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }

        System.out.println("Movie Added Successfully!");
    }

    static void insertEnd() {
        Movie newMovie = createMovie();

        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }

        System.out.println("Movie Added Successfully!");
    }

    static void insertPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Movie newMovie = createMovie();
        Movie temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        if (temp.next == null) {
            temp.next = newMovie;
            newMovie.prev = temp;
            tail = newMovie;
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }

        System.out.println("Movie Added Successfully!");
    }

    static void deleteMovie() {
        System.out.print("Enter Movie Title: ");
        String title = sc.next();

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie Not Found!");
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

        System.out.println("Movie Deleted Successfully!");
    }

    static void searchByDirector() {
        System.out.print("Enter Director Name: ");
        String director = sc.next();

        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " " + temp.year + " Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No Movie Found!");
    }

    static void searchByRating() {
        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();

        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " " + temp.director + " " + temp.year);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No Movie Found!");
    }

    static void displayForward() {
        if (head == null) {
            System.out.println("No Movies Available!");
            return;
        }

        Movie temp = head;

        while (temp != null) {
            System.out.println("----------------------");
            System.out.println("Title : " + temp.title);
            System.out.println("Director : " + temp.director);
            System.out.println("Year : " + temp.year);
            System.out.println("Rating : " + temp.rating);

            temp = temp.next;
        }
    }

    static void displayReverse() {
        if (tail == null) {
            System.out.println("No Movies Available!");
            return;
        }

        Movie temp = tail;

        while (temp != null) {
            System.out.println("----------------------");
            System.out.println("Title : " + temp.title);
            System.out.println("Director : " + temp.director);
            System.out.println("Year : " + temp.year);
            System.out.println("Rating : " + temp.rating);

            temp = temp.prev;
        }
    }

    static void updateRating() {
        System.out.print("Enter Movie Title: ");
        String title = sc.next();

        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.print("Enter New Rating: ");
                temp.rating = sc.nextDouble();

                System.out.println("Rating Updated Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie Not Found!");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Movie Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Update Rating");
            System.out.println("10. Exit");

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
                    deleteMovie();
                    break;
                case 5:
                    searchByDirector();
                    break;
                case 6:
                    searchByRating();
                    break;
                case 7:
                    displayForward();
                    break;
                case 8:
                    displayReverse();
                    break;
                case 9:
                    updateRating();
                    break;
                case 10:
                    System.out.println("Program Ended.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 10);
    }

}
