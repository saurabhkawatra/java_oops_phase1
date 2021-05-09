package chatapp_java.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
	ServerSocket serversocket;
	Socket clientsocket;
	BufferedReader br,br1;
	BufferedWriter bwr;
	PrintWriter pw;
	
	public server()
	{
		try {
			
				serversocket=new ServerSocket(7777);
				
				while(true)
				{
					System.out.println("Waiting for client...");
					clientsocket=serversocket.accept();
					System.out.println(clientsocket.getPort()+" client connected");
					
					br=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
					br1=new BufferedReader(new InputStreamReader(System.in));
					bwr=new BufferedWriter(new OutputStreamWriter(clientsocket.getOutputStream()));
					pw=new PrintWriter(clientsocket.getOutputStream());
					incommingmessage();
					outgoingmessage();
				}
			}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e);
			System.out.println("Connection Error");
		}
		
	}
	
	
	public void incommingmessage()
	{
		System.out.println("Reader Started..");
		Runnable r1=()->{
			
			try {
					while(true)
					{
							String ipmessage;
							ipmessage=br.readLine();
							if(ipmessage.equalsIgnoreCase("exit")|ipmessage.equalsIgnoreCase("quit"))
							{
								System.out.println("Client Quit");
								break;
							}
							System.out.println("client: "+ipmessage);
					}
					
				}
			catch(Exception e)
			{
				//e.printStackTrace();
				System.out.println(e);
				System.out.println("Client not Listening!!!!");
			}
			
			
		};
		
		new Thread(r1).start();
	}
	public void outgoingmessage()
	{
		System.out.println("Sender Started...");
		Runnable r2=()->{
			
			try {
			
					while(true)
					{
							String opmessage;
							opmessage=br1.readLine();
							bwr.write(opmessage);
							bwr.newLine();
							bwr.flush();
					}
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					System.out.println(e);
					System.out.println("Client not Listening!!");
				}
			
		};
		
		new Thread(r2).start();
		
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Server started....");
		new server();
	}
	

}
