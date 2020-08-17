import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.util.*;

class Window extends JFrame implements ActionListener{
	
	private JLabel head;
	private JLabel subHeading;
	private JLabel red;
	private JLabel green;
	private JLabel blue;
	private JTextField r;
	private JTextField g;
	private JTextField b;
	private JButton convert;
	private JButton clear;
	private JPanel top = new JPanel();
	private JPanel colors = new JPanel();
	private JPanel buttons = new JPanel();

	
	public Window()
	{  
		getContentPane().setBackground(Color.lightGray);
		
		top.setLayout(new BorderLayout());
		colors.setLayout(new GridLayout(3,2));
		buttons.setLayout(new GridLayout(1,2));

		setLayout(new BorderLayout());
		Container cpane = getContentPane();
		
		Font h = new Font("Calibri",Font.BOLD,28);
		head = new JLabel("eFootball PES 2020 Color Converter",JLabel.CENTER);
		head.setFont(h);
		subHeading=new JLabel("Convert RGB Colors to PES Colors, by Anas Patel",JLabel.CENTER);
		top.add(head, BorderLayout.CENTER);
		top.add(subHeading, BorderLayout.SOUTH);
		cpane.add(top, BorderLayout.NORTH);
		
		Font s = new Font("Sansserif",Font.BOLD,22);
		red = new JLabel("R:",JLabel.CENTER);
		red.setFont(s);
		colors.add(red);
		
		Font inputFont = new Font("Sansserif", Font.PLAIN,20);
		r=new JTextField();
		r.setFont(inputFont);
		colors.add(r);
		
		green = new JLabel("G:",JLabel.CENTER);
		green.setFont(s);
		colors.add(green);
		
		g=new JTextField();
		g.setFont(inputFont);
		colors.add(g);

		
		blue = new JLabel("B:",JLabel.CENTER);
		blue.setFont(s);
		colors.add(blue);
		
		b=new JTextField();
		b.setFont(inputFont);
		colors.add(b);
		
		cpane.add(colors, BorderLayout.CENTER);
		
		Font buttonFont = new Font("Sansserif", Font.PLAIN,18);

		convert = new JButton("Convert to PES Colors");
		convert.setFont(buttonFont);
		convert.setBackground(Color.WHITE);
		
		clear = new JButton("Clear");
		clear.setFont(buttonFont);
		clear.setBackground(Color.WHITE);

		
		buttons.add(convert);
		buttons.add(clear);
		cpane.add(buttons, BorderLayout.SOUTH);
		
		convert.addActionListener(this);
		clear.addActionListener(this);

	}
	
	
		public String convertCol(JTextField a)	{
			int num = Integer.parseInt(a.getText());
			int ans = (num*63)/255;
			String PESColor = Integer.toString(ans); 
			return PESColor;
		}
		
		
		public void actionPerformed(ActionEvent e) {
			 int clicks = 0;
		         clicks++;

		        if (clicks >= 1){
		        	convert.setEnabled(false);
		        	clear.setEnabled(true);
		        }
		      
		     
			if(e.getSource()==convert)	{
				r.setText(convertCol(r)+" (PES)");
				g.setText(convertCol(g)+" (PES)");
				b.setText(convertCol(b)+" (PES)");
				
				r.setEditable(false);
				g.setEditable(false);
				b.setEditable(false);

			}
			
			if(e.getSource()==clear)	{
				r.setText("0");
				g.setText("0");
				b.setText("0");
				convert.setEnabled(true);
				
				r.setEditable(true);
				g.setEditable(true);
				b.setEditable(true);
			}
			
			if(r.getText().equals("0"))	{
				clear.setEnabled(false);
			}
			
			if(g.getText().equals("0"))	{
				clear.setEnabled(false);
			}
			
			if(b.getText().equals("0"))	{
				clear.setEnabled(false);
			}
		}
		
		
		
    
		
}


class PESConverter {
	public static void main(String[] args) throws IOException
	{  
	Window win = new Window();
	win.setSize(600,300);
	win.setVisible(true);
	win.setTitle("PES 2019 Color converter");
	}
}