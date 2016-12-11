import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Spray {

	
	public int getPointCount() {
		return m_PointCount;
	}

	/**
	 * @return TRUE on success
	 */
	public boolean incrementPointCount() {
		m_PointCount++;
		return true;
	}

	/**
	 * @return the current number of points
	 */
	public Point[] getPoints() {
		return m_Points;
	}

	/**
	 * @return TRUE on success
	 */
	public boolean setPoint(Point point) {
		m_Points[getPointCount()] = point;
		return true;
	}
	

	
	public Spray() {
		m_colour = Color.BLACK;
		
	}


	public Color getColor() {
		return m_colour;
	}

	public void setColour(Color colour) {
		this.m_colour = colour;
	}

	public void draw(Graphics g) {
		g.setColor(m_colour);
		
		 for (int i = 0; i < this.getPointCount(); i++) {
			 g.fillOval(getPoints()[i].x, getPoints()[i].y, WIDTH,
					 HEIGHT);
		 }
		  
		g.dispose();

	}
	
	private Color m_colour;
	private final int WIDTH = 4;
	private final int HEIGHT = 4;
	private final int MAX_POINTS = 10000;
	private Point[] m_Points = new Point[MAX_POINTS];
	private int m_PointCount = 0;
	
}
