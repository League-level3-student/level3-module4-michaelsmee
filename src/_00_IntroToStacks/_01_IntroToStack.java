package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Stack<Double>values = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	Random rand = new Random();
    	for(int i =0; i<100; i++) {
    		double num = rand.nextDouble()*101;
    		values.push(num);
    		System.out.println(num);
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    		String val1 = JOptionPane.showInputDialog("Enter 1 number between 0 and 100 inclusive");
    		String val2 = JOptionPane.showInputDialog("Enter 1 number between 0 and 100 inclusive");
    		int value1 = Integer.parseInt(val1);
    		int value2 = Integer.parseInt(val2);
    		//.parseInt
    		
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    		System.out.println("Values between " + value1 + " and " + value2);
    		while(values.isEmpty() == false) {
    			double result = values.pop();
    			if(value1 < result && value2 > result) {
    				System.out.println(result);
    			}
    		}

        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
