package projectpractise;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.io.File;

public class patternmatching {
	
public static void main(String[] args)
{
	String pattern;
	Scanner sc=new Scanner(System.in);
	System.out.println("File name cannot contain characters \\ / ? < > \" | * : ");
	System.out.println("Enter the pattern");
	pattern=sc.nextLine();
	
	if(pattern.matches("[0-9]+"))
	System.out.println("Match 1");
	
	if(pattern.matches("([^(\\\\|/|:|?|*|<|>|||\")*])*"))
		System.out.println("matches 2");
	else
		System.out.println("doesnt match 2");
	
	String input="New folder (2)";
	String keyname=Pattern.quote(input);
	if(pattern.matches(keyname+"[.][0-9|a-z|A-Z]*")||pattern.matches(keyname))
		System.out.println("File name accepted/matches");
	else
		System.out.println("File name not match/accepted");
	
	String a="alpha";
	String b="beta";
	String c="";
    c=c.concat(a+"\\"+b);
    System.out.println("value of c = "+c);
    
    try {
    	a="sdkadkastxt";
        String[] k=a.split("[.]");
        System.out.println(k[0]);
        System.out.println(k.length);
    }catch(Exception e) {
    	System.out.println(e);
    }
    System.out.printf("|%15s| |%5s| |%15s| ",a,b,c);
    
    Stack<Integer> ss=new Stack<>();
    
    File ino=new File("C:\\Users\\saura\\Desktop\\New folder (2)");
    File[] filesinsideino=ino.listFiles();
    for(File e:filesinsideino)
    {
    	String filename=e.getName();
    	String directory=e.getAbsolutePath();
    	long filesize=e.length();
    	String type="";
    	if(e.isDirectory())
    		type="Folder/directory";
    	else
    	{
    		String tempname;
    		tempname=e.getName();
    		String[] typeexe;
    	    typeexe=tempname.split("[.]");
    	    type=typeexe[typeexe.length-1];
    	}
    	//System.out.println("File Name: "+filename+"\tFile type: "+type+"\tFile size: "+filesize+"Location: "+directory);
    	System.out.println("\tFile type: "+type+"\t\tFile size: "+filesize);
    }
    
}
}
