
/*
1.Write a menu driven program to implement the following queue operations using array
a.enqueue
b.dequeue
c.display
*/
import java.io.*;
import java.util.*;

class queue {
    private int max;
    private int[] arr;
    private int rear;
    private int front;

    public queue(int s) {
        max = s;
        arr = new int[max];
        rear = -1;
        front = 0;
    }

    // insertion
    public void insert(int d) {
        rear = (rear + 1) % max;
        arr[rear] = d;
    }

    // deletion
    public int delete() {
        int item = 0;

        item = arr[front];
        front = (front + 1) % max;
        return item;
    }

    // isEmpty
    public boolean isEmpty() {
        return ((rear + 1) % max == front);
    }

    // isFull
    public boolean isFull() {
        return ((rear + 2) % max == front);
    }

    // Display
    public void Display() {
        int head = front;
        int tail = rear;

        while (true) {
            System.out.print(" " + arr[head] + " ");
            if (head == tail)
                break;
            else
                head = (head + 1) % max;
        }
        System.out.println(" ");
    }

}

class qOPeration {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int size, choice, data; 

        System.out.println("QUEUE");
        System.out.println("Enter the maximum size of the Queue");
        size = sc.nextInt();

        queue obj = new queue(size);
        do {
            System.out.println("1.ENQUEUE");
            System.out.println("2.DEQUEUE");
            System.out.println("3.DISPLAY");

            choice = sc.nextInt();

            switch (choice) {
            case 1: {
                if (obj.isFull()) {
                    System.out.println("Queue is Full");
                } else {
                    System.out.println("Enter the data");
                    data = sc.nextInt();
                    obj.insert(data);
                }
                break;
            }
            case 2: {
                if (obj.isEmpty()) {
                    System.out.println(" Queue is Empty");
                } else {
                    data = obj.delete();
                    System.out.println(data + " is deleted");
                }
                break;
            }
            case 3: {
                if (obj.isEmpty()) {
                    System.out.println(" Queue is Empty");
                } else {
                    obj.Display();
                }
                break;
            }
            default:
                System.out.println("Invalid input");
            }
        } while (choice == 1 || choice == 2 || choice == 3);
    }
}
