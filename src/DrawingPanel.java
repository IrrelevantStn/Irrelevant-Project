

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Class for the Drawing Panel of the Collaborative Drawing Environment
 * @author ryanx
 *
 */

public class DrawingPanel extends JPanel {
	
	private final int MAX_POINTS = 10000;
	private Point[] m_Points = new Point[MAX_POINTS];
	private int m_PointCount = 0;

	private ArrayList<String> authors = new ArrayList<String>();
	private String filepath = "";

	private Profile user;
	private BufferedImage image;
	private Color colour = Color.RED;

	private Spray spray = new Spray();

	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////

	/**
	 * Gets the colour
	 * @return
	 */
	public Color getColour() {
		return colour;
	}

	/**
	 * Sets the colour
	 * @param colour
	 */
	public void setColour(String colour) {

		switch (colour) {

		case "Black":
			this.colour = Color.BLACK;
			break;
		case "Blue":
			this.colour = Color.BLUE;
			break;
		case "Red":
			this.colour = Color.RED;
			break;
		case "Green":
			this.colour = Color.GREEN;
			break;
		case "Yellow":
			this.colour = Color.YELLOW;
			break;
		case "Orange":
			this.colour = Color.ORANGE;
			break;
		default:
			this.colour = Color.BLACK;
			break;
		}

	}

	/**
	 * Gets the filename
	 * @return
	 */
	public String getFileName() {
		return this.filepath;
	}

	/**
	 * Sets the filename
	 * @param path
	 */
	public void setFileName(String path) {
		this.filepath = path;
	}

	/**
	 * Gets the authors
	 * @return
	 */
	public ArrayList<String> getAuthors() {
		return this.authors;
	}

	/**
	 * Sets the authors
	 * @param profiles
	 */
	public void setAuthors(ArrayList<String> profiles) {
		this.authors = profiles;
	}

	/**
	 * Adds an author to the list
	 * @param profile
	 */
	public void addAuthor(String profile) {
		this.authors.add(profile);
	}

	/**
	 * The constructor for the class
	 */
	public DrawingPanel() {

			addAuthor(user.getUserName());
			image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_ARGB);

		}

	/**
	 * Method to repaint the JPanel called every time repaint();
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ovalHeight = 4;
		int ovalWidth = 4;

		g.drawImage(image, 0, 0, this);

		// g.setColor(colour);

		spray.draw(g);
		g.dispose();
		repaint();
	}

	/**
	 * Method to draw a straight line to the panel
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public void drawLine(int startX, int startY, int endX, int endY) {

		Graphics g = image.getGraphics();

		StraightLine line = new StraightLine(startX, startY, endX, endY);
		line.setColour(colour);
		line.drawLine(g);
		/*
		 * g.setColor(colour); g.drawLine(startX, startY, endX, endY);
		 * g.dispose();
		 */
		repaint();

	}

	/**
	 * Method to spray partices to the JPanel
	 * @param p
	 */
	public void spray(Point p) {

		Graphics g = image.getGraphics();

		if (spray.getPointCount() < spray.getPoints().length) {

			/* find and store point */
			spray.setPoint(p);
			spray.setColour(this.colour);
			/* increment number of points in array **/
			spray.incrementPointCount();
			/* repaint JFrame */
			spray.draw(g);

			repaint();
		}
	}

	/**
	 * Gets the point count
	 * @return
	 */
	public int getPointCount() {
		return m_PointCount;
	}

	/**
	 * Increments the point count
	 */
	public void incrementPointCount() {
		m_PointCount++;
	}

	/**
	 * Gets the list of all the points
	 * @return
	 */
	public Point[] getPoints() {
		return m_Points;
	}

	/**
	 * Sets the points
	 * @param point
	 */
	public void setPoint(Point point) {
		/*
		 * boolean test = false; if (test) { System.out.println(
		 * "PaintPanel::setPoint() - " + m_PointCount + ", " +
		 * point.toString()); }
		 */
		m_Points[getPointCount()] = point;
	}

	/**
	 * Method loads a drawing
	 * @param fileName
	 * @throws IOException
	 */
	public void loadDrawing(String fileName) throws IOException {
		image = ImageIO.read(new File(fileName));
		repaint();
	}

	/**
	 * Method saves a drawing
	 * @param filename
	 * @throws IOException
	 */
	public void saveDrawing(String filename) throws IOException {

		BufferedImage buffer = new BufferedImage(this.getSize().width, this.getSize().height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.createGraphics();
		this.paint(g);
		g.dispose();
		
		String file = "src\\" + filename + ".png"; 
		try {
			
			ImageIO.write(buffer, "png", new File(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Code for writing to textfile including names of users involved
		setFileName(file);
		
		FileWriter write = new FileWriter();
		write.writeDrawing(this);

	}

}
