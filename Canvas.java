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
	
	private static BufferedImage imagen;
	private static Graphics gfx;
	private final int PIXEL_SIZE = 40;
	private final int ROWS = 20;
	private final int COLUMNS = 25;
	private Color[][] casillas = new Color[ROWS][COLUMNS];
	private int x,y;
	
	Colors colorsFunctions;
	
	private void resetCanvas() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				casillas[i][j] = Color.WHITE;
			}
		}
		repaint();
	}
	
	public void paintPixel(int row, int col, Color color) {
		gfx.setColor(color);
		gfx.fillRect(col * PIXEL_SIZE, row * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
		repaint();
	}
	
	public void setColor(int row, int col, Color color) {
		casillas[row][col] = color;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagen, 0, 0, null);
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				g.setColor(Color.BLACK);
				g.drawRect(j * PIXEL_SIZE, i * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COLUMNS * PIXEL_SIZE, ROWS * PIXEL_SIZE);
	}
	
	/*
	 * for (int filas = 0; fila < filas; fila++) {
            for (int col = 0; col < cols; col++) {
                JPanel cuadrado = cuadrado[fila][col];
                cuadrado.addMouseListener(new MouseAdapter() {
                      cuadrado.setBackground(lapiz con current color);
	 * */
	
	public void setImage(BufferedImage imagenSet) {
		addMouseMotionListener(this);
		imagen = imagenSet;
		gfx = imagen.createGraphics();
		resetCanvas();
	}
	
	public Graphics getGfx() {
		return gfx;
	}
	
	public BufferedImage getImagen() {
		return imagen;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(x + " "+ y);
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}