//Q) infix to postfix conversions
import java.io.*;

class postfix{

    public char[] fString;
    private int max;
    private char[] arr;
    private int top;
    private int TOP;

    
 //Stack implemented by arr character array

    public postfix(int s){
        max=s;
        arr= new char[max];
        fString= new char[max];
        top=-1;
        TOP=-1;
    }
 
 
 public void push(char item) {
     top++;
     arr[top]=item;
     //arr[++top];
 }
 
 public char pop() {
     char item = arr[top];
     top--;
     return item;
     //return arr[top--];
 }
 
 public char peek() {
     return arr[top];
 }
 
 public boolean isFull() {
    return(top==max-1);
    
     //return top==max-1;
 }
 
 public boolean isEmpty(){
     return top==-1;
 }

 
 public void PUSH(char item) {
    TOP++;
    fString[TOP]=item;
    //arr[++top];
}

public char POP() {
    char item = fString[TOP];
    TOP--;
    return item;
    //return arr[top--];
}



 //The function check the prcedence of operator

 public int prec(char x)
 {
    switch (x) 
    { 
    case '+': 
    case '-': 
        return 1; 
   
    case '*': 
    case '/': 
        return 2; 
   
    case '$': 
        return 3; 
    } 
    return -1;
 }

 // The Function convert the infix string to postfix string
 public  void conversion(char x){
     char item;

     //operator checking condition
     if (x=='+'||x=='-'||x=='*'||x=='/'||x=='$')
     {
         if(isEmpty())
             push(x);
         else
         {
             while(!isEmpty())
             {
                 item = pop();
                 if(item=='(')
                    push(item);
                    
                 else
                 {
                   
                     if(prec(item)<prec(x)) 
                           push(item);
                  
                     if(prec(item)>=prec(x))
                     {
                        //System.out.println(item);
                        PUSH(item);
                     }
                         
                 }

                 if(prec(item)<x || prec(item) == '(')
                    break;
             }
            push(x); 
         }
         
     }
     // '(' checking condition
     else if(x=='(')
     {push(x);
}
    // ')' checking condition
     else if(x==')')
     {
         while(!isEmpty())
         {
             item =pop();
             if(item == '(')
             break;
             else
             {
              //  System.out.println(item);
                PUSH(item);
             }
            
         }
     }

     else 
     // condition for operand
    {// System.out.println(x);
     PUSH(x);
}

 }


 
// MAIN FUNCTION
    public static void main(String args[])throws IOException
    {
      int l,i,x;String str;
      char[] arr;
      char item;
      InputStreamReader read=new InputStreamReader(System.in);
      BufferedReader in=new BufferedReader(read);

      System.out.println("*****Converter******");
      do{
        System.out.println("\n1. Infix -> Postfix \n2.Infix -> Prefix  \nPress any number for exit");
        x = Integer.parseInt(in.readLine());
  
       

        switch(x)
        {
            case 1:
            {
                System.out.println("Enter the Infix String");
                str=in.readLine();
                l=str.length();

              arr= new char[l];
              System.out.println("The Required Postfix string is");
        
              postfix  obj=new postfix(l);
               
              //Repeat untill all characters are empty
              for(i=0;i<l;i++)
              {
                obj.conversion(str.charAt(i));
              }
              //to output the operators remaining in the stack
              while(!obj.isEmpty())
              {
                    item = obj.pop();
                    obj.PUSH(item);
          
              }
              for(i=0;i<l;i++)    
                  System.out.println(obj.fString[i]);
              
            }
  
            break;
  
            case 2:
            {
                System.out.println("Enter the Infix String");
                str=in.readLine();
                l=str.length();

              arr= new char[l];
              System.out.println("The Required Prefix string is");
        
              postfix  rev=new postfix(l);
  //step1  1. Reverse the infix expression.
              for(i=0;i<l;i++)
                rev.push(str.charAt(i));
  
                for(i=0;i<l;i++)
                {
                  arr[i]=rev.pop();
                }
                
   //step2. Make Every '(' as ')' and every ')' as '('.
                for(i=0;i<l;i++)
                {
                    if(arr[i]==')')
                    {
                        arr[i]='(';
                        continue;
                    }
                    if(arr[i]=='(')
                    {
                        arr[i]=')';
                    }
                }
  
  //step 3:  Convert expression to postfix form
              
  
                postfix  obj=new postfix(l);
               
                for(i=0;i<l;i++)
                {
                  obj.conversion(arr[i]);
                }
  
                while(!obj.isEmpty())
              {
                    item = obj.pop();
                    obj.PUSH(item);
                    
              }
                
  
  //step 4: TAke the string reversal of postfix form
          System.out.println("Final Answer");
          for(i=0;i<l;i++)
          {
              arr[i]=obj.POP();
              System.out.println(arr[i]);
          }
   
             
              break;
  
            }
            
            default : System.out.println("Invalid input");
        }
        
      }while(x==1||x==2);
     

     
      
     }

}