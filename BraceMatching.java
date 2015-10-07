import java.util.*;
import java.io.*;

public class BraceMatching {
	
    static String[] Braces(String[] values) {

		int valuesLength = values.length;
	    String[] answers = new String[valuesLength];
	    for (int i = 0; i < valuesLength; i++) {
	    	answers[i] = "YES";
	    }
	    
	    ArrayList<Character> braces = new ArrayList<Character>();
	    
	    for (int valuesIndex = 0; valuesIndex < valuesLength; valuesIndex++) {
	        String currentValue = values[valuesIndex];
	        for (int currentValueIndex = 0; currentValueIndex < currentValue.length(); currentValueIndex++) { // populating and checking braces
	        	char currentChar = currentValue.charAt(currentValueIndex);
	
	            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
	            	braces.add(currentChar);
	            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
	            	if (braces.isEmpty()) {
	            		answers[valuesIndex] = "NO";
	            		break;
	            	}
	            	else if (currentChar == ')') {
		            	if (braces.get(braces.size() - 1) != '(') {
		            		answers[valuesIndex] = "NO";
		            		break;
		            	} else {
		            		braces.remove(braces.size() - 1);
		            	}
		            } else if (currentChar == '}') {
		            	if (braces.get(braces.size() - 1) != '{') {
		            		answers[valuesIndex] = "NO";
		            		break;
		            	} else {
		            		braces.remove(braces.size() - 1);
		            	}
		            } else if ( currentChar == ']') {
		            	if (braces.get(braces.size() - 1) != '[') {
		            		answers[valuesIndex] = "NO";
		            		break;
		            	} else {
		            		braces.remove(braces.size() - 1);
		            	}
		            }
	            }
	        }
	        if (!braces.isEmpty()) {
	        	answers[valuesIndex] = "NO";
	        }
	        braces.clear();
	    }
	    
	    return answers;
	
	}
    
    public static void main(String[] args) {
    	
    	String[] values = new String[3];
    	values[0] = "{{[][b][test]}}()()()(){{{{{}}}}}[{[{()}]}]";
    	values [1] = "[]({}()[])";
    	values[2] = "{[]}";
    	
    	String[] answers = Braces(values);
    	
    	for (int i = 0; i < values.length; i++) {
    		System.out.println(answers[i]);
    	}
    }

}