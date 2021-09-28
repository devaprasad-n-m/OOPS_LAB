/* 
2.Write a menu driven program to perform the following on a Single Linked List
a.insertion at beginning
b.insertion at end
c.insert a node after a specific node
d.deletion from beginning
e.delete from end
f.delete from a particular position
*/

import java.io.*;

//link
class Link {
    public int data;
    public Link next;

    public Link(int d) {
        data = d;
        this.next = null;
    }

    public void displayLink() {
        System.out.println(data);
    }

}

// Linked List
class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // insert the link to the first position;
    public void insertFirst(int d) {
        Link nl = new Link(d);
        nl.next = first;
        first = nl;
    }

    // insert the link to the last posion
    public void insertLast(int d) {
        Link nl = new Link(d);
        Link cur = first;
        if (isEmpty()) {
            first = nl;
            nl.next = null;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = nl;
            nl.next = null;
        }
    }

    // Insert at the position of a given value.

    public void insert(int key, int d) {
        Link cur = first;
        Link prev = first;
        Link newLink = new Link(d);

        while (cur.data != key) {
            if (cur.next == null) {
                System.out.println("Key not Found");
                break;
            } else {
                prev = cur;
                cur = cur.next;
            }

        }
        newLink.next = prev.next;
        prev.next = newLink;

    }

    // delete the first element

    public int deleteFirst() {
        int temp = first.data;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("List is Empty");
        }
        first = first.next;
        return temp;

    }
    // delete the last element

    public int deleteLast() {
        Link cur = first;
        Link prev = first;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        int temp = cur.data;
        prev.next = null;
        return temp;
    }

    // delete link containing a key

    public void delete(int key) {
        Link cur = first;
        Link prev = first;

        while (cur.data != key) {
            if (cur.next == null) {
                System.out.println("Key not found");
                break;
            }

            else {
                prev = cur;
                cur = cur.next;
            }

        }
        if (cur == first)
            first = first.next;
        else
            prev.next = cur.next;

    }

    // display all elements

    public void displayList() {
        Link current = first;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("THE LIST IS EMPTY");
        }
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

}

class SingleLinkedList {
    public static void main(String args[]) throws IOException {
        LinkList obj;
        obj = new LinkList();
        int choice, value, value1;

        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        System.out.println("###**Single Linked List**####");
        do {
            System.out.println("SINGLE LINKED LIST");
            System.out.println("1.INSERT FIRST");
            System.out.println("2.INSERT LAST");
            System.out.println("3.INSERT LINK");
            System.out.println("4.DELETE FIRST");
            System.out.println("5.DELETE LAST");
            System.out.println("6.DELETE LINK");
            System.out.println("7.DISPLAY ALL");
            choice = Integer.parseInt(in.readLine());

            switch (choice) {
            case 1: {
                System.out.println("Enter the data");
                value = Integer.parseInt(in.readLine());
                obj.insertFirst(value);
                break;
            }
            case 2: {
                System.out.println("Enter the data");
                value = Integer.parseInt(in.readLine());
                obj.insertLast(value);
                break;
            }
            case 3: {
                System.out.println("Enter the data to be added");
                value = Integer.parseInt(in.readLine());
                System.out.println("Enter the linked list value ");
                value1 = Integer.parseInt(in.readLine());
                obj.insert(value1, value);
                break;
            }
            case 4: {
                int d = obj.deleteFirst();
                System.out.println(d + " is Deleted");
                break;
            }
            case 5: {
                int d = obj.deleteLast();
                System.out.println(d + " is Deleted");
                break;
            }
            case 6: {
                System.out.println("Enter the data to be deleted");
                value = Integer.parseInt(in.readLine());
                obj.delete(value);
                System.out.println("Deleted the data");
                break;
            }
            case 7: {
                System.out.println("Display all elements in the list");
                obj.displayList();
                break;
            }
            default:
                System.out.println("Invalid input");

            }

        } while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7);

    }

}