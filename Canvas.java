import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	private static BufferedImage imagen;
	private static Graphics gfx;
	private final int PIXEL_SIZE = 40;
	private final int ROWS = 50;
	private final int COLUMNS = 50;
	private Color[][] casillas = new Color[ROWS][COLUMNS];
	
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
	
	public void setImage(BufferedImage imagenSet) {
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
	
	 public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.paintComponent();
    }
}
}
