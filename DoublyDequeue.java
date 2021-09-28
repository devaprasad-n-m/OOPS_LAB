
//  4.Write program to implement a DEQUE using Doubly Linked List.

import java.io.*;

class Dlink {
    public int data;
    public Dlink prev;
    public Dlink next;

    public Dlink(int d) {
        data = d;
        next = null;
    }

    public void displayLink() {
        System.out.println(data);
    }
}

class DLL {
    private Dlink first;
    private Dlink last;

    public DLL() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // display all elements in the forward direction

    public void displayForward() {
        Dlink current = first;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("THE LIST IS EMPTY");
        }
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    // Insert at last position

    public void enque(int d) {
        Dlink nl = new Dlink(d);
        if (isEmpty()) {
            first = nl;
            last = nl;
        } else {
            nl.prev = last;
            last.next = nl;
            last = nl;
        }
    }

    // Deque first
    public int deque() {
        int temp = first.data;
        if (isEmpty()) {
            System.out.println("The doublylinkedlist is Empty");
        } else if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.next.prev = null;
        }
        return temp;
    }
}

class DoublyDequeue {
    public static void main(String args[]) throws IOException {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        DLL obj;
        obj = new DLL();
        int x, value, value1, z;

        System.out.println("Doubly Linked List");
        do {

            System.out.println("1.DISPLAY");
            System.out.println("2.ENQUE");
            System.out.println("3.DEQUE");

            x = Integer.parseInt(in.readLine());

            switch (x) {
            case 1: {
                System.out.println("Display all elements");
                obj.displayForward();
                break;
            }

            case 2: {
                System.out.println("Enter the element to be inserted");
                value = Integer.parseInt(in.readLine());
                obj.enque(value);
                break;
            }

            case 3: {
                value = obj.deque();
                System.out.println(value + " is deleted");
                break;
            }

            default:
                System.out.println("Invalid input");
                break;

            }

        } while (x == 1 || x == 2 || x == 3);

    }
}