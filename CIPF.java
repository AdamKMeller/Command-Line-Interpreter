/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipf;

import java.util.Scanner;

/**
 *
 * @author Adam_hpx360
 */
public class CIPF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input;
        BST vars = new BST();
        int splittest=0;
        while(true)
        {
            System.out.print(">> ");
            Scanner s = new Scanner(System.in);
            input =s.nextLine();
            
            //If an assingment of a variable
            if(input.indexOf("=")>=0)
                {
                // System.out.println("Adding to list");
                int split = input.indexOf("=");
                splittest=split;
                String name = "" + input.charAt(0);
                int value = solve(input.substring(split+2),vars);
                if(vars.contains(name))
                        System.out.println("Error: Already Declared Variable");
                else
                    vars.put(name, value);
                    //System.out.println("added");
                    
                }
            if(input.indexOf("print ")>=0)
            {
                System.out.println(solve(input.substring(6),vars));
            }
            else if(input.indexOf("print")>=0)
            {
                System.out.println(solve(input.substring(5),vars));
            }
            
            //System.out.println(solve(input.substring(splittest+2),vars));
        }
            
    }
    


public static int solve(String str, BST vars)
{
Stack stack = new Stack();
String tmp = "";
int sol = 0;
for(int i = 0;i<str.length();i++)
    {
        
        
        
    
    if(str.charAt(i)==' ')
    {
      //  System.out.println("we in the spaces");
        if(tmp.length()>=1)
        stack.push(tmp);
        else
        stack.push(" ");
        tmp = "";
        continue;
    }
    if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='/' || str.charAt(i)=='*')
    {
      //  System.out.println("we in the ops");
        if(!tmp.equals(""))
        stack.push(tmp);
        stack.push(Character.toString(str.charAt(i)));
        tmp = "";
        continue;
    }
    else
    {
        //System.out.println("In the builder");
        tmp=tmp+str.charAt(i);
    }
    }
if(tmp.length()>=1)
    stack.push(tmp);

//    System.out.println("In");
//while(stack.isEmpty()!=true)
//        System.out.println(stack.);
//    System.out.println("out");

//remove from Stack
int temp1=0;
//System.out.println("Inbetween");
//try {
if(vars.contains(stack.a[stack.top]))
    stack.a[stack.top]=String.valueOf(vars.get(stack.a[stack.top]));

temp1 = Integer.valueOf(stack.pop());
//}
//catch (IllegalArgumentException e)
//{
//   System.out.println("Illegal Expression 1");
//}
char op;
int temp2;

while(stack.isEmpty()!=true)
{
// try{
    
   if(vars.contains((stack.a[stack.top])))
    stack.a[stack.top]=String.valueOf(vars.get(stack.a[stack.top])); 
    
   temp2 = Integer.valueOf(stack.pop());
   
   
   if(stack.a[stack.top].equals(" "))
    {  
//        System.out.println("caught");
        stack.pop();
    }
   
   
   op = stack.pop().charAt(0);
   
// }
 //   catch (IllegalArgumentException e)
//{
//    System.out.println("Illegal Expression 2");
//    continue;
//}
 
 if(op=='+')
     temp1=temp2+temp1;
  if(op=='-')
     temp1=temp2-temp1;
  if(op=='*')
     temp1=temp2*temp1;
  if(op=='/')
     temp1=temp2/temp1;
   
   
    
    
}
sol = temp1;

return sol;
}


}