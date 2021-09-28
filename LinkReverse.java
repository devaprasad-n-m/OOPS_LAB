//3.Write a program to reverse a Singly Linked List.

import java.io.*;

//link
class LINK {
    public int data;
    public LINK next;

    public LINK(int d) {
        data = d;
        this.next = null;
    }

    public void displayLINK() {
        System.out.println(data);
    }

}

// LINKed List
class LINKList {
    private LINK first;

    public LINKList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // insert the LINK to the first position;
    public void insertFirst(int d) {
        LINK nl = new LINK(d);
        nl.next = first;
        first = nl;
    }

    // insert the LINK to the last posion
    public void insertLast(int d) {
        LINK nl = new LINK(d);
        LINK cur = first;
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
        LINK cur = first;
        LINK prev = first;
        LINK newLINK = new LINK(d);

        while (cur.data != key) {
            if (cur.next == null) {
                System.out.println("Key not Found");
                break;
            } else {
                prev = cur;
                cur = cur.next;
            }

        }
        newLINK.next = prev.next;
        prev.next = newLINK;

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
        LINK cur = first;
        LINK prev = first;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        int temp = cur.data;
        prev.next = null;
        return temp;
    }

    // delete LINK containing a key

    public void delete(int key) {
        LINK cur = first;
        LINK prev = first;

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
        LINK current = first;
        // if list is Empty
        if (isEmpty()) {
            System.out.println("THE LIST IS EMPTY");
        }
        while (current != null) {
            current.displayLINK();
            current = current.next;
        }
    }

    // SWAP
    public void swap(int pos) {
        LINK cur = first;
        LINK prev = first;

        int i = 0;
        while (pos != i) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        int temp = cur.data;
        cur.data = prev.data;
        prev.data = temp;
    }

    // REVERSE
    public void reverse() {
        int p, n = 1;
        LINK cur = first;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= n - i - 1; j++) {
                p = j;
                swap(p);
            }

        }
        displayList();
    }

}

class LinkReverse {
    public static void main(String args[]) throws IOException {
        LINKList obj;
        obj = new LINKList();
        int choice, value, value1;

        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        System.out.println("###**Single LINKed List**####");
        do {
            System.out.println("SINGLE LINKED LIST");
            System.out.println("1.INSERT FIRST");
            System.out.println("2.INSERT LAST");
            System.out.println("3.INSERT LINK");
            System.out.println("4.DELETE FIRST");
            System.out.println("5.DELETE LAST");
            System.out.println("6.DELETE LINK");
            System.out.println("7.REVERSE");
            System.out.println("8.DISPLAY ALL");

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
                System.out.println("Enter the LINKed list value ");
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
                System.out.println("REVERSED LINK");
                obj.reverse();

                break;
            }
            case 8: {
                System.out.println("Display all elements in the list");
                obj.displayList();
                break;
            }
            default:
                System.out.println("Invalid input");

            }

        } while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7
                || choice == 8);

    }

}
