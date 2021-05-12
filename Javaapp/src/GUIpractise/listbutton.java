package GUIpractise;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.util.List;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class listbutton extends JFrame {

    JPanel contentPane;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton btnNewButton;
    JButton btnRefresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listbutton frame = new listbutton();
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
	public listbutton() {
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 592, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<------List of Clients------>");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Segoe Print", Font.ITALIC, 30));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 577, 94);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 134, 577, 543);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 18));
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(165, 42, 42));
		
		btnNewButton = new JButton("CLOSE");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Snap ITC", Font.BOLD, 14));
		btnNewButton.setOpaque(false);
		btnNewButton.setBounds(424, 95, 153, 41);
		contentPane.add(btnNewButton);
		
		btnRefresh = new JButton("REFRESH");
		btnRefresh.setOpaque(false);
		btnRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Snap ITC", Font.BOLD, 14));
		btnRefresh.setFocusPainted(false);
		btnRefresh.setBorder(null);
		btnRefresh.setBackground(Color.BLACK);
		btnRefresh.setBounds(0, 95, 153, 41);
		contentPane.add(btnRefresh);
		
	}
}
