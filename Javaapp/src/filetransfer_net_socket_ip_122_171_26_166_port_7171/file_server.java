package filetransfer_net_socket_ip_122_171_26_166_port_7171;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;

public class file_server {
	static ServerSocket server;
	static Socket client;
	static FileWriter wr;
	static BufferedReader br;
	static BufferedWriter wbr;

	public static void main(String[] args) {
		
		System.out.println("Server Started");
		List<Socket> socketlist=new ArrayList<>();
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream(
					new File("D:\\Desktop\\html experiments\\lab.html"))));
			
			server=new ServerSocket(7171);
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
			//Runnable r1=()->
			//{
			try {
				while(true)
				{
					System.out.println("Waiting for client....");
					client=server.accept();
					//socketlist.add(client);
					System.out.println("Client added");
					
					br=new BufferedReader(new InputStreamReader(new FileInputStream(
							new File("D:\\Desktop\\html experiments\\lab.html"))));
					
					wbr=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					wbr.write("HTTP/1.1 200 OK");
					wbr.write("Content-Type: text/html");
					wbr.write("\\r\\n");
					
					while(true)
					{
						String s="";
						s=br.readLine();
						if(s==null)
						{
							break;
						}
						wbr.write(s);
						wbr.newLine();
						wbr.flush();
						//System.out.println(s);
					}
					client.close();
					System.out.println("client close & loop exit");
				}
				
				}
				catch(Exception e)
				{
					System.out.println(e);
				}	
		//};
		
		//new Thread(r1).start();

	}

}
