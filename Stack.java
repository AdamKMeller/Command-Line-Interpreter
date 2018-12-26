/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipf;

/**
 *
 * @author Adam_hpx360
 */
/* Java program to implement basic stack 
operations */
class Stack 
{ 
	static final int MAX = 1000; 
	int top; 
	String a[] = new String[MAX]; // Maximum size of Stack 

	boolean isEmpty() 
	{ 
		return (top < 0); 
	} 
	Stack() 
	{ 
		top = -1; 
	} 

	public boolean push(String x) 
	{ 
		if (top >= (MAX-1)) 
		{ 
			System.out.println("Stack Overflow"); 
			return false; 
		} 
		else
		{ 
			a[++top] = x; 
			//System.out.println(x + " pushed into stack"); 
			return true; 
		} 
	} 

	public String pop() 
	{ 
		if (top < 0) 
		{ 
			System.out.println("Stack Underflow"); 
			return "NA"; 
		} 
		else
		{ 
			String x = a[top--]; 
			return x; 
		} 
	} 
} 

