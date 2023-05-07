package finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Myframe extends JFrame implements ActionListener, ChangeListener {
	
	//set size for frame (1200x800) is the size of the projector
	private int height = 1200;
	private int width = 800;
	
	//colores
	Colores coloredRect = new Colores();
	private Color currentColor;
	
	private int redValue = 0, greenValue = 0, blueValue = 0;
	
	//labels
	JLabel redLabel, greenLabel,blueLabel;
	
	//export import buttons
	JButton save, open, clear;
	//colored buttons 
	JButton redButton,blueButton,greenButton,orangeButton,purpleButton,pinkButton,currentSliderColor;
	//color sliders
	JSlider redSlider, greenSlider, blueSlider;
	
	JPanel currentColPanel;
	
	Canvas canvas;
	
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
		save.setPreferredSize(new Dimension(193,20));
		save.setFocusable(false);
		save.addActionListener((ActionListener) this);
		
		open = new JButton();
		open.setBackground(Color.white);
		open.setText("OPEN");
		open.setPreferredSize(new Dimension(193,20));
		open.setFocusable(false);
		open.addActionListener(this);
		
		clear = new JButton();
		clear.setBackground(Color.white);
		clear.setText("CLEAR");
		clear.setPreferredSize(new Dimension(193,20));
		clear.setFocusable(false);
		clear.addActionListener(this);
		
		//color buttons
		redButton = new JButton();
		redButton.setBackground(new Color(255,102,102));
		redButton.setPreferredSize(new Dimension(63,63));
		redButton.setFocusable(false);
		redButton.addActionListener(this);
		
		greenButton = new JButton();
		greenButton.setBackground(new Color(0,204,0));
		greenButton.setPreferredSize(new Dimension(55,55));
		greenButton.setFocusable(false);
		greenButton.addActionListener(this);
		
		blueButton = new JButton();
		blueButton.setBackground(new Color(153,204,255));
		blueButton.setPreferredSize(new Dimension(55,55));
		blueButton.setFocusable(false);
		blueButton.addActionListener(this);
		
		orangeButton = new JButton();
		orangeButton.setBackground(new Color(255,178,102));
		orangeButton.setPreferredSize(new Dimension(63,63));
		orangeButton.setFocusable(false);
		orangeButton.addActionListener(this);
		
		purpleButton= new JButton();
		purpleButton.setBackground(new Color(255, 0, 255));
		purpleButton.setPreferredSize(new Dimension(55,55));
		purpleButton.setFocusable(false);
		purpleButton.addActionListener(this);
		
		pinkButton = new JButton();
		pinkButton.setBackground(new Color(255,153,255));
		pinkButton.setPreferredSize(new Dimension(55,55));
		pinkButton.setFocusable(false);
		pinkButton.addActionListener(this);
		
		//sliders
		redSlider = new JSlider(0,255,redValue);
		greenSlider = new JSlider(0,255,greenValue);
		blueSlider = new JSlider(0,255,blueValue);
		
		
		redSlider.setPreferredSize(new Dimension(200,100));
		redSlider.setPaintTicks(true);
		redSlider.setPaintTrack(true);
		redSlider.setMajorTickSpacing(51);
		redSlider.setOpaque(false);
		redSlider.setPaintLabels(true);
		redSlider.setOrientation(SwingConstants.HORIZONTAL);
		redSlider.addChangeListener(this);
		
		greenSlider.setPreferredSize(new Dimension(200,100));
		greenSlider.setPaintTicks(true);
		greenSlider.setPaintTrack(true);
		greenSlider.setMajorTickSpacing(51);
		greenSlider.setOpaque(false);
		greenSlider.setPaintLabels(true);
		greenSlider.setOrientation(SwingConstants.HORIZONTAL);
		greenSlider.addChangeListener(this);
		
		blueSlider.setPreferredSize(new Dimension(200,100));
		blueSlider.setPaintTicks(true);
		blueSlider.setPaintTrack(true);
		blueSlider.setMajorTickSpacing(51);
		blueSlider.setOpaque(false);
		blueSlider.setPaintLabels(true);
		blueSlider.setOrientation(SwingConstants.HORIZONTAL);
		blueSlider.addChangeListener(this);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		panel1.setBackground(Color.black);
		panel2.setBackground(Color.gray);
		panel1.setPreferredSize(new Dimension(200,800));
		panel2.setPreferredSize(new Dimension(1000,800));
		
		//subpanels
		JPanel subpanelButtons = new JPanel();
		JPanel subpanelSliders = new JPanel();
		
		subpanelButtons.setLayout(new FlowLayout(3,3,3));
		
		//grid panels
		JPanel gridPanelButtons = new JPanel();
		gridPanelButtons.setLayout(new GridLayout(3,1,2,2));
		gridPanelButtons.setBackground(Color.white);
		JPanel gridPanelColors = new JPanel();
		gridPanelColors.setLayout(new GridLayout(3,3,2,2));
		gridPanelColors.setBackground(Color.WHITE);
		JPanel gridPanelCurrentColor = new JPanel();
		gridPanelCurrentColor.setLayout(new FlowLayout(1,1,1));
		gridPanelCurrentColor.setBackground(Color.white);
		
		currentColPanel = new JPanel();
		currentColPanel.setPreferredSize(new Dimension(50,100));
		currentColPanel.setBackground(Color.white);
		
		
		
		//subpanel1
		subpanelButtons.setBackground(Color.black);
		subpanelButtons.setPreferredSize(new Dimension(200,400));
		
		
		//canvas
		canvas = new Canvas();
		
		
		//Subpanel2
		subpanelSliders.setBackground(Color.black);
		subpanelSliders.setPreferredSize(new Dimension(200,400));
		
		panel1.setLayout(new BorderLayout());
		
		
		panel1.add(subpanelButtons, BorderLayout.NORTH);
		panel1.add(subpanelSliders, BorderLayout.SOUTH);
		panel2.add(canvas);
		
		
		//adding the buttons to each layout
		gridPanelButtons.add(save);
		gridPanelButtons.add(open);
		gridPanelButtons.add(clear);
		
		gridPanelColors.add(redButton);
		gridPanelColors.add(greenButton);
		gridPanelColors.add(pinkButton);
		gridPanelColors.add(blueButton);
		gridPanelColors.add(purpleButton);
		gridPanelColors.add(orangeButton);
		gridPanelColors.add(currentColPanel);
		
		
		subpanelButtons.add(gridPanelButtons);
		subpanelButtons.add(gridPanelColors);
		
		
		subpanelSliders.add(redSlider);
		subpanelSliders.add(greenSlider);
		subpanelSliders.add(blueSlider);
		
		
		frame.add(panel1,BorderLayout.WEST);
		frame.add(panel2,BorderLayout.EAST);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	public Color currentColor(int red, int green, int blue) {
		Color burner = new Color(red,green,blue);
		currentColor = burner;
		return burner;
	}
	
	public JPanel coloredPanel(int red, int green, int blue) {
		currentColPanel.setBackground(currentColor);
		return currentColPanel;
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
		int red = redSlider.getValue();
		int green = greenSlider.getValue();
		int blue = blueSlider.getValue();
		redValue = redSlider.getValue();
		greenValue = greenSlider.getValue();
		blueValue = blueSlider.getValue();
	}
}
