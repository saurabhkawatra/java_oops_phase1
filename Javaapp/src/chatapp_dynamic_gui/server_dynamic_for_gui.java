package chatapp_dynamic_gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class server_outgoingmessages
{
	static List<clientsocketclass> clientsocketlist=new ArrayList<>();
	static BufferedWriter bwr;
	
	static void outgoingmessageforall(String outforall,Socket checksocket)
	{
		for(clientsocketclass csc:clientsocketlist)
		{
			
				try {
					bwr=new BufferedWriter(new OutputStreamWriter(csc.clientsocket1.getOutputStream()));
					bwr.write(outforall);
					bwr.newLine();
					bwr.flush();
					
				}catch(Exception e)
				{
					//e.printStackTrace();
					//System.out.println(e);
					//String n=outforall.substring(0,outforall.indexOf(58)+1);
					//System.out.println(n+" has left");
					clientsocketlist.remove(csc);
					System.out.println("\n\t\t"+csc.clientname+" has left the chat\n");
					try {
						outgoingmessageforall("\n\t\t"+csc.clientname+" has left the chat\n",null);
					}catch(Exception exe)
					{
						//exe.printStackTrace();
						//System.out.println(exe);
					}
				}

		}
	}
}


class clientsocketclass
{
		Socket clientsocket1;
		String clientname;
		BufferedReader br,br1;
		BufferedWriter bwr;
		PrintWriter pw;
				
				clientsocketclass(Socket incommingsocket,String clientname)
				{
					try {
						this.clientsocket1=incommingsocket;
						System.out.println(clientsocket1.getPort()+" client connected");
						
						br=new BufferedReader(new InputStreamReader(clientsocket1.getInputStream()));
						br1=new BufferedReader(new InputStreamReader(System.in));
						bwr=new BufferedWriter(new OutputStreamWriter(clientsocket1.getOutputStream()));
						pw=new PrintWriter(clientsocket1.getOutputStream());
						
						this.clientname=clientname;
						
						incommingmessage();
					}catch(Exception e)
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
												try {
													server_outgoingmessages.outgoingmessageforall(ipmessage,clientsocket1);
												}
												catch(Exception e)
												{
													//e.printStackTrace();
													//System.out.println(e);
												}
												System.out.println(ipmessage);
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
						
}

public class server_dynamic_for_gui {
		
		ServerSocket serversocket;
		Socket clientsocket;
		String clientname;
		BufferedReader br,br1,br2;
		BufferedWriter bwr;
		PrintWriter pw;
		
		public server_dynamic_for_gui()
		{
			try {
					serversocket=new ServerSocket(7777);
					
					serveroutgoingmessages();
					
					while(true)
					{
						System.out.println("Waiting for client...");
					    clientsocket=serversocket.accept();
					    System.out.println(clientsocket.getPort()+" client connected");
					    br1=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
					    clientname=br1.readLine();
					    System.out.println("\n\t\t"+clientname+" has joined the chat\n");
					    try {
					    	server_outgoingmessages.outgoingmessageforall("\n\t\t"+clientname+" has joined the chat\n",null);
					    }catch(Exception e)
					    {
					    	//e.printStackTrace();
							//System.out.println(e);
					    }
					    
						clientsocketclass c=new clientsocketclass(clientsocket,clientname);
						server_outgoingmessages.clientsocketlist.add(c);
					}
				}
			catch(Exception e)
			{
				//e.printStackTrace();
				System.out.println(e);
				System.out.println("Connection Error");
			}	
		}
		
		public void serveroutgoingmessages()
		{
			System.out.println("Sender Started...");
			
			br2=new BufferedReader(new InputStreamReader(System.in));
			
			Runnable r2=()->{
				
				try {
				
						while(true)
						{
								String opmessage;
								opmessage=br2.readLine();
								try {
									server_outgoingmessages.outgoingmessageforall("Saurabh (Server): "+opmessage,null);
								}
								catch(Exception e) {
									//e.printStackTrace();
									//System.out.println(e);
								}
								//bwr.write(opmessage);
								//bwr.newLine();
								//bwr.flush();
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
		new server_dynamic_for_gui();

	}

}
