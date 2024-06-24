package edu.dccc.datastructures;

import java.util.Locale;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class DoublyLinkedList {

    //Represent a node of the doubly linked list

    class Node {
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }

    //Represent the head and tail of the doubly linked list
    Node head, tail = null;

    //addNode() will add a node to the list
    public void addNode(PhonebookData data) {
        //Create a new node
        Node newNode = new Node(data);

        //If list is empty
        if (head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.previous = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to tail
            newNode.previous = tail;
            //newNode will become new tail
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    //display() will print out the nodes of the list
    SortedSet search(String searchItem) {
        SortedSet sortedSet = new TreeSet();
        return sortedSet;
    }

    public SortedSet searchTailFirst(String searchItem) {
        SortedSet sortedSet = new TreeSet();
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty. . .");
            return null;
        }
        //    System.out.println("Nodes of doubly linked list: ");
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Checks each node by incrementing the pointer.
            if (current.data.getName().toLowerCase().contains(searchItem.toLowerCase().strip()) ||
                    current.data.getMobilePhone().toLowerCase().contains(searchItem.toLowerCase().strip())) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.next;
        }
        return sortedSet;
    }

    public SortedSet searchHeadFirst(String searchItem) {
        SortedSet sortedSet = new TreeSet();
        Node current = head;
        if (head == null) {
            System.out.println("List is empty. . .");
            return null;
        }
        //    System.out.println("Nodes of doubly linked list: ");
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Checks each node by incrementing the pointer.
            if (current.data.getName().toLowerCase().contains(searchItem.toLowerCase().strip()) ||
                    current.data.getMobilePhone().toLowerCase().contains(searchItem.toLowerCase().strip())) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.next;
        }
        return sortedSet;
    }

    public void display() {
        //Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty. . .");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.println(current.data + "");
            current = current.next;
        }

    }

    public void testDoublyLinkedList() {
        Scanner scanner = new Scanner(System.in);
        addNode(new PhonebookData("Ej Osman", "773-234-2422"));
        addNode(new PhonebookData("Davis Williams", "435-523-1534"));
        addNode(new PhonebookData("Robert William", "574-985-7822"));
        addNode(new PhonebookData("Mark Ruben", "267-485-1222"));
        addNode(new PhonebookData("Bob Gray", "432-964-2298"));
        addNode(new PhonebookData("Kyle Benson", "463-984-2345"));
        display();
        System.out.println("");
        String choice = scanner.nextLine();
        while (!choice.equals("q")) {
            if (!choice.equals("t")) {
                System.out.println("Tail First");
                System.out.println("Enter the search Item");
                String searchItem = scanner.nextLine();
                SortedSet sortedSet = searchTailFirst(searchItem);
                if (sortedSet != null) {
                    for (Object node : sortedSet) {
                        System.out.println(((PhonebookData) node).toString());
                    }
                } else {
                    System.out.println("No data Found. . .");
                }
            } else if (choice.equals("h")) {
                System.out.println("Head First");
                System.out.println("Enter the Search Item");
                String searchItem = scanner.nextLine();
                SortedSet sortedSet = searchHeadFirst(searchItem);
                if (sortedSet != null) {
                    for (Object node : sortedSet) {
                        System.out.println(((PhonebookData) node).toString());
                    }
                } else {
                    System.out.println("No data Found. . .");
                }
            }
            System.out.println("");
            choice = scanner.nextLine();

        }
    }
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.testDoublyLinkedList();
    }
}