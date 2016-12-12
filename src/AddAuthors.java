import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Class used by MessagesView to add extra receipients
 * @author ryanx
 *
 */
public class AddAuthors extends JFrame{

	/**
	 * Constructor for this class
	 * @param view
	 * @param contacts
	 */
	public AddAuthors(DrawingPanel view,ContactList contacts) {
		
		this.contacts = contacts;
		
		this.setTitle("Choose Contacts");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);

		m_ContentPane = new JPanel();
		this.add(BorderLayout.CENTER, m_ContentPane);

		m_title = new JLabel();
		m_title.setText("Choose the authors by clicking them");
		
		addContactsToScreen();

		m_savebtn = new JButton();
		m_savebtn.setFont(new Font("Serif", Font.PLAIN, 20));
		m_savebtn.setText("Save");
		this.add(m_savebtn,BorderLayout.SOUTH);

		this.setVisible(true);

		m_savebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// return arraylist
				view.setAuthors(m_ChosenContacts);
			}
		});

	}

	/**
	 * Method adds all the contacts as buttons to screen
	 */
	public void addContactsToScreen() {

		if (contacts != null) {
			

			for (Profile p : contacts.getContactList()) {
				JButton btn = new JButton();
				btn.setFont(new Font("Serif", Font.PLAIN, 20));
				btn.setText(p.getUserName());

				btn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btn.setBackground(Color.RED);
						m_ChosenContacts.add(p.getUserName());
					}
				});

				m_ContentPane.add(btn);

			}

		}

	}

	private JButton m_savebtn;
	private ContactList contacts;
	private ArrayList<String> m_ChosenContacts;
	private JLabel m_title;
	private JPanel m_ContentPane;
	
	
}
