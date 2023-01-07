package _02_IntroToQueues;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.Stack;

/* 
 * OBJECTIVE:
 * 1. Push 100 double values onto a Stack.
 * 2. Pop off as many values from the Stack to fill a Queue with 5 values.
 * 3. Randomly remove between 1 and 5 values from the Queue and print them to
 *    the console.
 * 4. Repeat steps 2 and 3 until there are no values left in either the Stack
 *    or Queue.
 * 
 * Example:
 * stack: { ..., 60, 36, 88, 4, 65, 75, 10 }
 * queue: { } // empty
 * 
 * Pop off 5 elements from stack to fill queue with 5 elements
 * stack: { ..., 60, 36 }
 * queue: { 10, 75, 65, 4, 88 }
 * 
 * Remove a random number of values from the front of the queue
 * (2 in this example) and print the number of values being removed
 * and the values themselves
 * stack: { ..., 60, 36 }
 * queue: { 65, 4, 88 }
 * "Removing 2 elements: 10 75"
 * 
 * Pop off 2 elements from the stack to fill the queue to 5
 * stack: { ... }
 * queue: { 65, 4, 88, 36, 60 }
 * 
 * Repeat until there are no more elements in the stack and queue
 */

public class _01_IntroToQueue {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles using the Stack class
        //    Note: you have to use the capitalized Double and not double
    	Stack<Double> stack = new Stack<Double>();
        // 2. Use a loop to add 100 random doubles between 0 and 100 to the Stack
    	for(double i =0.0; i<100; i++) {
    		stack.push(i);
    	}
        // 3. Create a Queue of Doubles using the ArrayDeque class
        //    Note: you have to use the capitalized Double and not double
    	ArrayDeque<Double> newStack = new ArrayDeque<Double>();
        // 4. Pop off 5 elements from the Stack and add them to the Queue 
    	double value;
    	for(int i = 0; i<5; i++) {
    		value = stack.pop();
    		newStack.push(value);
    	}
        // 5. Print and remove a random number of elements, from 1 to 5 elements,
        //    from the front of the Queue. Example:
        //    "removing 3 elements from Queue: 25 57 2"
    	double newVal;
    	Random rand = new Random();
    	int num = rand.nextInt(5);
    	for(int i =0; i<num; i++) {
    		newVal = stack.pop();
    		newStack.push(newVal);
    		System.out.println(newVal);
    	}
        // 6. Pop off as many elements from the stack to fill the Queue with 5
        //    elements. If there aren't enough elements in the Stack to fill the 
        //    queue, fill the queue as much as possible. 
    	double val1;
    	int req = 5-newStack.size();
    	for(int i = 0; i<req; i++) {
    		if(stack.size()>0) {
    		val1 = stack.pop();
    		newStack.push(val1);
    		}
    	}
        // 7. Loop until there are no more elements in either the Stack or Queue
        //    and all the elements are printed
        while(newStack.size() > 0) {
        	if(stack.size()>0) {
        	val1 = stack.pop();
    		newStack.push(val1);
    		System.out.println(val1);
        }
        }
    }
}
