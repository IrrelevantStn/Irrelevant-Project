import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MainMenuView  {
	//MainMenuView JPanel
    private JPanel contentPane;
    //MainMenuView Buttons
    private JButton contactsBtn;
    private JButton messagesBtn;
    private JButton profileBtn;
    private JButton drawingBtn;
    private JButton logoutBtn;
    
    private Graph graph;
    private ContactList contacts;
    private Conversations conversations;
    private Profile profile;
    
    
    BtnHandler handler;
    
    private JFrame name;

	/**
	 * Create the frame.
	 */
    public MainMenuView(ContactList contacts,Graph users,Conversations conv,Profile profile){
		
    	this.contacts = contacts;
    	this.graph = users;
    	this.conversations = conv;
    	this.profile = profile;
    	
    	
    	name = new JFrame();
		name.setBounds(new Rectangle(100, 100, 450, 300));
		name.getContentPane().setLayout(new BoxLayout(name.getContentPane(),
				BoxLayout.X_AXIS));
	    
	    contentPane = new JPanel();
	    contentPane.setBackground(Color.MAGENTA);
	    
	    JButton btnContactsbtn = new JButton("contactsBtn");
	    handler = new BtnHandler(name);
	    
	    contactsBtn();
	    messagesBtn();
	    profileBtn();
	    drawingBtn();
	    logoutBtn();

	    Panel p1 = new Panel();
	    
	    p1.add(btnContactsbtn);
	   // p1.add();

	    
	    name.setVisible(true);

    }

    private void contactsBtn(){
    	contactsBtn = new JButton("contactsBtn");
		//btnContactsbtn.setBounds(48, 56, 50, 50);
		name.getContentPane().add(contactsBtn,BorderLayout.WEST);
		contactsBtn.addMouseListener(handler);
		
		}

    private void messagesBtn(){
		messagesBtn = new JButton("messagesBtn");
		//btnMessagesbtn.setBounds(308, 88, 89, 23);
		name.getContentPane().add(messagesBtn,BorderLayout.CENTER);
		messagesBtn.addMouseListener(handler);
    }

    private void profileBtn(){
		profileBtn = new JButton("profileBtn");
		//btnProfilebtn.setBounds(203, 29, 89, 23);
		name.getContentPane().add(profileBtn,BorderLayout.WEST);
		profileBtn.addMouseListener(handler);
    }

    private void drawingBtn(){
		drawingBtn = new JButton("drawingBtn");
		//btnDrawingbtn.setBounds(175, 162, 89, 23);
		name.getContentPane().add(drawingBtn,BorderLayout.EAST);
		drawingBtn.addMouseListener(handler);
	
    }

    private void logoutBtn(){
		logoutBtn = new JButton("logoutBtn");
		//btnLogoutbtn.setBounds(308, 210, 89, 23);
		name.getContentPane().add(logoutBtn,BorderLayout.WEST);
		logoutBtn.addMouseListener(handler);
    }
    
    private class BtnHandler implements MouseListener,MouseMotionListener {
		private JFrame frame;
		
		public BtnHandler(JFrame frame) {
			this.frame = frame;
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == contactsBtn) {
				//ContactsView view = new ContactsView();
				System.out.println("Contacts");
			}else if (e.getSource() == messagesBtn) {
				MessagesView view = new MessagesView(profile,contacts,conversations);
				System.out.println("Message");
			}else if (e.getSource() == profileBtn) {
				ProfileView view = new ProfileView(profile);
				System.out.println("Profile");
			}else if (e.getSource() == drawingBtn) {
				DrawingView view = new DrawingView(graph,profile);
				System.out.println("drawing");
			}else if(e.getSource() == logoutBtn) {
				LoginView view = new LoginView();
				frame.setVisible(false);
				System.out.println("Logout");
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    
    }
}