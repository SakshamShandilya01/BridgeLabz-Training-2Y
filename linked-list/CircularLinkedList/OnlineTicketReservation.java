package com.gla.CircularLinkedList;
import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName,
           String seatNumber, String bookingTime) {

        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class OnlineTicketReservation {
    static Ticket head = null;
    static Scanner sc = new Scanner(System.in);

    static Ticket createTicket() {

        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Customer Name: ");
        String customer = sc.next();

        System.out.print("Enter Movie Name: ");
        String movie = sc.next();

        System.out.print("Enter Seat Number: ");
        String seat = sc.next();

        System.out.print("Enter Booking Time: ");
        String time = sc.next();

        return new Ticket(id, customer, movie, seat, time);
    }

    static void addTicket() {

        Ticket newTicket = createTicket();

        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {

            Ticket temp = head;

            while (temp.next != head)
                temp = temp.next;

            temp.next = newTicket;
            newTicket.next = head;
        }

        System.out.println("Ticket Booked Successfully!");
    }

    static void removeTicket() {

        if (head == null) {
            System.out.println("No Tickets Available!");
            return;
        }

        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();

        Ticket current = head;
        Ticket prev = null;

        do {

            if (current.ticketId == id) {

                if (current == head) {

                    if (head.next == head) {
                        head = null;
                    } else {

                        Ticket last = head;

                        while (last.next != head)
                            last = last.next;

                        head = head.next;
                        last.next = head;
                    }

                } else {

                    prev.next = current.next;
                }

                System.out.println("Ticket Removed Successfully!");
                return;
            }

            prev = current;
            current = current.next;

        } while (current != head);

        System.out.println("Ticket Not Found!");
    }

    static void displayTickets() {

        if (head == null) {
            System.out.println("No Tickets Available!");
            return;
        }

        Ticket temp = head;

        do {

            System.out.println("--------------------------");
            System.out.println("Ticket ID : " + temp.ticketId);
            System.out.println("Customer : " + temp.customerName);
            System.out.println("Movie : " + temp.movieName);
            System.out.println("Seat : " + temp.seatNumber);
            System.out.println("Booking Time : " + temp.bookingTime);

            temp = temp.next;

        } while (temp != head);
    }

    static void searchCustomer() {

        if (head == null) {
            System.out.println("No Tickets Available!");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customer = sc.next();

        Ticket temp = head;
        boolean found = false;

        do {

            if (temp.customerName.equalsIgnoreCase(customer)) {
                displayTicket(temp);
                found = true;
            }

            temp = temp.next;

        } while (temp != head);

        if (!found)
            System.out.println("Ticket Not Found!");
    }

    static void searchMovie() {

        if (head == null) {
            System.out.println("No Tickets Available!");
            return;
        }

        System.out.print("Enter Movie Name: ");
        String movie = sc.next();

        Ticket temp = head;
        boolean found = false;

        do {

            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }

            temp = temp.next;

        } while (temp != head);

        if (!found)
            System.out.println("Ticket Not Found!");
    }

    static void displayTicket(Ticket temp) {

        System.out.println("--------------------------");
        System.out.println("Ticket ID : " + temp.ticketId);
        System.out.println("Customer : " + temp.customerName);
        System.out.println("Movie : " + temp.movieName);
        System.out.println("Seat : " + temp.seatNumber);
        System.out.println("Booking Time : " + temp.bookingTime);
    }

    static void countTickets() {

        if (head == null) {
            System.out.println("Total Tickets = 0");
            return;
        }

        int count = 0;
        Ticket temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Booked Tickets = " + count);
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Online Ticket Reservation =====");
            System.out.println("1. Add Ticket Reservation");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name");
            System.out.println("5. Search by Movie Name");
            System.out.println("6. Count Total Tickets");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTicket();
                    break;

                case 2:
                    removeTicket();
                    break;

                case 3:
                    displayTickets();
                    break;

                case 4:
                    searchCustomer();
                    break;

                case 5:
                    searchMovie();
                    break;

                case 6:
                    countTickets();
                    break;

                case 7:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }

}
