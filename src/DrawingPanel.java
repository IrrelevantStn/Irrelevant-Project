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
	
	private ArrayList<Profile> authors = new ArrayList<Profile>();
	private String filepath = "";
	
	private BufferedImage image;
	private Color colour = Color.RED;

	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	public Color getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		
		switch(colour) {
		
		case "Black" :  this.colour = Color.BLACK;
						break;
		case "Blue"  :  this.colour = Color.BLUE;
						break;
		case "Red" :  	this.colour = Color.RED;
						break;
		case "Green"  : this.colour = Color.GREEN;
						break;
		case "Yellow" : this.colour = Color.YELLOW;
						break;
		case "Orange"  : this.colour = Color.ORANGE;
						break;
		default :       this.colour = Color.BLACK;
						break;
		}
		
	}
	public String getFileName() {
		return this.filepath;
	}
	
	public void setFileName(String path) {
		this.filepath = path;
	}
	
	
	public ArrayList<Profile> getAuthors() {
		return this.authors;
	}
	public void setAuthors(ArrayList<Profile> profiles) {
		this.authors = profiles;
	}
	public void addAuthor(Profile profile) {
		this.authors.add(profile);
	}
	
	public DrawingPanel() {

		image = new BufferedImage(700, 600, BufferedImage.TYPE_INT_ARGB);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ovalHeight = 4;
		int ovalWidth = 4;

		g.drawImage(image, 0, 0, this); // see javadoc for more info on the
										// parameters

		g.setColor(colour);

		for (int i = 0; i < this.getPointCount(); i++) {
			g.fillOval(getPoints()[i].x, /* upper-left x coord */
					getPoints()[i].y, /* upper-left y coord */
					ovalWidth, ovalHeight);
		}

		g.dispose();
		repaint();
	}

	public void drawLine(int startX, int startY, int endX, int endY) {

		Graphics g = image.getGraphics();

		StraightLine line = new StraightLine(startX,startY,endX,endY);
		line.setColour(colour);
		line.drawLine(g);
		/*
		g.setColor(colour);
		g.drawLine(startX, startY, endX, endY);
		g.dispose();
		*/
		repaint();

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
		/*boolean test = false;
		if (test) {
			System.out.println("PaintPanel::setPoint() - " + m_PointCount + ", " + point.toString());
		}*/
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
		ImageIO.write(buffer, "png", new File(file));
		
		//Code for writing to textfile including names of users involved
		setFileName(file);
		
		FileWriter write = new FileWriter();
		//TODO
		//write.writeDrawing(this);
		

	}

}
