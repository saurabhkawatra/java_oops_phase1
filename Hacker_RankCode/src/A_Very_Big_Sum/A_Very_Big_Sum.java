package A_Very_Big_Sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A_Very_Big_Sum {
	
	public static String sum(String num1,String num2) {
		int loopcounter;
		String operand1=num1;
		String operand2=num2;
		String reverseanswer="";
		String answer="";
		int carry=0;
		if(num1.length()>num2.length())
			loopcounter=num1.length();
		else
			loopcounter=num2.length();
		
		while(loopcounter!=0) {
			int x=Character.getNumericValue(operand1.charAt(operand1.length()-1));
			int y=Character.getNumericValue(operand2.charAt(operand2.length()-1));
			
			int operandsum=x+y+carry;
			int base=operandsum%10;
			carry=operandsum/10;
			
			reverseanswer=reverseanswer.concat(String.valueOf(base));
			
			
			if(operand1.length()==1)
				operand1="0";
			else
			operand1=operand1.substring(0, operand1.length()-1);
			if(operand2.length()==1)
				operand2="0";
			else
				operand2=operand2.substring(0, operand2.length()-1);
			
			loopcounter--;
		}
		
		for(int i=0;i<reverseanswer.length();i++) {
			answer=answer.concat(String.valueOf(reverseanswer.charAt(reverseanswer.length()-i-1)));
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraylength=sc.nextInt();
		String answer="0";
		String[] r=new String[arraylength];
		for(int i=0;i<arraylength;i++) {
			 r[i]=sc.next();
		}
		for(int i=0;i<arraylength;i++) {
			answer=sum(answer,r[i]);
		}
		System.out.println(answer);
	}

}
