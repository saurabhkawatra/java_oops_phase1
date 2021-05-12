package GUIpractise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
					server_dynamic_gui.textArea.append("\n\t\t"+csc.clientname+" has left the chat\n\n");
					server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
					
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
						
						server_dynamic_gui.textArea.append(clientsocket1.getPort()+" client connected\n");
						server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
						
						br=new BufferedReader(new InputStreamReader(clientsocket1.getInputStream()));
						br1=new BufferedReader(new InputStreamReader(System.in));
						bwr=new BufferedWriter(new OutputStreamWriter(clientsocket1.getOutputStream()));
						pw=new PrintWriter(clientsocket1.getOutputStream());
						
						this.clientname=clientname;
						
						incommingmessage();
						
					}catch(Exception e)
					{
						server_dynamic_gui.textArea.append(e+"\n");
						server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
						server_dynamic_gui.textArea.append("Connection Error\n");
						server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
					}
					
					
				}
						public void incommingmessage()
						{
							server_dynamic_gui.textArea.append("Reader Started..\n");
							server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
							
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
												server_dynamic_gui.textArea.append(ipmessage+"\n");
												server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
										}
										
									}
								catch(Exception e)
								{
									//e.printStackTrace();
									server_dynamic_gui.textArea.append(e+"\n");
									server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
									server_dynamic_gui.textArea.append("Client not Listening!!!!\n");
									server_dynamic_gui.textArea.setCaretPosition(server_dynamic_gui.textArea.getDocument().getLength());
								}
								
								
							};
							
							new Thread(r1).start();
						}
						
}

public class implementation_gui extends server_dynamic_gui {
		
		ServerSocket serversocket;
		Socket clientsocket;
		String clientname;
		BufferedReader br,br1,br2;
		BufferedWriter bwr;
		PrintWriter pw;
		
		public implementation_gui()
		{
			try {
					serversocket=new ServerSocket(7777);
					
					buttonsimplement();
					
					serveroutgoingmessages();
					
					while(true)
					{
						textArea.append("Waiting for client...\n");
						textArea.setCaretPosition(textArea.getDocument().getLength());
						
					    clientsocket=serversocket.accept();
					    
					    textArea.append(clientsocket.getPort()+" client connected\n");
						textArea.setCaretPosition(textArea.getDocument().getLength());
						
					    br1=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
					    clientname=br1.readLine();
					    
					    textArea.append("\n\t\t"+clientname+" has joined the chat\n");
						textArea.setCaretPosition(textArea.getDocument().getLength());
						
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
				textArea.append("e\n");
				textArea.setCaretPosition(textArea.getDocument().getLength());
				textArea.append("Connection Error\n");
				textArea.setCaretPosition(textArea.getDocument().getLength());
			}	
		}
		void buttonsimplement()
		{
			//close server button
			server_dynamic_gui.btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
			

			
			server_dynamic_gui.btnNewButton_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					listbutton l1=new listbutton();
					l1.setVisible(true);
					
					l1.btnNewButton.addActionListener(new ActionListener() {  //CLOSE Button in list
						@Override
						public void actionPerformed(ActionEvent e) { l1.dispose(); }  
						});
					
					int x=1;
					if(server_outgoingmessages.clientsocketlist.isEmpty())
					{
						l1.textArea.append("\n\t<---No clients present on Server at this moment!--->\n");
						l1.textArea.setCaretPosition(l1.textArea.getDocument().getLength());
					}
					for(clientsocketclass j:server_outgoingmessages.clientsocketlist)
					{
						l1.textArea.append("\nClient "+x+++"-->"+j.clientname+"\tSocket--> "+j.clientsocket1+"\n");
						l1.textArea.setCaretPosition(l1.textArea.getDocument().getLength());
					}
					
					
					l1.btnRefresh.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							l1.textArea.setText("");
							l1.textArea.setCaretPosition(l1.textArea.getDocument().getLength());
							
							int x=1;
							if(server_outgoingmessages.clientsocketlist.isEmpty())
							{
								l1.textArea.append("\n\t<---No clients present on Server at this moment!--->\n");
								l1.textArea.setCaretPosition(l1.textArea.getDocument().getLength());
							}
							for(clientsocketclass j:server_outgoingmessages.clientsocketlist)
							{
								l1.textArea.append("\nClient "+x+++"-->"+j.clientname+"\tSocket--> "+j.clientsocket1+"\n");
								l1.textArea.setCaretPosition(l1.textArea.getDocument().getLength());
							}
						}
					});
					
				}
			});
		
			server_dynamic_gui.btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int kicknumber=-10;
					String s=JOptionPane.showInputDialog("Enter the Client Number from the list");
					
					if(s!=null)
					{
						kicknumber=Integer.parseInt(s)-1;
						if(kicknumber>=0&&kicknumber<server_outgoingmessages.clientsocketlist.size())
						{
							int confirm=0;
							confirm=JOptionPane.showConfirmDialog(null, "You are about to kickout "+server_outgoingmessages.clientsocketlist.get(kicknumber).clientname+" from server");
							if(confirm==JOptionPane.YES_OPTION)
							{
								try {
									server_outgoingmessages.clientsocketlist.get(kicknumber).clientsocket1.close();
									server_outgoingmessages.clientsocketlist.remove(kicknumber);
								}
								catch(Exception exe)
								{
									textArea.append(exe+"\n");
									textArea.setCaretPosition(textArea.getDocument().getLength());
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid Input");
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Input");
					}
					
					
				}
			});
		
		}
		
		public void serveroutgoingmessages()
		{
			textArea.append("Sender Started...\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
			textField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
				
					try
					{
						if(e.getKeyCode()==10)
						{
							String opmessage;
							opmessage=textField.getText();
							try {
								textArea.append("Saurabh (Server): "+opmessage+"\n");
								textArea.setCaretPosition(textArea.getDocument().getLength());
								server_outgoingmessages.outgoingmessageforall("Saurabh (Server): "+opmessage,null);
							}
							catch(Exception exe) {
								
							}

							textField.setText("");
						}
					}
					catch(Exception exe)
					{
						textArea.append("Server not Listening!!\n");
						textArea.setCaretPosition(textArea.getDocument().getLength());
					}
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					
				}
			});	
		}
		
	public static void main(String[] args) 
	{
		System.out.println("Server started....");
		new implementation_gui();

	}

}
