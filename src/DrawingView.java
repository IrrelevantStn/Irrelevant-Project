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

import javax.swing.border.EmptyBorder;

import java.awt.Color;

/**
 * Class for the GUI of the Collaborative Drawing Environment
 * @author ryanx
 *
 */
public class DrawingView extends JFrame {
	//////////////////////////////////////////////////////
	// Get and sets for the text field
	//////////////////////////////////////////////////////

	/**
	 * Gets the file field
	 * @return file field JTextField
	 */
	public JTextField getFileField() {
		return m_filename;
	}

	/**
	 * Sets the file field
	 * @param field
	 * @return
	 */
	public Boolean setFileField(JTextField field) {
		m_filename = field;
		return true;
	}

	//////////////////////////////////////////////////////
	// Get and sets for the labels
	//////////////////////////////////////////////////////

	/**
	 * Gets the File Name Label
	 * @return JLabel file name
	 */
	public JLabel getFileNameLbl() {
		return m_filenameLbl;
	}

	/**
	 * Sets the file name label
	 * @param lbl
	 * @return
	 */
	public Boolean setFileNameLbl(JLabel lbl) {
		m_filenameLbl = lbl;
		return true;
	}

	/**
	 * Gets the title label
	 * @return JLabel title
	 */
	public JLabel getTitleLbl() {
		return m_titleLbl;
	}

	/**
	 * Sets the title label
	 * @param lbl
	 * @return
	 */
	public Boolean setTitleLbl(JLabel lbl) {
		m_titleLbl = lbl;
		return true;
	}

	/**
	 * Gets the load label
	 * @return JLabel load label
	 */
	public JLabel getLoadLbl() {
		return m_loadLbl;
	}

	/**
	 * Gets the line label
	 * @return JLabel line
	 */
	public JLabel getLineLbl() {
		return m_lineLbl;
	}

	/**
	 * Gets the particle label
	 * @return JLabel particle
	 */
	public JLabel getParticleLbl() {
		return m_particleLbl;
	}

	/**
	 * Gets the colour label
	 * @return JLabel colour
	 */
	public JLabel getColorLbl() {
		return m_colorLbl;
	}

	/**
	 * Gets the save label
	 * @return JLabel save
	 */
	public JLabel getSaveLbl() {
		return m_saveLbl;
	}

	/**
	 * Sets the load label
	 * @param lbl
	 * @return
	 */
	public Boolean setLoadLbl(JLabel lbl) {
		m_loadLbl = lbl;
		return true;
	}

	/**
	 * Sets the line label
	 * @param lbl
	 * @return
	 */
	public Boolean setLineLbl(JLabel lbl) {
		m_lineLbl = lbl;
		return true;
	}

	/**
	 * Sets the particle label
	 * @param lbl
	 * @return
	 */
	public Boolean setParticleLbl(JLabel lbl) {
		m_particleLbl = lbl;
		return true;
	}

	/**
	 * Sets the colour label
	 * @param lbl
	 * @return
	 */
	public Boolean setColorLbl(JLabel lbl) {
		m_colorLbl = lbl;
		return true;
	}

	/**
	 * Sets the save label
	 * @param lbl
	 * @return
	 */
	public Boolean setSaveLbl(JLabel lbl) {
		m_saveLbl = lbl;
		return true;
	}

	///////////////////////////////////////////////////////////////////////
	// Get and sets for the buttons
	//////////////////////////////////////////////////////////////////////

	/**
	 * Gets the load button
	 * @return JButton load
	 */
	public JButton getLoadBtn() {
		return m_loadBtn;
	}

	/**
	 * Gets the line button
	 * @return JButton line
	 */
	public JButton getLineBtn() {
		return m_lineBtn;
	}

	/**
	 * Gets the particle button
	 * @return JButton particle
	 */
	public JButton getParticleBtn() {
		return m_particleBtn;
	}

	/**
	 * Gets the save button
	 * @return JButton save
	 */
	public JButton getSaveBtn() {
		return m_saveBtn;
	}

	/**
	 * Sets the load button
	 * @param btn
	 * @return
	 */
	public Boolean setLoadBtn(JButton btn) {
		m_loadBtn = btn;
		return true;
	}

	/**
	 * Sets the line button
	 * @param btn
	 * @return
	 */
	public Boolean setLineBtn(JButton btn) {
		m_lineBtn = btn;
		return true;
	}

	/**
	 * Sets the particle button
	 * @param btn
	 * @return
	 */
	public Boolean setParticleBtn(JButton btn) {
		m_particleBtn = btn;
		return true;
	}

	/**
	 * Sets the save button
	 * @param btn
	 * @return
	 */
	public Boolean setSaveBtn(JButton btn) {
		m_saveBtn = btn;
		return true;
	}

	////////////////////////////////////////////////////////////////////
	// Set and Get all the Combo boxes
	////////////////////////////////////////////////////////////////////

	/**
	 * Gets the colour combo box
	 * @return JComboBox choose colour
	 */
	public JComboBox<String> getChooseColour() {
		return m_chooseColour;
	}

	/**
	 * Sets the colour combo box
	 * @param box
	 */
	public void setChooseColour(JComboBox<String> box) {
		m_chooseColour = box;
	}

	/**
	 * Gets the drawings combo box
	 * @return JComboBox Choose Drawings
	 */
	public JComboBox<String> getChooseDrawings() {
		return m_chooseDrawings;
	}

	/**
	 * Gets the choose colour button
	 * @return JButton Choose Colour
	 */
	public JButton getChooseColorBtn() {
		return m_chooseColor;
	}

	/**
	 * Sets the Choose Drawings Combo Box
	 * @param combo
	 * @return
	 */
	public Boolean setChooseDrawings(JComboBox<String> combo) {
		m_chooseDrawings = combo;
		return true;
	}

	/**
	 * Sets the Choose Colour button
	 * @param btn
	 * @return
	 */
	public Boolean setChooseColorBtn(JButton btn) {
		m_chooseColor = btn;
		return true;
	}

	//////////////////////////////////////////////////////////////////////////
	// Get and set for the int values
	//////////////////////////////////////////////////////////////////////////

	/**
	 * Gets the startX value
	 * @return int x
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * Gets the startY value
	 * @return int y
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * Gets the EndX value
	 * @return int x
	 */
	public int getEndX() {
		return endX;
	}

	/**
	 * Gets the endY value
	 * @return int y
	 */
	public int getEndY() {
		return endY;
	}

	/**
	 * Sets the startX value
	 * @param x
	 */
	public void setStartX(int x) {
		startX = x;
	}

	/**
	 * Sets the StartY value
	 * @param y
	 */
	public void setStartY(int y) {
		startY = y;
	}

	/**
	 * Sets the endX value
	 * @param x
	 */
	public void setEndX(int x) {
		endX = x;
	}

	/**
	 * Sets the endY value
	 * @param y
	 */
	public void setEndY(int y) {
		endY = y;
	}

	/////////////////////////////////////////////////////////

	/**
	 * Loads the drawings into the arraylist of drawings
	 * @param users
	 * @param user
	 */
	public void loadDrawings(Graph users, Profile user) {

		FileReader read = new FileReader();
		ArrayList<String> temp = read.readDrawings(users, user);
		drawings = new String[temp.size()];
		for (int i = 0; i < temp.size() - 1; i++) {
			drawings[i] = temp.get(i);
		}

	}

	/**
	 * Constructor
	 */
	public DrawingView(Graph users, Profile user) {

		// loadDrawings(users,user);

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

		this.setFileField(new JTextField(6));

		// Add labels

		this.setFileNameLbl(new JLabel());
		this.getFileNameLbl().setText(SAVE_LABEL);

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
		// String[] drawings = { "one", "two", "three", "four", "five" };
		drawings = new String[5];
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(drawings);
		this.getChooseDrawings().setModel(model);

		this.setChooseColour(new JComboBox<String>());
		DefaultComboBoxModel<String> colourModel = new DefaultComboBoxModel<String>(COLOURS);
		this.getChooseColour().setModel(colourModel);

		// Add components to the side panel
		m_sidePane.add(getTitleLbl());
		m_sidePane.add(getChooseDrawings());
		m_sidePane.add(getLoadBtn());
		m_sidePane.add(getLineLbl());
		m_sidePane.add(getLineBtn());
		m_sidePane.add(getParticleLbl());
		m_sidePane.add(getParticleBtn());
		m_sidePane.add(getFileNameLbl());
		m_sidePane.add(getChooseColour());
		m_sidePane.add(getFileField());
		m_sidePane.add(getSaveBtn());

		m_contentPane.addMouseListener(handler);
		m_contentPane.addMouseMotionListener(handler);

		setVisible(true);

		// m_contentPane.drawLine(50, 50, 100, 150);
		// m_contentPane.validate();
		// m_contentPane.repaint();
		// repaint();
	}

	/**
	 * Method to get the gui to allow the user to draw Straight Lines
	 * @param x
	 * @param y
	 */
	public void drawLine(int x, int y) {

		JLabel particle = new JLabel();
		this.add(particle, BorderLayout.SOUTH);

		if (drawMode == 0) {

			if (isStart) {

				startX = x;
				startY = y;
				particle.setText("Click an end point for your line");
				this.validate();
				this.repaint();
				isStart = false;
			} else {
				endX = x;
				endY = y;
				this.remove(particle);
				this.validate();
				this.repaint();
				isStart = true;
				m_contentPane.setColour(getChooseColour().getSelectedItem().toString());
				m_contentPane.drawLine(startX, startY, endX, endY);
				m_contentPane.validate();
				m_contentPane.repaint();
				repaint();
				drawMode = -1;
			}
		}
	}

	/**
	 * Method for gui to allow user to draw Particles
	 * @param x
	 * @param y
	 */
	public void drawParticles(int x, int y) {
		m_contentPane.validate();
		m_contentPane.repaint();
		repaint();
	}

	/**
	 * Class to handle button click actions
	 * @author ryanx
	 *
	 */
	private class BtnHandler implements MouseListener, MouseMotionListener {

		private JFrame frame;

		public BtnHandler(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void mouseDragged(MouseEvent event) {
			if (drawMode == 1) {

				m_contentPane.setColour(getChooseColour().getSelectedItem().toString());
				m_contentPane.spray(event.getPoint());

				repaint();
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getSource() == getLineBtn()) {
				// Line code here
				/*
				 * if (isStart == true) { JLabel particle = new JLabel();
				 * particle.setText("Click a start point for your line");
				 * frame.add(particle,BorderLayout.SOUTH); frame.validate();
				 * frame.repaint(); isStart = false; }
				 */
				drawMode = 0;

			} else if (e.getSource() == getParticleBtn()) {
				// Spray can code here
				drawMode = 1;

			} else if (e.getSource() == getLoadBtn()) {
				// load the drawing
				try {

					m_contentPane.loadDrawing(m_chooseDrawings.getSelectedItem().toString());

				} catch (IOException exception) {
					System.out.println("Could not load the file");
				}

			} else if (e.getSource() == getSaveBtn()) {
				// save the drawing
				try {
					m_contentPane.saveDrawing(m_filename.getText());
				} catch (IOException exception) {
					System.out.println("Could not save the file");
				}

			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Mouse Clicked at .." + e.getLocationOnScreen());

			if (drawMode == 0) {
				drawLine(e.getX(), e.getY());
			} else {
				drawParticles(e.getX(), e.getY());
			}
		}

		/**
		 * This method is defined in MouseMotionListener.
		 */
		@Override
		public void mouseMoved(MouseEvent event) {
			if (drawMode == 1) {
				drawParticles(event.getX(), event.getY());
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
	private int drawMode = -1; // -1 for nothing, 0 for straight line, 1 for
	// Spray Can
	private Boolean m_Trace;

	// Drawing JPanel
	private DrawingPanel m_contentPane;
	private JPanel m_sidePane;

	// Text fields
	private JTextField m_filename;

	// ALL THE LABELS
	private JLabel m_titleLbl;
	private JLabel m_loadLbl;
	private JLabel m_lineLbl;
	private JLabel m_particleLbl;
	private JLabel m_colorLbl;
	private JLabel m_saveLbl;
	private JLabel m_filenameLbl;

	// ALL THE BUTTONS -- some might be image buttons
	private JButton m_loadBtn;
	private JButton m_lineBtn;
	private JButton m_particleBtn;
	private JButton m_saveBtn;
	private JButton m_chooseColor;

	// ALL THE COMBO BOXES
	private JComboBox<String> m_chooseDrawings;
	private JComboBox<String> m_chooseColour;

	// ALL CONSTANT STRING VALUES
	private final String TITLE = "Collaborative Drawing Environment";
	private final String DRAWINGS = "Your Drawings";
	private final String LINE_TITLE = "Straight Line";
	private final String SPRAY_TITLE = "Spray Can";
	private final String COLOUR_TITLE = "Colour";
	private final String SAVE_TITLE = "Save";
	private final String LOAD_TITLE = "Load";
	private final String SAVE_LABEL = "Type the filename";
	private final String[] COLOURS = { "Black", "Blue", "Red", "Green", "Yellow", "Orange" };

	private String[] drawings;

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
