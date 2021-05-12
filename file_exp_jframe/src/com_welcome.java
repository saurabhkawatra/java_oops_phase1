import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class com_welcome extends JFrame {
	JFrame frame=new JFrame();
	JLabel label;
	ImageIcon ic;
	JPanel panel;
	
	com_welcome()
	{
		frame.setSize(1500,800);
		frame.setBackground(Color.black);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		
		ic=new ImageIcon("folder.png");
		label =new JLabel("Lockers",ic,JLabel.CENTER);
	    label.setVerticalTextPosition(JLabel.TOP);
	    label.setHorizontalTextPosition(JLabel.CENTER);
	    label.setForeground(Color.green);
	    label.setFont(new Font("MV Boli",Font.BOLD,40));
	    label.setBackground(Color.blue);
	    
	    
	    panel.add(label);
		
	    frame.add(panel,BorderLayout.NORTH);
		
		frame.setVisible(true);
		frame.pack();
	}

}
