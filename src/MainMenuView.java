import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import com.sun.glass.events.MouseEvent;


public class MainMenuView  {
	//MainMenuView JPanel
    private JPanel contentPane;
    //MainMenuView Buttons
    private JButton contactsBtn;
    private JButton messagesBtn;
    private JButton profileBtn;
    private JButton drawingBtn;
    private JButton logoutBtn;
    
    private JFrame name;

	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;
    
	/**
	 * Create the frame.
	 */
    public MainMenuView(){
		name = new JFrame();
		name.setBounds(new Rectangle(20, 15, WIDTH - 40, 40));
	    name.setTitle("Contacts List");
	    
	    contentPane = new JPanel();
	    contentPane.setBackground(Color.MAGENTA);
	    
	    contactsBtn();
	    messagesBtn();
	    profileBtn();
	    drawingBtn();
	    logoutBtn();

	    
	    name.setVisible(true);

    }

    private void contactsBtn(){
		JButton btnContactsbtn = new JButton("contactsBtn");
		btnContactsbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnContactsbtn);
		BtnHandler handler = new BtnHandler(name);
		btnContactsbtn.addMouseListener(handler);
		
		}

    private void messagesBtn(){
		JButton btnMessagesbtn = new JButton("messagesBtn");
		btnMessagesbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnMessagesbtn);
		BtnHandler handler = new BtnHandler(name);
		btnMessagesbtn.addMouseListener(handler);
    }

    private void profileBtn(){
		JButton btnProfilebtn = new JButton("profileBtn");
		btnProfilebtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnProfilebtn);
		BtnHandler handler = new BtnHandler(name);
		btnProfilebtn.addMouseListener(handler);
    }

    private void drawingBtn(){
		JButton btnDrawingbtn = new JButton("drawingBtn");
		btnDrawingbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnDrawingbtn);
		BtnHandler handler = new BtnHandler(name);
		btnDrawingbtn.addMouseListener(handler);
	
    }

    private void logoutBtn(){
		JButton btnLogoutbtn = new JButton("logoutBtn");
		btnLogoutbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnLogoutbtn);
		BtnHandler handler = new BtnHandler(name);
		btnLogoutbtn.addMouseListener(handler);
    }
    
    
    
    
    
    
    private class BtnHandler implements MouseListener,MouseMotionListener {
		private JFrame frame;
		
		public BtnHandler(JFrame frame) {
			this.frame = frame;
			
		}

		@Override
		public void mouseDragged(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseMoved(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == contactsBtn) {
				
			}
			
		}
		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    
      
    
    }



