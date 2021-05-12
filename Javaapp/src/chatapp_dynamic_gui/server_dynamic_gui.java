package chatapp_dynamic_gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;

import javax.swing.JButton;

public class server_dynamic_gui {

	 static JFrame frame;
     static JTextField textField;
     static JPanel panel = new JPanel();
     static JTextArea textArea = new JTextArea();
     static JLabel lblNewLabel = new JLabel("<--------------SK Server------------->");
     static JScrollPane scrollPane = new JScrollPane(textArea);
     static JButton btnNewButton_1 = new JButton("KICK");
     static JButton btnNewButton_2 = new JButton("List");
     static JButton btnNewButton = new JButton("Close Server");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server_dynamic_gui window = new server_dynamic_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public server_dynamic_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Server Chat Window");
		
		
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 745, 112);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textField.setActionCommand("");
		textField.setForeground(new Color(0, 100, 0));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.ITALIC, 33));
		textField.setToolTipText("Enter the message here!");
		textField.setBounds(0, 576, 745, 114);
		textField.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textArea.setLineWrap(true);
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textArea.setFont(new Font("Perpetua", Font.BOLD, 25));
		textArea.setForeground(new Color(173, 255, 47));
		textArea.setBackground(new Color(128, 128, 128));
		textArea.setBounds(0, 115, 745, 458);
		textArea.setVisible(true);
		
		
		lblNewLabel.setBounds(0, 0, 745, 112);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 163, 745, 410);
		
		
		frame.getContentPane().add(scrollPane);
		
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Wide Latin", Font.BOLD, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(0, 110, 297, 54);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setFont(new Font("Wide Latin", Font.BOLD, 20));
		btnNewButton_1.setBounds(513, 110, 232, 54);
		frame.getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Wide Latin", Font.BOLD, 20));
		btnNewButton_2.setBounds(295, 110, 220, 54);
		frame.getContentPane().add(btnNewButton_2);
		frame.setBounds(100,100,760, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
