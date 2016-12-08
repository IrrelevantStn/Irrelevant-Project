import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class DrawingView extends JFrame {
	//////////////////////////////////////////////////////
	// Get and sets for the labels
	//////////////////////////////////////////////////////

	public JLabel getTitleLbl() {
		return m_titleLbl;
	}

	public Boolean setTitleLbl(JLabel lbl) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setTitleLabel() BEGIN");
		}
		m_titleLbl = lbl;
		return true;
	}

	public JLabel getLoadLbl() {
		return m_loadLbl;
	}

	public JLabel getLineLbl() {
		return m_lineLbl;
	}

	public JLabel getParticleLbl() {
		return m_particleLbl;
	}

	public JLabel getColorLbl() {
		return m_colorLbl;
	}

	public JLabel getSaveLbl() {
		return m_saveLbl;
	}

	public Boolean setLoadLbl(JLabel lbl) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setLoadLabel() BEGIN");
		}
		m_loadLbl = lbl;
		return true;
	}

	public Boolean setLineLbl(JLabel lbl) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setLineLabel() BEGIN");
		}
		m_lineLbl = lbl;
		return true;
	}

	public Boolean setParticleLbl(JLabel lbl) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setParticleLabel() BEGIN");
		}
		m_particleLbl = lbl;
		return true;
	}

	public Boolean setColorLbl(JLabel lbl) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setColorLabel() BEGIN");
		}
		m_colorLbl = lbl;
		return true;
	}

	public Boolean setSaveLbl(JLabel lbl) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setSaveLabel() BEGIN");
		}
		m_saveLbl = lbl;
		return true;
	}

	///////////////////////////////////////////////////////////////////////
	// Get and sets for the buttons
	//////////////////////////////////////////////////////////////////////

	public JButton getLoadBtn() {
		return m_loadBtn;
	}

	public JButton getLineBtn() {
		return m_lineBtn;
	}

	public JButton getParticleBtn() {
		return m_particleBtn;
	}

	public JButton getSaveBtn() {
		return m_saveBtn;
	}

	public Boolean setLoadBtn(JButton btn) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setLoadBtn() BEGIN");
		}
		m_loadBtn = btn;
		return true;
	}

	public Boolean setLineBtn(JButton btn) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setLineBtn() BEGIN");
		}
		m_lineBtn = btn;
		return true;
	}

	public Boolean setParticleBtn(JButton btn) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setParticleBtn() BEGIN");
		}
		m_particleBtn = btn;
		return true;
	}

	public Boolean setSaveBtn(JButton btn) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setSaveBtn() BEGIN");
		}
		m_saveBtn = btn;
		return true;
	}

	////////////////////////////////////////////////////////////////////
	// Set and Get all the Combo boxes
	////////////////////////////////////////////////////////////////////

	public JComboBox<String> getChooseDrawings() {
		return m_chooseDrawings;
	}

	public JButton getChooseColorBtn() {
		return m_chooseColor;
	}

	public Boolean setChooseDrawings(JComboBox<String> combo) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setChooseDrawings() BEGIN");
		}
		m_chooseDrawings = combo;
		return true;
	}

	public Boolean setChooseColorBtn(JButton btn) {
		boolean test = true;
		if (test || m_Trace) {
			System.out.println("DrawingView::setChooseColor() BEGIN");
		}
		m_chooseColor = btn;
		return true;
	}

	//////////////////////////////////////////////////////////////////////////
	// Get and set for the int values
	//////////////////////////////////////////////////////////////////////////

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setStartX(int x) {
		startX = x;
	}

	public void setStartY(int y) {
		startY = y;
	}

	public void setEndX(int x) {
		endX = x;
	}

	public void setEndY(int y) {
		endY = y;
	}

	/////////////////////////////////////////////////////////

	/**
	 * Constructor
	 */
	public DrawingView() {

		// Set up JFrame
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		////////////////////////////////////////////////////
		// Set up Drawing Panel
		m_contentPane = new DrawingPanel();
		m_contentPane.setBackground(Color.WHITE);
		add(m_contentPane);
		
		

		// Side pane where all buttons and labels will be
		m_sidePane = new JPanel();
		m_sidePane.setBackground(Color.GRAY);
		m_sidePane.setPreferredSize(new Dimension(100, 50));
		add(m_sidePane, BorderLayout.EAST);

		BtnHandler handler = new BtnHandler(this);

		// Add labels

		this.setTitleLbl(new JLabel());
		this.getTitleLbl().setText(DRAWINGS);

		this.setLoadLbl(new JLabel());
		this.getLoadLbl().setText(LOAD_TITLE);

		this.setLineLbl(new JLabel());
		this.getLineLbl().setText(LINE_TITLE);

		this.setParticleLbl(new JLabel());
		this.getParticleLbl().setText(SPRAY_TITLE);

		this.setColorLbl(new JLabel());
		this.getColorLbl().setText(COLOUR_TITLE);

		this.setSaveLbl(new JLabel());
		this.getSaveLbl().setText(SAVE_TITLE);

		// Add buttons

		this.setLoadBtn(new JButton());
		this.getLoadBtn().setText("Load");
		this.getLoadBtn().addMouseListener(handler);

		this.setLineBtn(new JButton());
		this.getLineBtn().setText("Line");
		this.getLineBtn().addMouseListener(handler);

		this.setParticleBtn(new JButton());
		this.getParticleBtn().setText("Spray");
		this.getParticleBtn().addMouseListener(handler);

		this.setSaveBtn(new JButton());
		this.getSaveBtn().setText("Save");
		this.getSaveBtn().addMouseListener(handler);

		this.setChooseColorBtn(new JButton());
		this.getChooseColorBtn().setText("Chose Colour");
		this.getChooseColorBtn().addMouseListener(handler);

		// add combo boxes
		this.setChooseDrawings(new JComboBox<String>());
		String[] drawings = { "one", "two", "three", "four", "five" };
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(drawings);
		this.getChooseDrawings().setModel(model);

		// Add components to the side panel
		m_sidePane.add(getTitleLbl());
		m_sidePane.add(getChooseDrawings());
		m_sidePane.add(getLoadBtn());
		m_sidePane.add(getLineLbl());
		m_sidePane.add(getLineBtn());
		m_sidePane.add(getParticleLbl());
		m_sidePane.add(getParticleBtn());
		m_sidePane.add(getSaveBtn());

		m_contentPane.addMouseListener(handler);

		System.out.println(m_contentPane.getWidth());
		System.out.println(m_contentPane.getHeight());

		setVisible(true);
		System.out.println(m_contentPane.getWidth());
		System.out.println(m_contentPane.getHeight());
		
		m_contentPane.drawLine(50, 50, 100, 150);
		m_contentPane.validate();
		m_contentPane.repaint();
		repaint();
	}

	public void drawLine(int x, int y) {

		JLabel particle = new JLabel();
		this.add(particle, BorderLayout.SOUTH);
		
		if (isStart) {

			startX = x;
			startY = y;
			particle.setText("Click an end point for your line");
			this.validate();
			this.repaint();
			System.out.println("Start co-ords");
			System.out.println(startX);
			System.out.println(startY);
			isStart = false;

		} else {
			endX = x;
			endY = y;
			this.remove(particle);
			this.validate();
			this.repaint();
			System.out.println("End co-ords");
			System.out.println(endX);
			System.out.println(endY);
			isStart = true;
			m_contentPane.drawLine(startX,startY,endX,endY);
			m_contentPane.validate();
			m_contentPane.repaint();
			repaint();
			
		}

	}
	
	public void drawParticles(int x, int y) {
		
		m_contentPane.sprayCan(x, y);
		m_contentPane.validate();
		m_contentPane.repaint();
		repaint();
	}


	private class BtnHandler implements MouseListener,MouseMotionListener {

		private JFrame frame;
		
		public BtnHandler(JFrame frame) {
			this.frame = frame;
			
		}

		@Override
	      public void mouseDragged(MouseEvent event) {

	          boolean test = false;
	          if (test) {
	            System.out.println("PaintHandler::mouseDragged() " + event.toString());
	          }

	         // if ( getPointCount() < getPoints().length ) {

	             /* find and store point */
	           //  setPoint(event.getPoint());
	             /* increment number of points in array **/
	           //  incrementPointCount();
	             /* repaint JFrame */
	             repaint();

	          } /* end if                             */



		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == getLineBtn() ) {
				//Line code here
				
				if (!traceLine) {
					JLabel particle = new JLabel();
					particle.setText("Click a start point for your line");
					frame.add(particle,BorderLayout.SOUTH);
					frame.validate();
					frame.repaint();
					traceLine = true;
				}
				
				drawMode = 0;
			
			} else if (e.getSource() == getParticleBtn()) {
				//Spray can code here
				drawMode = 1;
				
			} else if (e.getSource() == getLoadBtn()) {
				//load the drawing
				try {
					
					m_contentPane.loadDrawing(m_chooseDrawings.getSelectedItem().toString());
					
				} catch (IOException exception) {
					System.out.println("Could not load the file");
				}
				
			} else if (e.getSource() == getSaveBtn()) {
				//save the drawing
				try {
					m_contentPane.saveDrawing();
				} catch(IOException exception) {
					System.out.println("Could not save the file");
				}
				
			}	
		}



		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Mouse Clicked at .." + e.getLocationOnScreen());

			if (drawMode == 0) {
				drawLine(e.getX(),e.getY());
			} else {
				drawParticles(e.getX(),e.getY());
			}
			
		}


	       /**
	        * This method is defined in MouseMotionListener.
	        */
		@Override
	       public void mouseMoved(MouseEvent event) {

	          boolean test = false;
	          if (test) {
	            System.out.println("PaintHandler::mouseMoved() " + event.toString());
	          }
	          
	          if (drawMode == 1) {
	        	  drawParticles(event.getX(),event.getY());
	          }
	          
	          
	       }

	       /**
	        * This method is defined in MouseListener.
	        */
		@Override
	       public void mouseEntered(MouseEvent event) {

	          boolean test = true;
	          if (test) {
	            System.out.println("PaintHandler::mouseEntered() " + event.toString());
	          }
	       }

	       /**
	        * This method is defined in MouseListener.
	        */
		@Override
	       public void mouseExited(MouseEvent event) {

	          boolean test = true;
	          if (test) {
	            System.out.println("PaintHandler::mouseExited() " + event.toString());
	          }
	       }




	       /**
	        * This method is defined in MouseListener.
	        */
		@Override
	          public void mouseReleased(MouseEvent event) {

	        	  boolean test = true;
	        	  if (test) {
	        		  System.out.println("PaintHandler::mouseReleased() " + event.toString());
	        	  }
	        		  
	        	  
	          }
		
		
	} 

	
	private Boolean isStart = true;
	private Boolean traceLine = false;
	private int drawMode = 0;  // 0 for straight line, 1 for Spray Can 
	private Boolean m_Trace;

	// Drawing JPanel
	private DrawingPanel m_contentPane;
	private JPanel m_sidePane;

	// ALL THE LABELS
	private JLabel m_titleLbl;
	private JLabel m_loadLbl;
	private JLabel m_lineLbl;
	private JLabel m_particleLbl;
	private JLabel m_colorLbl;
	private JLabel m_saveLbl;

	// ALL THE BUTTONS -- some might be image buttons
	private JButton m_loadBtn;
	private JButton m_lineBtn;
	private JButton m_particleBtn;
	private JButton m_saveBtn;
	private JButton m_chooseColor;
	
	// ALL THE COMBO BOXES
	private JComboBox<String> m_chooseDrawings;


	// ALL CONSTANT STRING VALUES
	private final String TITLE = "Collaborative Drawing Environment";
	private final String DRAWINGS = "Your Drawings";
	private final String LINE_TITLE = "Straight Line";
	private final String SPRAY_TITLE = "Spray Can";
	private final String COLOUR_TITLE = "Colour";
	private final String SAVE_TITLE = "Save";
	private final String LOAD_TITLE = "Load";

	// Int values to be passed into DrawingPalette class

	int startX;
	int startY;
	int endX;
	int endY;

	// ALL CONSTANT INT VALUES
	/*
	 * private final int PANEL_SIZE= 0; private final int COMBO_SIZE; private
	 * final int BUTTON_SIZE; private final int LABEL_SIZE;
	 */
}