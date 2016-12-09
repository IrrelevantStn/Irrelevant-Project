import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import com.sun.glass.events.MouseEvent;


public class MainMenuView implements ActionListener  {
	//MainMenuView JPanel
    private JPanel contentPane;
    //MainMenuView Buttons
    private JButton contactsBtn;
    private JButton messagesBtn;
    private JButton profileBtn;
    private JButton drawingBtn;
    private JButton logoutBtn;
    
    private JFrame name;
    
	
	/**
	 * Create the frame.
	 */
    public MainMenuView(){
		name = new JFrame();
		name.setBounds(new Rectangle(100, 100, 450, 300));
		name.getContentPane().setLayout(new BoxLayout(name.getContentPane(), BoxLayout.X_AXIS));
	    
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
		name.getContentPane().add(btnContactsbtn);
		BtnHandler handler = new BtnHandler(name);
		btnContactsbtn.addMouseListener(handler);

		}

    private void messagesBtn(){
		JButton btnMessagesbtn = new JButton("messagesBtn");
		name.getContentPane().add(btnMessagesbtn);
		BtnHandler handler = new BtnHandler(name);
		btnMessagesbtn.addMouseListener(handler);
    }

    private void profileBtn(){
		JButton btnProfilebtn = new JButton("profileBtn");
		name.getContentPane().add(btnProfilebtn);
		BtnHandler handler = new BtnHandler(name);
		btnProfilebtn.addMouseListener(handler);
    }

    private void drawingBtn(){
		JButton btnDrawingbtn = new JButton("drawingBtn");
		name.getContentPane().add(btnDrawingbtn);
		BtnHandler handler = new BtnHandler(name);
		btnDrawingbtn.addMouseListener(handler);
    }

    private void logoutBtn(){
		JButton btnLogoutbtn = new JButton("logoutBtn");
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
			    //ProfileView view = new ProfileView();
			}else if (e.getSource() == drawingBtn) {
				DrawingView view = new DrawingView();
			}else if(e.getSource() == logoutBtn) {
				LoginView view = new LoginView();
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

	//@Override
	//public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
 
		
	//}
    
	public void contactsBtnActionPerformed(java.awt.event.ActionEvent evt) {
		
		contactsBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		           contactsBtnActionPerformed(evt);
		    }
		});
		/*
		messagesBtn.addActionListener(this);
		profileBtn.addActionListener(this);
		drawingBtn.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		           jButton3ActionPerformed(evt);
		    }
		});
		logoutBtn .addActionListener(this);
	*/
	}


	
}

/*
public class MainMenuView { 
	
	 contactBtn.contactKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contactsBtn == e.getSource()) {
					mouseClicked();
				}
			}

	
}
*/


