

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class client_gui_frame extends JFrame {

	static JLabel namelabel=new JLabel("Client Name");
	static JTextField typingarea=new JTextField();
	static JTextArea displayarea=new JTextArea();
	static JScrollPane scroll=new JScrollPane();
	static JOptionPane jop=new JOptionPane();
	static Font fonti=new Font("ROBOTO",Font.ITALIC,25);
	static Font fontb=new Font("Charcoal CY",Font.BOLD,15);
	static Font fontl=new Font("Century Gothic",Font.BOLD,25);
	static JPanel panel = new JPanel();
	static JButton btnNewButton = new JButton("CLOSE");
    static JButton btnReconnect = new JButton("RECONNECT");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_gui_frame frame = new client_gui_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public client_gui_frame() {
		setResizable(false);
		
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CHAT WINDOW");
		namelabel.setOpaque(true);
		namelabel.setBounds(0, 0, 586, 53);
		
		namelabel.setText("");
		namelabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 35));
		namelabel.setForeground(Color.RED);
		namelabel.setHorizontalAlignment(JLabel.CENTER);
		namelabel.setBackground(Color.BLACK);
		namelabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		displayarea.setFont(fontb);
		displayarea.setForeground(Color.GREEN);
		displayarea.setBackground(Color.DARK_GRAY);
		displayarea.setLineWrap(true);
		displayarea.setEditable(false);
		displayarea.setVisible(true);
	
		scroll = new JScrollPane (displayarea);
		scroll.setBounds(0, 92, 586, 478);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		typingarea.setToolTipText("Enter Message Here!");
		typingarea.setBounds(0, 570, 586, 93);
        
		typingarea.setFont(fonti);
		typingarea.setBackground(Color.GREEN);
		typingarea.setCaretColor(Color.WHITE);
		typingarea.setHorizontalAlignment(JTextField.CENTER);
		typingarea.setForeground(Color.BLUE);
		typingarea.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		getContentPane().setLayout(null);
		
		getContentPane().add(namelabel);
		getContentPane().add(scroll);
		getContentPane().add(typingarea);
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 52, 586, 42);
		
		getContentPane().add(panel);
		panel.setLayout(null);
		btnNewButton.setToolTipText("Leave the Chat!");
		btnNewButton.setBorder(null);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setOpaque(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(0, 10, 121, 22);
		
		btnNewButton.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {System.exit(0);}});
		
		panel.add(btnNewButton);
		btnReconnect.setToolTipText("Renew Connection with Server!");
		btnReconnect.setOpaque(false);
		btnReconnect.setBorder(null);
		btnReconnect.setFocusPainted(false);
		btnReconnect.setForeground(Color.WHITE);
		btnReconnect.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		btnReconnect.setBackground(Color.WHITE);
		btnReconnect.setBounds(408, 10, 178, 22);
		
		panel.add(btnReconnect);
		//pack();
		setVisible(true);
		
	}

}
