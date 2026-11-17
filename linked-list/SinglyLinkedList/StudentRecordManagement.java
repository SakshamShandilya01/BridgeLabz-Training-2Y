package com.gla.SinglyLinkedList;
import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    char grade;
    Student next;

    Student(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    static Student head = null;
    static Scanner sc = new Scanner(System.in);

    static void insertBeginning() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newNode = new Student(roll, name, age, grade);

        newNode.next = head;
        head = newNode;

        System.out.println("Student Added Successfully!");
    }

    static void insertEnd() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        System.out.println("Student Added Successfully!");
    }

    static void insertPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();

        if (pos == 1) {
            insertBeginning();
            return;
        }

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newNode = new Student(roll, name, age, grade);

        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Student Added Successfully!");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to Delete: ");
        int roll = sc.nextInt();

        Student temp = head;
        Student prev = null;

        while (temp != null && temp.roll != roll) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student Not Found!");
            return;
        }

        if (prev == null)
            head = head.next;
        else
            prev.next = temp.next;

        System.out.println("Student Deleted Successfully!");
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("\nStudent Found");
                System.out.println("Roll : " + temp.roll);
                System.out.println("Name : " + temp.name);
                System.out.println("Age : " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student Not Found!");
    }

    static void display() {
        if (head == null) {
            System.out.println("No Student Records!");
            return;
        }

        Student temp = head;

        System.out.println("\nStudent Records:");

        while (temp != null) {
            System.out.println("----------------------");
            System.out.println("Roll  : " + temp.roll);
            System.out.println("Name  : " + temp.name);
            System.out.println("Age   : " + temp.age);
            System.out.println("Grade : " + temp.grade);

            temp = temp.next;
        }
    }

    static void updateGrade() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.print("Enter New Grade: ");
                temp.grade = sc.next().charAt(0);

                System.out.println("Grade Updated Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student Not Found!");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Record Management =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Display Records");
            System.out.println("7. Update Grade");
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
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    updateGrade();
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
