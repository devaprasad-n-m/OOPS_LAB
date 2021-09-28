////  4.Write program to implement a DEQUE using Doubly Linked List.

import java.io.*;
import java.util.*;

class DLink {
    public int data;
    public DLink prev;
    public DLink next;

    public DLink(int d) {
        data = d;
        next = null;
    }

    public void displayLink() {
        System.out.println(data);
    }
}

class Deque {
    private DLink first;
    private DLink last;

    public Deque() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // insert at first position
    public void add_front(int d) {
        DLink nl = new DLink(d);
        if (isEmpty()) {
            first = nl;
            last = nl;
        } else {

            nl.next = first;
            first.prev = nl;
            first = nl;

        }
    }

    // insert at last position
    public void add_rear(int d) {
        DLink nl = new DLink(d);
        if (isEmpty()) {
            first = nl;
            last = nl;
        } else {

            nl.prev = last;
            last.next = nl;
            last = nl;

        }
    }

    // Delete first
    public int remove_front() {
        int temp = first.data;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }
        return temp;

    }

    // Delete last
    public int remove_rear() {
        int temp = last.data;
        last.prev.next = null;
        last = last.prev;
        return temp;

    }

    // size
    public int size() {
        DLink cur = first;
        int n = 1;

        while (cur.next != null) {
            cur = cur.next;
            n++;
        }

        return n;
    }

    // display all elements in the forward direction

    public void displayForward() {
        DLink current = first;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("THE DEQUE IS EMPTY");
        }
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    // display all elements in the backward direction

    public void displayBackward() {
        DLink current = last;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("THE DEQUE IS EMPTY");
        }
        while (current != null) {
            current.displayLink();
            current = current.prev;
        }
    }
}

class DLinkDeque {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Deque obj = new Deque();
        int x, value, value1, z;

        do {
            System.out.println("1.DISPLAY FORWARD");
            System.out.println("2.DISPLAY BACKWARD");
            System.out.println("3.INSERT FIRST");
            System.out.println("4.INSERT LAST");
            System.out.println("5.DELETE FIRST");
            System.out.println("6.DELETE LAST");
            System.out.println("7.SIZE");

            x = sc.nextInt();

            switch (x) {
            case 1: {
                System.out.println("Display all elements in the Forward direction");
                obj.displayForward();
                break;
            }
            case 2: {
                System.out.println("Display all elements in the Backward direction");
                obj.displayBackward();
                break;
            }
            case 3: {
                System.out.println("Enter the data to be inserted to the first position");
                value = sc.nextInt();
                obj.add_front(value);
                break;
            }

            case 4: {
                System.out.println("Enter the data to be inserted to the last position");
                value = sc.nextInt();
                obj.add_rear(value);
                break;
            }

            case 5: {
                if (obj.isEmpty()) {
                    System.out.println("The Deque is Empty");
                } else {
                    value = obj.remove_front();
                    System.out.println(value + " is Deleted");
                }
                break;
            }

            case 6: {
                if (obj.isEmpty()) {
                    System.out.println("The Deque is Empty");
                } else {
                    value = obj.remove_rear();
                    System.out.println(value + " is Deleted");
                }
                break;
            }
            case 7: {
                if (obj.isEmpty()) {
                    System.out.println("The Deque is Empty"); 
                } else {
                value = obj.size();
                System.out.println("Total elements in the Deque is  " + value);
                }
                break;
            }

            default:
                System.out.println("Invalid input");
                break;

            }

        } while (x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6);

    }
}
