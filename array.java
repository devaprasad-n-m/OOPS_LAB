 import java.io.*;

public class array {
      
        public static void main(String args[])  throws IOException
         {
            int[] arr;
            int i,j,t;
               arr = new int[20];

               InputStreamReader read = new InputStreamReader(System.in);
               BufferedReader in = new BufferedReader(read);

               System.out.println("Enter the size of the array");
               int n= Integer.parseInt(in.readLine());

               for(i=0;i<n;i++){
                 arr[i] = Integer.parseInt(in.readLine());
               }

               System.out.println("Sorted array is");
                //bubble sort
               for(i=0; i<n-1; i++)
               for(j=0; j<(n-i)-1; j++)
                if(arr[j]>arr[j+1])
                {
                    t=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }

                //printing

                for(i=0;i<n;i++){
                    System.out.println(arr[i]);
                }
                
            }
          
        }


