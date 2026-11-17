package com.gla.SinglyLinkedList;
import java.util.Scanner;

class Friend {
    int friendId;
    Friend next;

    Friend(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class User {
    int userId;
    String name;
    int age;
    Friend friendHead;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}
public class SocialMediaConnections {
    static User head = null;
    static Scanner sc = new Scanner(System.in);

    static void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        User newUser = new User(id, name, age);

        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }

        System.out.println("User Added Successfully!");
    }

    static User findUser(int id) {
        User temp = head;

        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }

        return null;
    }

    static void addFriendConnection() {

        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User Not Found!");
            return;
        }

        Friend f1 = new Friend(id2);
        f1.next = u1.friendHead;
        u1.friendHead = f1;

        Friend f2 = new Friend(id1);
        f2.next = u2.friendHead;
        u2.friendHead = f2;

        System.out.println("Friend Connection Added!");
    }

    static void removeFriend(User user, int friendId) {

        Friend temp = user.friendHead;
        Friend prev = null;

        while (temp != null && temp.friendId != friendId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        if (prev == null)
            user.friendHead = temp.next;
        else
            prev.next = temp.next;
    }

    static void removeFriendConnection() {

        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User Not Found!");
            return;
        }

        removeFriend(u1, id2);
        removeFriend(u2, id1);

        System.out.println("Friend Connection Removed!");
    }

    static void mutualFriends() {

        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User Not Found!");
            return;
        }

        System.out.println("Mutual Friends:");

        Friend f1 = u1.friendHead;

        while (f1 != null) {

            Friend f2 = u2.friendHead;

            while (f2 != null) {

                if (f1.friendId == f2.friendId)
                    System.out.println("Friend ID : " + f1.friendId);

                f2 = f2.next;
            }

            f1 = f1.next;
        }
    }

    static void displayFriends() {

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        User user = findUser(id);

        if (user == null) {
            System.out.println("User Not Found!");
            return;
        }

        Friend temp = user.friendHead;

        System.out.println("Friends of " + user.name + ":");

        while (temp != null) {
            System.out.println("Friend ID : " + temp.friendId);
            temp = temp.next;
        }
    }

    static void searchById() {

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        User user = findUser(id);

        if (user == null) {
            System.out.println("User Not Found!");
            return;
        }

        System.out.println("ID : " + user.userId);
        System.out.println("Name : " + user.name);
        System.out.println("Age : " + user.age);
    }

    static void searchByName() {

        System.out.print("Enter Name: ");
        String name = sc.next();

        User temp = head;

        while (temp != null) {

            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("ID : " + temp.userId);
                System.out.println("Name : " + temp.name);
                System.out.println("Age : " + temp.age);
                return;
            }

            temp = temp.next;
        }

        System.out.println("User Not Found!");
    }

    static void countFriends() {

        User temp = head;

        while (temp != null) {

            int count = 0;
            Friend f = temp.friendHead;

            while (f != null) {
                count++;
                f = f.next;
            }

            System.out.println(temp.name + " has " + count + " friend(s).");

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== Social Media Friend Connections =====");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends");
            System.out.println("6. Search User by ID");
            System.out.println("7. Search User by Name");
            System.out.println("8. Count Friends");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addUser();
                    break;

                case 2:
                    addFriendConnection();
                    break;

                case 3:
                    removeFriendConnection();
                    break;

                case 4:
                    mutualFriends();
                    break;

                case 5:
                    displayFriends();
                    break;

                case 6:
                    searchById();
                    break;

                case 7:
                    searchByName();
                    break;

                case 8:
                    countFriends();
                    break;

                case 9:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 9);
    }

}
