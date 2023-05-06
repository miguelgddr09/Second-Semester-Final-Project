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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Myframe extends JFrame implements ActionListener, ChangeListener {
	
	//set size for frame (1200x800) is the size of the projector
	private int height = 1200;
	private int width = 800;
	
	JButton save, open, clear;
	JSlider redSlider, greenSlider, blueSlider;
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
		save.addActionListener((ActionListener) this);
		
		open = new JButton();
		open.setBackground(Color.white);
		open.setText("OPEN");
		open.setFocusable(false);
		open.addActionListener(this);
		
		clear = new JButton();
		clear.setBackground(Color.white);
		clear.setText("CLEAR");
		clear.setFocusable(false);
		clear.addActionListener(this);
		
		//sliders
		redSlider = new JSlider(0,255,0);
		greenSlider = new JSlider(0,255,0);
		blueSlider = new JSlider(0,255,0);
		
		
		redSlider.setPreferredSize(new Dimension(200,100));
		redSlider.setPaintTicks(true);
		//redSlider.setMinorTickSpacing(20);
		redSlider.setPaintTrack(true);
		redSlider.setMajorTickSpacing(51);
		redSlider.setOpaque(false);
		redSlider.setPaintLabels(true);
		redSlider.setOrientation(SwingConstants.HORIZONTAL);
		
		greenSlider.setPreferredSize(new Dimension(200,100));
		greenSlider.setPaintTicks(true);
		//greenSlider.setMinorTickSpacing(10);
		greenSlider.setPaintTrack(true);
		greenSlider.setMajorTickSpacing(51);
		greenSlider.setOpaque(false);
		greenSlider.setPaintLabels(true);
		greenSlider.setOrientation(SwingConstants.HORIZONTAL);
		
		blueSlider.setPreferredSize(new Dimension(200,100));
		blueSlider.setPaintTicks(true);
		//blueSlider.setMinorTickSpacing(10);
		blueSlider.setPaintTrack(true);
		blueSlider.setMajorTickSpacing(51);
		blueSlider.setOpaque(false);
		blueSlider.setPaintLabels(true);
		blueSlider.setOrientation(SwingConstants.HORIZONTAL);
		
		//we crate and personalize each panel (for this project ill use 2 panels East and West)
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		panel1.setBackground(Color.black);
		panel2.setBackground(Color.gray);
		panel1.setPreferredSize(new Dimension(200,800));
		panel2.setPreferredSize(new Dimension(1000,800));
		
		//subpanels
		JPanel subpanelButtons = new JPanel();
		JPanel subpanelSliders = new JPanel();
		
		subpanelButtons.setBackground(Color.black);
		subpanelButtons.setPreferredSize(new Dimension(200,400));
		subpanelSliders.setBackground(Color.black);
		subpanelSliders.setPreferredSize(new Dimension(200,400));
		
		
		panel1.setLayout(new BorderLayout());
		
		panel1.add(subpanelButtons, BorderLayout.NORTH);
		panel1.add(subpanelSliders, BorderLayout.SOUTH);
		
		
		subpanelButtons.add(save);
		subpanelButtons.add(open);
		subpanelButtons.add(clear);
		
		subpanelSliders.add(redSlider);
		subpanelSliders.add(greenSlider);
		subpanelSliders.add(blueSlider);
		
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

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}
