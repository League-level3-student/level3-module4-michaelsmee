package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character>values = new Stack<Character>();
    	Stack<Character>letter = new Stack<Character>();
    	for(int i = 0; i<b.length(); i++) {
    		values.push(b.charAt(i));
    	}
    	while(values.isEmpty() != false) {
	    	if(values.size()%2 == 1) {
	    		return false;
	    	}
	    	
	    	if(values.indexOf("{") > 0 && values.indexOf("}") > 0)  {
	    		
	    		values.remove(values.indexOf("{"));
	    
	    		values.remove(values.indexOf("}"));
	    		
	    		
    	
    	}
	    	
	    	else {
	    		return false;
	    	}
	    	
    	}
        return true;
    }
}