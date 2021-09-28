import java.io.*;

class Stack {
    private int max;
    private int[] arr;
    private int top;

    public Stack(int m) {

        max = m;
        arr = new int[max];
        top = -1;

    }

    public void push(int j) {
        arr[++top] = j;
        /*
         * top++; arr[top]=j;
         */
    }

    public int pop() {
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public void Display() {
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);

        int s, m, x, i = 1;

        System.out.println("Enter the size of stack");
        m = Integer.parseInt(in.readLine());

        Stack st = new Stack(m);
        System.out.println("Choose Stack Operations \n ");

        while (i == 1) {
            System.out.println("1.PUSH \n 2.POP \n 3.PEEK \n 4.Display");
            s = Integer.parseInt(in.readLine());

            switch (s) {
                case 1: {
                    if (st.isFull()) {
                        System.out.println("Over flows");
                        break;
                    } else {
                        System.out.println("Enter the element to be added");
                        x = Integer.parseInt(in.readLine());
                        st.push(x);
                        System.out.println("Do you want to continue ? (yes=1/no=0)");
                        i = Integer.parseInt(in.readLine());
                    }
                    break;
                }

                case 2: {
                    if (st.isEmpty()) {
                        System.out.println("Under Flow");
                        break;
                    } else {
                        x = st.pop();
                        System.out.println(x);
                    }
                    break;
                }

                case 3: {
                    if (st.isEmpty()) {
                        System.out.println("Under Flow");
                        break;
                    } else {
                        x = st.peek();
                        System.out.println(x);
                    }
                    break;
                }

                case 4: {
                    if (st.isEmpty()) {
                        System.out.println("Stack Empty");
                        break;

                    } else {
                        st.Display();
                    }
                    break;
                }

                default:
                    System.out.println("Invalid Input..");
                    break;
            }
        }

    }
}