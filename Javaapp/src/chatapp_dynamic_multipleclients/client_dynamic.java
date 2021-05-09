package chatapp_dynamic_multipleclients;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class client_dynamic {
	
	Socket clienttoserversocket=new Socket();
	BufferedReader br,br1;
	BufferedWriter bwr;
	PrintWriter pw;
	static String clientname;
	
	public client_dynamic()
	{
		try {
			while(clienttoserversocket==null||!clienttoserversocket.isConnected())
			{
				try {
					System.out.println("Requesting server connection....");
					//clienttoserversocket=new Socket("122.171.26.166",7777);
					clienttoserversocket=new Socket("127.0.0.1",7777);
					System.out.println("Connection Established");
					System.out.println("You are now connected to Saurabh (Server)");
					
					br=new BufferedReader(new InputStreamReader(clienttoserversocket.getInputStream()));
					br1=new BufferedReader(new InputStreamReader(System.in));
					bwr=new BufferedWriter(new OutputStreamWriter(clienttoserversocket.getOutputStream()));
					pw=new PrintWriter(clienttoserversocket.getOutputStream());
					
					System.out.println("Enter your Display Name :");
					clientname=br1.readLine();
					bwr.write(clientname);
					bwr.newLine();
					bwr.flush();
					
					System.out.println("You can now start to chat!");
					
					incommingmessage();
					outgoingmessage();
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					//System.out.println(e);
					System.out.println("Connection Failed!!");
					System.out.println("Trying Again");
				}
				
			}
			
			
		}catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e);
			System.out.println("Connection Failed!!!!!");
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
								System.out.println("Server Quit");
								break;
							}
							//System.out.println("Server: "+ipmessage);
							System.out.println(ipmessage);
					}
				}
			catch(Exception e)
			{
				//e.printStackTrace();
				//System.out.println(e);
				System.out.println("Server not Listening!!!!");
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
							bwr.write(clientname+": "+opmessage);
							bwr.newLine();
							bwr.flush();
					}
				}
			catch(Exception e)
			{
				//e.printStackTrace();
				//System.out.println(e);
				System.out.println("Server not Listening!!");
			}
			
			
			
		};
		
		new Thread(r2).start();
		
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Client started...");
		new client_dynamic();
	}

}
