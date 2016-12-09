import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionListener;


public class LoginView implements ActionListener  {
    private final String USERNAME_INSTRUCTIONS = "Enter Username: ";
    private final String PASSWORD_INSTRUCTIONS = "Enter Password: ";
    private final String PROGRAM_NAME = "Skypertawe";
    private JFrame frame = new JFrame();
    private JPanel contentPane = new JPanel();
    private JLabel usernameLbl = new JLabel(USERNAME_INSTRUCTIONS);
    private JLabel passwordLbl = new JLabel(PASSWORD_INSTRUCTIONS);
    private JLabel errorMessageLbl;
    private String errorMessage = "ERROR MESSAGE";
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton exitBtn;
    private Login login = new Login();
    
    public static void main(String[] args){
    	LoginView l = new LoginView();
    	
    }
    

    private LoginView(){
    	contentPane.setLayout(null);
    	frame.setTitle("Login");
    	frame.setBounds(100,100,600,300);
    	frame.add(contentPane);
    	errorMessageLbl = new JLabel(errorMessage);
    	userNameField = new JTextField();
    	passwordField = new JPasswordField();
    	loginBtn = new JButton("Login");
    	exitBtn = new JButton("Exit");
		usernameLbl.setBounds(50, 50, 100, 30);
		passwordLbl.setBounds(50, 100, 100, 30);
		userNameField.setBounds(200, 50, 100, 30);
		passwordField.setBounds(200, 100, 100, 30);
		loginBtn.setBounds(200, 170, 100, 30);
		exitBtn.setBounds(150, 400, 100, 50);
		errorMessageLbl.setBounds(200, 120, 200, 50);
		contentPane.add(usernameLbl);
		contentPane.add(passwordLbl);
		contentPane.add(errorMessageLbl);
		contentPane.add(userNameField);
		contentPane.add(passwordField);
		contentPane.add(loginBtn);
		contentPane.add(exitBtn);
		loginBtn.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent e){
				if (e.getSource() == loginBtn){
					errorMessageLbl.setText("button pressed");// to test button functionality
					System.out.println("button pressed");     // ''
					String username = userNameField.getText();
					String password = String.valueOf(passwordField.getPassword());
					login.loginDetailsCorrect(username, password);
    }
    		}
    	});
		frame.setVisible(true);
		
    }

    private void loginButton(){
    	
    }
    
//    private void exitButton(){
//		exitBtn.addEventListener(new EventListener(){
//    		public void actionPerformed(ActionEvent e){
//				if (e.getSource() == exitBtn){
//					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				}
//    		}
//		}
//    }
//    
	
}
