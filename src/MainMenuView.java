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

	//private static final int WIDTH = 500;
    
	
	
	
	
	
	/**
	 * Create the frame.
	 */
    public MainMenuView(){
		name = new JFrame();
		name.setBounds(new Rectangle(100, 100, 450, 300));
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
		btnContactsbtn.setBounds(48, 56, 89, 23);
		name.getContentPane().add(btnContactsbtn);
		BtnHandler handler = new BtnHandler(name);
		btnContactsbtn.addMouseListener(handler);
		
		}

    private void messagesBtn(){
		JButton btnMessagesbtn = new JButton("messagesBtn");
		btnMessagesbtn.setBounds(308, 88, 89, 23);
		name.getContentPane().add(btnMessagesbtn);
		BtnHandler handler = new BtnHandler(name);
		btnMessagesbtn.addMouseListener(handler);
    }

    private void profileBtn(){
		JButton btnProfilebtn = new JButton("profileBtn");
		btnProfilebtn.setBounds(203, 29, 89, 23);
		name.getContentPane().add(btnProfilebtn);
		BtnHandler handler = new BtnHandler(name);
		btnProfilebtn.addMouseListener(handler);
    }

    private void drawingBtn(){
		JButton btnDrawingbtn = new JButton("drawingBtn");
		btnDrawingbtn.setBounds(175, 162, 89, 23);
		name.getContentPane().add(btnDrawingbtn);
		BtnHandler handler = new BtnHandler(name);
		btnDrawingbtn.addMouseListener(handler);
	
    }

    private void logoutBtn(){
		JButton btnLogoutbtn = new JButton("logoutBtn");
		btnLogoutbtn.setBounds(308, 210, 89, 23);
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
				//ContactsView view = new ContactsView();
			}else if (e.getSource() == messagesBtn) {
				//MessagesView view = new MessagesView();
			}else if (e.getSource() == profileBtn) {
				//ProfileView view = new ProfileView(getProfile());
			}else if (e.getSource() == drawingBtn) {
				//DrawingView view = new DrawingView();
			}else if(e.getSource() == logoutBtn) {
				//LoginView view = new LoginView();
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
}



