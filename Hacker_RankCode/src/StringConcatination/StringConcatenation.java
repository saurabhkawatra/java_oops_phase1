package StringConcatination;

import java.util.Scanner;

public class StringConcatenation {
	

    public static void main(String[] args) {
    	String A;
        String P;
    	Scanner sc = new Scanner(System.in);
    	A=sc.nextLine();
        P=sc.nextLine();
        int codeIterations;
        int invalidInput=0;
        int count=0;
        if(A.length()>P.length()) {
        	codeIterations=P.length();
        } else {
        	codeIterations=A.length();
        }
        for(int i=0;i<codeIterations;i++) {
        	if((A.charAt(i)!='1'&&A.charAt(i)!='0')||(P.charAt(i)!='1'&&P.charAt(i)!='0')) {
        		invalidInput++;
        	}
        	if(invalidInput>0) {
        		break;
        	}
        	if(A.charAt(i)==P.charAt(i)) {
        		count++;
        	}
        }
        
        if(invalidInput>0) {
        	
        } else {
        	System.out.println(count);
        }
    	
    }
    
}
