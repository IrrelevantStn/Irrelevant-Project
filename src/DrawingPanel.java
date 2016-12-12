

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



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

	public Color getColour() {
		return colour;
	}

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

	public String getFileName() {
		return this.filepath;
	}

	public void setFileName(String path) {
		this.filepath = path;
	}

	public ArrayList<String> getAuthors() {
		return this.authors;
	}

	public void setAuthors(ArrayList<String> profiles) {
		this.authors = profiles;
	}

	public void addAuthor(String profile) {
		this.authors.add(profile);
	}

	public DrawingPanel() {

			addAuthor(user.getUserName());
			image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_ARGB);

		}

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

	public int getPointCount() {
		return m_PointCount;
	}

	public void incrementPointCount() {
		m_PointCount++;
	}

	public Point[] getPoints() {
		return m_Points;
	}

	public void setPoint(Point point) {
		/*
		 * boolean test = false; if (test) { System.out.println(
		 * "PaintPanel::setPoint() - " + m_PointCount + ", " +
		 * point.toString()); }
		 */
		m_Points[getPointCount()] = point;
	}

	public void loadDrawing(String fileName) throws IOException {
		image = ImageIO.read(new File(fileName));
		repaint();
	}

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
