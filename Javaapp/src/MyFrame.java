import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame implements ActionListener {
	
	static JButton button=new JButton("button");
	
	public void actionPerformed(ActionEvent e)
	{
	
		if(e.getSource()==button)
		{
			System.out.println("Button Pressed");
				
		}
		
		
	}
	
	//public void actionPerformed(ActionEvent[] e)
	{
		
	}
	
	public static void main(String[] args)
	{
		MyFrame f1=new MyFrame();
		
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(9,0));
		panel1.setBackground(Color.red);
		
		JFrame frame=new JFrame();
		frame.setResizable(false);
		frame.setSize(1500, 800);
		frame.setVisible(true);
		frame.setTitle("Experiment");
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//button.setBounds(0, 30, 100, 100);
		button.addActionListener( E -> {System.out.println("Button Pressed lamda function");});
		
		panel1.add(button);
		panel1.add(new JButton("2"));
		panel1.add(new JButton("3"));
		panel1.add(new JButton("4"));
		panel1.add(new JButton("5"));
		panel1.add(new JButton("6"));
		panel1.add(new JButton("7"));
		
		
		frame.add(panel1,BorderLayout.WEST);
		frame.setVisible(true);
		
	}

}
