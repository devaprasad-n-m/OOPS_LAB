import java.io.*;

class post_evln {

    private int max;
   private int[] arr;
   private int top;

   private int a;
   private int b;
   private int r;
   public post_evln(int s){
       max=s;
       arr= new int[max];
       top=-1;
   }


public void push(int item) {
    top++;
    arr[top]=item;
    //arr[++top]; 
}

public int pop() {
    int item = arr[top];
    top--;
    return item;
    //return arr[top--];
}


public void evaluvation(char x)
{

    if (x=='+'||x=='-'||x=='*'||x=='/'||x=='$')
    {
        a=pop();
        b=pop();
        
        switch(x)
        {
            case '+': push(b+a);
            break;
            case '-': push(b-a);
            break;
            case  '*': push(b*a);
            break;
            case '/' : push(b/a);
            break;
            case '$' :push((int) Math. round(Math.pow(b, a)));
            break;
          
        }
    }
    else
    {
        int a=Integer.parseInt(String.valueOf(x));
        push(a);
    }

}

    public static void main(String args[])throws IOException
    {
        String str;
        int l,i,result;

        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("Enter the Postfix String");


       // x = Integer.parseInt(in.readLine());
        str=in.readLine();
        l = str.length();

        post_evln obj = new post_evln(l);

        for(i=0;i<l;i++)
            obj.evaluvation(str.charAt(i));
        
        result = obj.pop();
         
        System.out.println(result);


    }
}
