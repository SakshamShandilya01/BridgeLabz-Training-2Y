package com.gla.SinglyLinkedList;
import java.util.Scanner;

class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Item next;

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
public class InventoryManagementSystem {
    static Item head = null;
    static Scanner sc = new Scanner(System.in);

    static Item createItem() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Item Name: ");
        String name = sc.next();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        return new Item(id, name, quantity, price);
    }

    static void insertBeginning() {
        Item newItem = createItem();
        newItem.next = head;
        head = newItem;
        System.out.println("Item Added Successfully!");
    }

    static void insertEnd() {
        Item newItem = createItem();

        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newItem;
        }

        System.out.println("Item Added Successfully!");
    }

    static void insertPosition() {
        System.out.print("Enter Position: ");
        int pos = sc.nextInt();

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Item newItem = createItem();
        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;

        System.out.println("Item Added Successfully!");
    }

    static void deleteItem() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        Item temp = head;
        Item prev = null;

        while (temp != null && temp.itemId != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item Not Found!");
            return;
        }

        if (prev == null)
            head = head.next;
        else
            prev.next = temp.next;

        System.out.println("Item Deleted Successfully!");
    }

    static void updateQuantity() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                System.out.print("Enter New Quantity: ");
                temp.quantity = sc.nextInt();
                System.out.println("Quantity Updated!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item Not Found!");
    }

    static void searchById() {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item Not Found!");
    }

    static void searchByName() {
        System.out.print("Enter Item Name: ");
        String name = sc.next();

        Item temp = head;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item Not Found!");
    }

    static void displayItem(Item temp) {
        System.out.println("----------------------");
        System.out.println("Item ID : " + temp.itemId);
        System.out.println("Item Name : " + temp.itemName);
        System.out.println("Quantity : " + temp.quantity);
        System.out.println("Price : " + temp.price);
    }

    static void display() {
        if (head == null) {
            System.out.println("Inventory Empty!");
            return;
        }

        Item temp = head;

        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    static void totalValue() {
        double total = 0;

        Item temp = head;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    static void sortByName(boolean asc) {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                boolean condition = asc
                        ? i.itemName.compareToIgnoreCase(j.itemName) > 0
                        : i.itemName.compareToIgnoreCase(j.itemName) < 0;

                if (condition) {
                    swap(i, j);
                }
            }
        }
        System.out.println("Sorted Successfully!");
    }

    static void sortByPrice(boolean asc) {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                boolean condition = asc ? i.price > j.price : i.price < j.price;

                if (condition) {
                    swap(i, j);
                }
            }
        }
        System.out.println("Sorted Successfully!");
    }

    static void swap(Item a, Item b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Inventory Management =====");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete Item");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display Inventory");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort Name Asc");
            System.out.println("11. Sort Name Desc");
            System.out.println("12. Sort Price Asc");
            System.out.println("13. Sort Price Desc");
            System.out.println("14. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insertBeginning(); break;
                case 2: insertEnd(); break;
                case 3: insertPosition(); break;
                case 4: deleteItem(); break;
                case 5: updateQuantity(); break;
                case 6: searchById(); break;
                case 7: searchByName(); break;
                case 8: display(); break;
                case 9: totalValue(); break;
                case 10: sortByName(true); break;
                case 11: sortByName(false); break;
                case 12: sortByPrice(true); break;
                case 13: sortByPrice(false); break;
                case 14: System.out.println("Program Ended."); break;
                default: System.out.println("Invalid Choice!");
            }

        } while (choice != 14);
    }

}
