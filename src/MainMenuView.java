import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenuView {
    private JPanel contentPane;
    private JButton contactsBtn;
    private JButton messagesBtn;
    private JButton profileBtn;
    private JButton drawingBtn;
    private JButton logoutBtn;
    
    private JFrame name;

	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;
    
    public MainMenuView(){

    }

    private void contactsBtn(){
		name = new JFrame();
		name.setBounds(new Rectangle(20, 15, WIDTH - 40, 40));
	    name.setTitle("Contacts List");

    	
		JButton btnContactsbtn = new JButton("contactsBtn");
		btnContactsbtn.setBounds(20, 15, WIDTH - 40, 40);
		name.getContentPane().add(btnContactsbtn);
    }

    private void messagesBtn(){

    }

    private void profileBtn(){

    }

    private void drawingBtn(){

    }

    private void logoutBtn(){

    }
}
