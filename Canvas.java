package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseMotionListener, MouseListener{
	
	private int x,y;
	static BufferedImage img;
	static Graphics gfx;	
	private final static int PIXEL_SIZE = 40;
	Colors colorObject = new Colors();
	
	public Canvas() {		
		addMouseMotionListener(this);
		setBackground(Color.white);
		img = new BufferedImage(1000, 800, BufferedImage.TYPE_INT_RGB);
		gfx = img.createGraphics();
		this.addMouseListener(this);
		drawBackground(PIXEL_SIZE, Color.white);
		drawSquareGrid(PIXEL_SIZE, Color.black);
	}
	
	private static void drawSquareGrid(int size, Color c) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {                
            	gfx.setColor(c);
            	gfx.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }
    private static void drawBackground(int size, Color c) {
    	for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
            	gfx.setColor(c);
            	gfx.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);                
            }
        }
    }
    
    private static void putPixel(int x, int y, Color c){       
    	gfx.setColor(c);
    	gfx.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);    
     }
    private static void fillRect(int x, int y, int width, int height, Color c){
    	gfx.setColor(c);
    	gfx.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, width*PIXEL_SIZE, height*PIXEL_SIZE);
    }
	 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, 0, 0, null);
	    g.setColor(Color.yellow);
	    g.fillOval(x-5, y-5, 10, 10);
	    //g.fillRect(x, y, PIXEL_SIZE, PIXEL_SIZE);
	    //g.setColor(colorObject.getCurrColor());
	}

	public void setImage(BufferedImage image) {
		img = image;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX(); //get the x and y coordinates of
		y = e.getY(); //the mouse click point
		
		repaint();
	}
	
	public Graphics getGraphic() {
		return gfx;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		gfx.setColor(colorObject.getCurrColor());
		gfx.fillRect(x, y, PIXEL_SIZE, PIXEL_SIZE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
