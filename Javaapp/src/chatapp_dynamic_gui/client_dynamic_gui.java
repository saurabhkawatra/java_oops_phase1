package chatapp_dynamic_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class client_dynamic_gui {
	
	Socket clienttoserversocket=new Socket();
	BufferedReader br,br1;
	BufferedWriter bwr;
	PrintWriter pw;
	static String clientname;
	
	
	JFrame f=new JFrame();
	JLabel namelabel=new JLabel("Client Name");
	JTextField typingarea=new JTextField();
	JTextArea displayarea=new JTextArea();
	JScrollPane scroll=new JScrollPane();
	JOptionPane jop=new JOptionPane();
	Font fonti=new Font("ROBOTO",Font.ITALIC,25);
	Font fontb=new Font("Charcoal CY",Font.BOLD,15);
	Font fontl=new Font("Century Gothic",Font.BOLD,25);
	
	public client_dynamic_gui()
	{
		gui();
		
		//displayarea.append("Client started...\n");
		//displayarea.setCaretPosition(displayarea.getDocument().getLength());
		
		try {
			while(clienttoserversocket==null||!clienttoserversocket.isConnected())
			{
				try {
					
					displayarea.append("Requesting server connection....\n");
					displayarea.setCaretPosition(displayarea.getDocument().getLength());
					
					//clienttoserversocket=new Socket("122.171.26.166",7777);
					clienttoserversocket=new Socket("127.0.0.1",7777);
                    
					displayarea.append("\nConnection Established\n");
					displayarea.setCaretPosition(displayarea.getDocument().getLength());
					
					displayarea.append("\nYou are now connected to Saurabh (Server)\n");
					displayarea.setCaretPosition(displayarea.getDocument().getLength());
					
					br=new BufferedReader(new InputStreamReader(clienttoserversocket.getInputStream()));
					br1=new BufferedReader(new InputStreamReader(System.in));
					bwr=new BufferedWriter(new OutputStreamWriter(clienttoserversocket.getOutputStream()));
					pw=new PrintWriter(clienttoserversocket.getOutputStream());
					
					jop.grabFocus();
					clientname=jop.showInputDialog("Enter your Display Name");
					
					if(clientname==null)
						clientname="Anonymous";
						
						bwr.write(clientname);
						bwr.newLine();
						bwr.flush();
					
					
					namelabel.setText(clientname);
					
					displayarea.append("\nYou can now start to chat!\n\n");
					displayarea.setCaretPosition(displayarea.getDocument().getLength());
					
					typingarea.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							try
							{
								if(e.getKeyCode()==10)
								{
									String opmessage;
									opmessage=typingarea.getText();
									bwr.write(clientname+": "+opmessage);
									bwr.newLine();
									bwr.flush();

									typingarea.setText("");
								}
							}
							catch(Exception exe)
							{
								displayarea.append("Server not Listening!!\n");
								displayarea.setCaretPosition(displayarea.getDocument().getLength());
							}
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							
							
						}
					});
					
					incommingmessage();
					
				}
				catch(Exception e)
				{
					displayarea.append("Connection Failed!!\n");
					displayarea.setCaretPosition(displayarea.getDocument().getLength());
					
					displayarea.append("Trying Again\n");
					displayarea.setCaretPosition(displayarea.getDocument().getLength());
				}
				
			}
			
			
		}catch(Exception e)
		{
			displayarea.append("Connection Failed!!!!!\n");
			displayarea.setCaretPosition(displayarea.getDocument().getLength());
		}
		
		
	}
	private void gui()
	{
		
		f.setSize(600,700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setLayout(new BorderLayout());
		f.setTitle("CHAT WINDOW");
		
		namelabel.setText(clientname);
		namelabel.setFont(fontl);
		namelabel.setForeground(Color.DARK_GRAY);
		namelabel.setHorizontalAlignment(JLabel.CENTER);
		namelabel.setBackground(Color.LIGHT_GRAY);
		namelabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		displayarea.setFont(fontb);
		displayarea.setForeground(Color.GREEN);
		displayarea.setBackground(Color.DARK_GRAY);
		displayarea.setLineWrap(true);
		displayarea.setEditable(false);
		displayarea.setVisible(true);
	
		scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
		typingarea.setFont(fonti);
		typingarea.setBackground(Color.GREEN);
		typingarea.setCaretColor(Color.WHITE);
		typingarea.setHorizontalAlignment(JTextField.CENTER);
		typingarea.setForeground(Color.BLUE);
		typingarea.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		f.add(namelabel,BorderLayout.NORTH);
		f.add(scroll,BorderLayout.CENTER);
		f.add(typingarea,BorderLayout.SOUTH);
		//f.pack();
		f.setVisible(true);
		
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
							displayarea.append(ipmessage+"\n");
							displayarea.setCaretPosition(displayarea.getDocument().getLength());
							
					}
				}
			catch(Exception e)
			{
				displayarea.append("Server not Listening!!!!\n");
				displayarea.setCaretPosition(displayarea.getDocument().getLength());
			}
			
			
		};
		
		new Thread(r1).start();
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Client started...");
		new client_dynamic_gui();
	}

}
