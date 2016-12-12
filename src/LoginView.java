import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class LoginView extends JPanel {
    private final String USERNAME_INSTRUCTIONS = "Enter Username: ";
    private final String PASSWORD_INSTRUCTIONS = "Enter Password: ";
    private final String ERROR_MESSAGE = "Failed Login";
    private JFrame frame = new JFrame();
    private JPanel contentPane = new JPanel();
    private JLabel usernameLbl = new JLabel(USERNAME_INSTRUCTIONS);
    private JLabel passwordLbl = new JLabel(PASSWORD_INSTRUCTIONS);
    private JLabel errorMessageLbl = new JLabel();
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginBtn = new JButton("Login");
    private Login login = new Login();

    public LoginView(){
    	contentPane.setLayout(null);
    	frame.setTitle("Login");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setBounds(100,100,600,300);
    	frame.add(contentPane);
    	userNameField = new JTextField();
    	passwordField = new JPasswordField();
    	usernameLbl.setBounds(50, 50, 100, 30);
		passwordLbl.setBounds(50, 100, 100, 30);
		userNameField.setBounds(200, 50, 100, 30);
		passwordField.setBounds(200, 100, 100, 30);
		loginBtn.setBounds(200, 170, 100, 30);
		errorMessageLbl.setBounds(200, 120, 200, 50);
		contentPane.add(usernameLbl);
		contentPane.add(passwordLbl);
		contentPane.add(errorMessageLbl);
		contentPane.add(userNameField);
		contentPane.add(passwordField);
		contentPane.add(loginBtn);

		loginBtn.addActionListener(new ActionListener(){
			@Override
    		public void actionPerformed (ActionEvent e){
				if (e.getSource() == loginBtn){
					String username = userNameField.getText();
					String password = String.valueOf(passwordField.getPassword());
					if(login.loginDetailsCorrect(username, password)){
						//System.out.println("Correct Password");
						ContactList contacts = ContactList.getContactList
								(username);
						Graph graph = login.readUsers(login.getProfiles());
						Conversations conv = login.getConv();
						Profile profile = getProfile(username,login.getProfiles());
						MainMenuView main = new MainMenuView(contacts,graph,conv,profile);
					}else{
						//System.out.println("Incorrect Password");
						errorMessageLbl.setText(ERROR_MESSAGE);
					}
				}
    		}
    	});
		frame.setVisible(true);
    }   
    
    
    public Profile getProfile(String username,ArrayList<Profile> profiles) {
    	for (Profile p : profiles) {
    		if (p.getUserName().equals(username)) {
    			return p;
    		}
    	}
    	
    	return null;
    }
    
} 