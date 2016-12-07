import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainMenuView {
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

		@Override
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == contactsBtn){
				
			}
			
			
			
		
		}
    }

    private void messagesBtn(){
		JButton btnMessagesbtn = new JButton("messagesBtn");
		btnMessagesbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnMessagesbtn);
    }

    private void profileBtn(){
		JButton btnProfilebtn = new JButton("profileBtn");
		btnProfilebtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnProfilebtn);
    }

    private void drawingBtn(){
		JButton btnDrawingbtn = new JButton("drawingBtn");
		btnDrawingbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnDrawingbtn);
    }

    private void logoutBtn(){
		JButton btnLogoutbtn = new JButton("logoutBtn");
		btnLogoutbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnLogoutbtn);
    }
}

private class BtnHandler implements ActionListener{
	

}

