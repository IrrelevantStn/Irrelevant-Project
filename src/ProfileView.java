
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ProfileView extends JFrame {

	public ProfileView(Profile profile) {
		Dimension wndSize = new Dimension();
		wndSize.width = WIDTH;
		wndSize.height = HEIGHT;
		this.setSize(wndSize);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("UserProfile/" + profile.getUserName());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cancelBtnClick();
			}
		});
		this.m_profile = profile;
		
		m_title = new JLabel("User Profile/" + profile.getUserName());
		
		m_profImg = new JLabel("");
		ImageIcon img = new ImageIcon(profile.getProfImg());
		img.setImage(img.getImage().getScaledInstance(100, 190,
				Image.SCALE_DEFAULT));
		m_profImg.setIcon(img);
		
		m_usrinfo = new JTextArea(profile.toString());

		Font font0 = new Font("Sans", Font.BOLD, 40);
		Font font1 = new Font("Serif", Font.PLAIN, 22);
		m_title.setFont(font0);
		m_usrinfo.setFont(font1);
		m_usrinfo.setEditable(false);
		
		Panel p0 = new Panel();
		p0.add(m_profImg);
		p0.add(m_usrinfo);
		p0.setBounds(new Rectangle(0, 20, WIDTH, 200));
		this.add(p0);
		m_cancelBtn = new JButton("Cancel");
		m_cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelBtnClick();
			}
		});
		
		Panel p2 = new Panel();
		p2.add(m_cancelBtn);
		p2.setBounds(new Rectangle(0, 240, WIDTH, 50));
		this.add(p2);
	}

	private void cancelBtnClick() {

		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
				"Are you sure?", "Warning",JOptionPane.YES_NO_OPTION)) {
			System.exit(0);
		}
	}

	@SuppressWarnings("unused")
	private Profile m_profile;

	private JLabel m_title;
	private JLabel m_profImg;
	private JTextArea m_usrinfo;

	private JButton m_cancelBtn;

	private static final int WIDTH = 500;
	private static final int HEIGHT = 340;
}
