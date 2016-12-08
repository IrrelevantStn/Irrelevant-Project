package Frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	
	
	 private BufferedImage image;
	 private Color colour = Color.BLACK;
	 
	 
	 
	 public Color getColour() {
		 return colour;
	 }
	 public void setColour(Color colour) {
		 this.colour = colour;
	 }
	 
	 
	 
	    public DrawingPanel() {
	       
	    	
	    	image = new BufferedImage(700,600,BufferedImage.TYPE_INT_ARGB);
	    	
	    	/*
	    	try {                
	          image = ImageIO.read(new File("C:\\Users\\ryanx\\Desktop\\picture.png"));
	          
	       } catch (IOException ex) {
	            // handle exception...
	       }
	       */
	    }
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
	
	public void drawLine(int startX,int startY, int endX, int endY) {
		
	    Graphics g = image.getGraphics();
	    
	    g.setColor(colour);
	    g.drawLine(startX, startY, endX, endY);
		g.dispose();
		
		
		
		repaint();
		
	}
	
	public void sprayCan(int x,int y) {
		Graphics g = image.getGraphics();
	    g.setColor(colour);
	    
	    
	    
	    g.fillOval(x, y, 5, 5);
		g.dispose();
		
	}
	
	
	
	
	public void loadDrawing(String fileName) throws IOException {
		image = ImageIO.read(new File(fileName));
		repaint();
}

	// Needs to be modified
	public void saveDrawing() throws IOException {
		ImageIO.write(image, "PNG", new File("temp" + ".png"));
}

}
