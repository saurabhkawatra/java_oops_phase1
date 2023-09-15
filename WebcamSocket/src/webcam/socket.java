package webcam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class socket {
	
	public static void main(String[] args) {
		System.out.println("PGM started");
		try {
			ServerSocket serversock=new ServerSocket(8088);
			Socket incSocket = serversock.accept();
			PrintWriter pw=new PrintWriter(incSocket.getOutputStream());
			pw.write("HTTP/1.1 200 OK");
		     pw.write("Content-Type: text/plain");
		     pw.write("\\r\\n");
		     pw.println();
			 pw.flush();
			 incSocket=serversock.accept();
			System.out.println("Connection Made");
//			while(true) {
				InputStream istream = incSocket.getInputStream();
				InputStreamReader isr=new InputStreamReader(istream);
				BufferedReader br= new BufferedReader(isr);
				Thread t1= new Thread(()->{
					System.out.println("Entering Thread");
					while(true) {
						System.out.println("...while loop thread...");
						try {
							System.out.println(Character.toChars(br.read()));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				t1.start();
			System.out.println("Main Thread Close");
			System.out.println("---");
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
