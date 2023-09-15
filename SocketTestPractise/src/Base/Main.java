package Base;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Program Started");
		
		try {
			 ServerSocket server = new ServerSocket(8088);
			 
			 while(true) {
			 Socket accept = server.accept();
			 System.out.println("Connection Accepted");
			 PrintWriter pw=new PrintWriter(accept.getOutputStream()); 
			 InputStream is = accept.getInputStream();
			 InputStreamReader isr=new InputStreamReader(is);
			 BufferedReader br= new BufferedReader(isr);
			 String msg="";
			
				 System.out.println("Entering Loop");
//				 String inc="";
//				 String cx="";
				 System.out.println("Available value= "+accept.getInputStream().available());
//				 byte[] allbytes = accept.getInputStream().readNBytes(accept.getInputStream().available());
				 Boolean s=true;
				 String bro="";
				 pw.write("HTTP/1.1 200 OK");
			     pw.write("Content-Type: text/plain");
			     pw.write("\\r\\n");
			     pw.println();
				 pw.flush();
				 accept.close();
				 accept=server.accept();
				 while(s) {
					 byte[] allbytes = accept.getInputStream().readNBytes(10);
					 bro=new String(allbytes);
					 if(bro.matches(".*stop.*")) {
						 s=false;
						 accept.close();
					 }
					 System.out.println(bro);
				 }
				 
				 System.out.println("this is bro = "+bro);
//				 while(cx!=null) {
//					 cx=br.readLine();
//					 System.out.println(cx);
//					 if(cx!=null)
//					 inc=inc.concat(cx);
//				 }
				 
				 
				 pw.write("HTTP/1.1 200 OK");
			     pw.write("Content-Type: text/plain");
			     pw.write("\\r\\n");
			     pw.write("body:");
				 pw.write("just checking");
			     pw.println();
				 pw.flush();
//				 accept.close();
				 System.out.println("Printing Message");
//				 System.out.println(inc);
				 
				 }
			 
			 
//			 System.out.println("available="+is.available());
//			 String msg="";
//			 int check=0;
//			 while(check!=-1) {
//				 check=is.read();
//				msg=msg.concat(Integer.toString(check));
//			 }
			 
		} catch(Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
