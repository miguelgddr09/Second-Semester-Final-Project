package finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	
	//COLORES
	private int redValue = 0, greenValue = 0, blueValue = 0;
	
	//labels
	JLabel redValueLabel, greenValueLabel, blueValueLabel;
	
	//export import buttons
	JButton save, open, clear;
	//colored buttons 
	JButton grayButton,blueButton,blackButton,orangeButton,
	purpleButton,pinkButton,currentSliderColor;
	//color sliders
	JSlider redSlider, greenSlider, blueSlider;
	//JPanels 
	JPanel panel1, panel2, subpanelButtons, subpanelSliders,gridPanelButtons, 
	gridPanelColors, gridPanelCurrentColor, currentColorPanel;
	Canvas canvas;
	//Color currentColor = new Color(0,0,0);
	Colors functionsForPaint;
	//setCurrentColor
	
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
		
		functionsForPaint = new Colors();
		
		insideFunction();
		outsideFunctions();
		
		frame.add(panel1,BorderLayout.WEST);
		frame.add(canvas,BorderLayout.EAST);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
//this is for the buttons sliders and labels
	public void insideFunction() {
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
				grayButton = new JButton();
				grayButton.setBackground(new Color(128,128,128));
				grayButton.setPreferredSize(new Dimension(55,55));
				grayButton.setFocusable(false);
				grayButton.addActionListener(this);
				
				blackButton = new JButton();
				blackButton.setBackground(new Color(0,0,0));
				blackButton.setPreferredSize(new Dimension(55,55));
				blackButton.setFocusable(false);
				blackButton.addActionListener(this);
				
				blueButton = new JButton();
				blueButton.setBackground(new Color(153,204,255));
				blueButton.setPreferredSize(new Dimension(55,55));
				blueButton.setFocusable(false);
				blueButton.addActionListener(this);
				
				orangeButton = new JButton();
				orangeButton.setBackground(new Color(255,178,102));
				orangeButton.setPreferredSize(new Dimension(55,5));
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
				//label for value
				redValueLabel = new JLabel();
				
				greenSlider.setPreferredSize(new Dimension(200,100));
				greenSlider.setPaintTicks(true);
				greenSlider.setPaintTrack(true);
				greenSlider.setMajorTickSpacing(51);
				greenSlider.setOpaque(false);
				greenSlider.setPaintLabels(true);
				greenSlider.setOrientation(SwingConstants.HORIZONTAL);
				greenSlider.addChangeListener(this);
				//label for value
				greenValueLabel = new JLabel();
				
				blueSlider.setPreferredSize(new Dimension(200,100));
				blueSlider.setPaintTicks(true);
				blueSlider.setPaintTrack(true);
				blueSlider.setMajorTickSpacing(51);
				blueSlider.setOpaque(false);
				blueSlider.setPaintLabels(true);
				blueSlider.setOrientation(SwingConstants.HORIZONTAL);
				blueSlider.addChangeListener(this);
				//label for value
				blueValueLabel = new JLabel();
	}

//this creates the panels 
	public void outsideFunctions() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		
		panel1.setBackground(Color.black);
		panel2.setBackground(Color.gray);
		panel1.setPreferredSize(new Dimension(200,800));
		panel2.setPreferredSize(new Dimension(1000,800));
		
		//subpanels
		subpanelButtons = new JPanel();
		subpanelSliders = new JPanel();
		
		subpanelButtons.setLayout(new FlowLayout(3,3,3));
		
		currentColorPanel = new JPanel();
		
		//grid panels
		gridPanelButtons = new JPanel();
		gridPanelButtons.setLayout(new GridLayout(3,1,2,2));
		gridPanelButtons.setBackground(Color.white);
		gridPanelColors = new JPanel();
		gridPanelColors.setLayout(new GridLayout(3,3,2,2));
		gridPanelColors.setBackground(Color.WHITE);
		gridPanelCurrentColor = new JPanel();
		gridPanelCurrentColor.setLayout(new FlowLayout(1,1,1));
		gridPanelCurrentColor.setBackground(Color.white);
		
		//subpanel1
		subpanelButtons.setBackground(Color.white);
		subpanelButtons.setPreferredSize(new Dimension(200,400));
		
		currentColorPanel.setBackground(Color.white);
		currentColorPanel.setPreferredSize(new Dimension(50,170));
		
		//canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(1000,800));
		
		//Subpanel2
		subpanelSliders.setBackground(Color.white);
		subpanelSliders.setPreferredSize(new Dimension(200,400));
		
		panel1.setLayout(new BorderLayout());
		
		
		panel1.add(subpanelButtons, BorderLayout.NORTH);
		panel1.add(subpanelSliders, BorderLayout.SOUTH);
		panel2.add(canvas);
		
		
		//adding the buttons to each layout
		gridPanelButtons.add(save);
		gridPanelButtons.add(open);
		gridPanelButtons.add(clear);
		
		gridPanelColors.add(grayButton);
		gridPanelColors.add(blackButton);
		gridPanelColors.add(pinkButton);
		gridPanelColors.add(blueButton);
		gridPanelColors.add(purpleButton);
		gridPanelColors.add(orangeButton);
		
		
		subpanelButtons.add(gridPanelButtons);
		subpanelButtons.add(gridPanelColors);
		subpanelButtons.add(currentColorPanel);
		
		
		subpanelSliders.add(redSlider);
		subpanelSliders.add(redValueLabel);
		subpanelSliders.add(greenSlider);
		subpanelSliders.add(greenValueLabel);
		subpanelSliders.add(blueSlider);
		subpanelSliders.add(blueValueLabel);
	}
	
	public JPanel setCurrentPanel() {
		currentColorPanel.setBackground(functionsForPaint.getCurrColor());
		return currentColorPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==save) {
			System.out.println("Please kill yourself");
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			fileChooser.showSaveDialog(null);//select file to save
		}
		else if(e.getSource()==open) {
			System.out.println("Or dont");
			JFileChooser fileChooser= new JFileChooser();
			fileChooser.showOpenDialog(null); //select file to open
		}
		else if(e.getSource()==clear) {
			System.out.println("Please finish this quick");
		}
		
		if(e.getSource()==grayButton) {
			redValue = 128;
			greenValue = 128;
			blueValue = 128;
			System.out.println(redValue + " "+ greenValue+" "+blueValue+"\n");
			//Color changedColors = new Color(redValue, greenValue, blueValue);
			functionsForPaint.setCurrentColor(redValue, greenValue, blueValue);
			setCurrentPanel();
		}
		if(e.getSource()==blackButton) {
			//0,204,0
			redValue = 0;
			greenValue = 0;
			blueValue = 0;
			System.out.println(redValue + " "+ greenValue+" "+blueValue+"\n");
			Color changedColors = new Color(redValue, greenValue, blueValue);
			functionsForPaint.setCurrentColor(redValue, greenValue, blueValue);
			setCurrentPanel();
		}
		if(e.getSource()==blueButton) {
			//153,204,255
			redValue = 153;
			greenValue = 204;
			blueValue = 255;
			System.out.println(redValue + " "+ greenValue+" "+blueValue+"\n");
			Color changedColors = new Color(redValue, greenValue, blueValue);
			functionsForPaint.setCurrentColor(redValue, greenValue, blueValue);
			setCurrentPanel();
		}
		if(e.getSource()==orangeButton) {
			//255,178,102
			redValue = 255;
			greenValue = 178;
			blueValue = 102;
			System.out.println(redValue + " "+ greenValue+" "+blueValue+"\n");
			Color changedColors = new Color(redValue, greenValue, blueValue);
			functionsForPaint.setCurrentColor(redValue, greenValue, blueValue);
			setCurrentPanel();
		}
		if(e.getSource()==purpleButton) {
			//255, 0, 255
			redValue = 255;
			greenValue = 0;
			blueValue = 255;
			System.out.println(redValue + " "+ greenValue+" "+blueValue+"\n");
			Color changedColors = new Color(redValue, greenValue, blueValue);
			functionsForPaint.setCurrentColor(redValue, greenValue, blueValue);
			setCurrentPanel();
		}
		if(e.getSource()==pinkButton) {
			//(255,153,255)
			redValue = 255;
			greenValue = 153;
			blueValue = 255;
			System.out.println(redValue + " "+ greenValue+" "+blueValue+"\n");
			Color changedColors = new Color(redValue, greenValue, blueValue);
			functionsForPaint.setCurrentColor(redValue, greenValue, blueValue);
			setCurrentPanel();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		redValueLabel.setText("R: "+redSlider.getValue());
		redValue=redSlider.getValue();
		greenValueLabel.setText("G: "+greenSlider.getValue());
		greenValue=greenSlider.getValue();
		blueValueLabel.setText("B: "+blueSlider.getValue());
		blueValue=blueSlider.getValue();
		System.out.println(redValue + " " + greenValue + " " + blueValue);
		Color changedColors = new Color(redValue, greenValue, blueValue);
		functionsForPaint.setCurrentColor(redValue, greenValue, blueValue);
		System.out.println(functionsForPaint.getCurrColor());
		setCurrentPanel();
	}
}
