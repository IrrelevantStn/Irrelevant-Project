
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
	public static void main(String[] args ) {
		Profile wtz = new Profile("abc", "123456",
			"Wenting", "Zhang", "44332211", 
			new Date(), "London",new Date(),
			"/Users/zwt/Desktop/WechatIMG1.jpeg");
		
		new ProfileView(wtz).setVisible(true );
	}
	
	public ProfileView(Profile profile) {
		Dimension wndSize = new Dimension();
		
		wndSize.width = WIDTH;
		wndSize.height = HEIGHT;
		this.setSize(wndSize );
		
		this.setLayout(null );
		this.setResizable(false );
		this.setLocationRelativeTo(null );
		this.setTitle("UserProfile/" + profile.getUserName() );
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e ) {
				cancelBtnClick();
			}
		} );
		
		this.profile = profile;
		
		title = new JLabel("User Profile/" + profile.getUserName() );
		profImg = new JLabel("" );
		
		ImageIcon img = new ImageIcon(profile.getProfImg() );
		img.setImage(img.getImage().getScaledInstance(100, 190,
				Image.SCALE_DEFAULT) );
		
		profImg.setIcon(img );
		usrinfo = new JTextArea(profile.toString() );
		
		Font font0 = new Font("Sans", Font.BOLD, 40 );
		Font font1 = new Font("Serif", Font.PLAIN, 22 );
		
		title.setFont(font0 );
		usrinfo.setFont(font1 );
		usrinfo.setEditable(false );
		
		Panel p0 = new Panel();
		p0.add(profImg );
		p0.add(usrinfo );
		p0.setBounds(new Rectangle(0, 20, WIDTH, 200 ) );
		this.add(p0 );
		
		cancelBtn = new JButton("Cancel" );

		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				cancelBtnClick();
			}
		} );
		
		
		Panel p2 = new Panel();
		
		p2.add(cancelBtn );
		p2.setBounds(new Rectangle(0, 240, WIDTH, 50 ) );
		this.add(p2 );
	}

	private void cancelBtnClick() {
		
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
			null, "Are you sure?", "Warning", JOptionPane.YES_NO_OPTION ) ) {
			System.exit(0 );
		}	
	}


	
	@SuppressWarnings("unused")
	private Profile profile;
	
	private JLabel title;
	private JLabel profImg;
	private JTextArea usrinfo;
	
	private JButton cancelBtn;

	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 340;
}
