package finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

public class Myframe extends JFrame implements ActionListener {
	
	//set size for frame (1200x800) is the size of the projector
	private int height = 1200;
	private int width = 800;
	
	JButton save, open, clear;
	//Canvas canvas;
	//private int's need get() functions so no one can alter them
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	//The constructor uses a BorderLayout as a manager so i can make it cute
	Myframe(){
		JFrame frame = new JFrame();
		frame.setTitle("Pixel art: Final Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(getHeight(),getWidth());
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.setVisible(true);
		
		//create the buttons
		save = new JButton();
		save.setBackground(Color.white);
		save.setText("SAVE");
		save.setFocusable(false);
		//save.setHorizontalAlignment(JButton.LEFT);
		//save.setVerticalAlignment(JButton.TOP);
		//save.setBounds(10, 780, 80, 80);
		save.addActionListener((ActionListener) this);
		
		open = new JButton();
		open.setBackground(Color.white);
		open.setText("OPEN");
		open.setFocusable(false);
		//open.setHorizontalAlignment(JButton.CENTER);
		//open.setVerticalAlignment(JButton.TOP);
		//open.setBounds(90, 780, 80, 80);
		//open.setBounds(100, 100, 100, 100);
		open.addActionListener(this);
		
		clear = new JButton();
		clear.setBackground(Color.white);
		clear.setText("CLEAR");
		clear.setFocusable(false);
		//clear.setHorizontalAlignment(JButton.RIGHT);
		//clear.setVerticalAlignment(JButton.TOP);
		//clear.setBounds(120, 780, 80, 80);
		clear.addActionListener(this);
		
		//we crate and personalize each panel (for this project ill use 2 panels East and West)
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		panel1.setBackground(Color.black);
		panel2.setBackground(Color.gray);
		panel1.setPreferredSize(new Dimension(200,800));
		panel2.setPreferredSize(new Dimension(1000,800));
		
		panel1.add(save);
		panel1.add(open);
		panel1.add(clear);
		
		//canvas = new Canvas();
		
		//panel2.add(canvas);
		
		frame.add(panel1,BorderLayout.WEST);
		frame.add(panel2,BorderLayout.EAST);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==save) {
			System.out.println("Please kill yourself");
		}
		if(e.getSource()==open) {
			System.out.println("Or dont");
		}
		if(e.getSource()==clear) {
			System.out.println("Please finish this quick");
		}
	}
}
