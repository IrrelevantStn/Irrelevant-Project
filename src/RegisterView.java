

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class RegisterView extends JFrame {

	public static void main(String[] args) {
		new RegisterView(null).setVisible(true);
	}

	public RegisterView(JFrame parent) {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Sign Up");
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				RegisterView.this.cancelBtnClick();
			}
		});
		this.m_parent = parent;
		m_title = new JLabel("Sign Up");
		m_title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		m_title.setBounds(new Rectangle(20, 15, WIDTH - 40, 40));
		this.add(m_title);
		m_userName = new JTextField();
		m_password = new JPasswordField();
		m_password0 = new JPasswordField();
		m_firstName = new JTextField();
		m_lastName = new JTextField();
		m_telephone = new JTextField();
		m_birthday = new JTextField();
		m_city = new JTextField();
		m_profImg = new JTextField();
		m_profImg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & PNG Images", "jpg", "jpeg", "png");
				JFileChooser jfc = new JFileChooser();
				jfc.setFileFilter(filter);
				int r = jfc.showOpenDialog(RegisterView.this);
				if (JFileChooser.APPROVE_OPTION == r) {
					RegisterView.this.m_profImg.setText(
							jfc.getSelectedFile().getAbsolutePath());
				}
			}
		});
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(9, 2));
		p1.add(new JLabel("UserName: "));
		p1.add(m_userName);
		p1.add(new JLabel("Password: "));
		p1.add(m_password);
		p1.add(new JLabel("Confirm: "));
		p1.add(m_password0);
		p1.add(new JLabel("First Name: "));
		p1.add(m_firstName);
		p1.add(new JLabel("Last Name: "));
		p1.add(m_lastName);
		p1.add(new JLabel("Telephone: "));
		p1.add(m_telephone);
		p1.add(new JLabel("Birthday: "));
		p1.add(m_birthday);
		p1.add(new JLabel("City: "));
		p1.add(m_city);
		p1.add(new JLabel("Image: "));
		p1.add(m_profImg);
		p1.setBounds(new Rectangle(40, 70, WIDTH - 100, 220));
		this.add(p1);
		m_cancelBtn = new JButton("Cancel");
		m_registerBtn = new JButton("Confirm");
		m_cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelBtnClick();
			}
		});
		m_registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerBtnClick();
			}
		});
		Panel p2 = new Panel();
		p2.add(m_cancelBtn);
		p2.add(m_registerBtn);
		p2.setBounds(new Rectangle(0, 305, WIDTH, 40));
		this.add(p2);
	}

	@SuppressWarnings("deprecation")
	private void registerBtnClick() {

		String strPwd = m_password.getText();
		String strPwd0 = m_password0.getText();
		String strTel = m_telephone.getText();
		String strUserName = m_userName.getText();
		String strFirstName = m_firstName.getText();
		String strLastName = m_lastName.getText();
		String strBirthday = m_birthday.getText();
		String strCity = m_city.getText();
		String strProfImg = m_profImg.getText();

		if (strUserName.equals("") || strPwd.equals("") || strTel.equals("") 
				|| strFirstName.equals("")|| strLastName.equals("") ||
				strBirthday.equals("") || strCity.equals("") ||
				strProfImg.equals("")) {
			JOptionPane.showMessageDialog(null,
					"You have to fill out all these blanks.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (!strPwd.equals(strPwd0)) {
			JOptionPane.showMessageDialog(null, "Password does not match",
					"Error", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (!strTel.startsWith("44")) {
			JOptionPane.showMessageDialog(null, 
					"!telephone.startsWith(\"44\" ) ","Error",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date birthday;

		try {
			birthday = formatter.parse(strBirthday);
		} catch (ParseException e) {
			birthday = Calendar.getInstance().getTime();
		}

		Profile p = new Profile(strUserName, strPwd, strFirstName, strLastName,
				strTel, birthday, strCity, null,strProfImg);

		Register r = new Register(p);
		if (!r.checkUserName()) {
			JOptionPane.showMessageDialog(null, ("User " + strUserName +
					" already exists"), "Error",JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, 
					"Congrats, you have created an account named " +
			strUserName, "User Registration", JOptionPane.WARNING_MESSAGE);
			r.createNewUser();
			new MainMenuView();
			this.dispose();
		}
	}

	private void cancelBtnClick() {
		if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(null,
				"Are you sure?", "Warning",
				JOptionPane.YES_NO_OPTION)) {
			return;
		}

		if (null != m_parent) {
			m_parent.setVisible(true);
			this.dispose();
		} else {
			System.exit(0);
		}
	}

	private JFrame m_parent;
	
	private JLabel m_title;

	private JTextField m_userName;
	private JPasswordField m_password;
	private JPasswordField m_password0;
	private JTextField m_firstName;
	private JTextField m_lastName;
	private JTextField m_telephone;
	private JTextField m_birthday;
	private JTextField m_city;
	private JTextField m_profImg;

	private JButton m_cancelBtn;
	private JButton m_registerBtn;

	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;

}
