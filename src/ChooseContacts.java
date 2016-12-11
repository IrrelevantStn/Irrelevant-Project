import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseContacts extends JFrame {

	public ChooseContacts(MessagesView view) {
		this.setTitle("Choose Contacts");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);

		m_ContentPane = new JPanel();
		this.add(BorderLayout.CENTER, m_ContentPane);

		addContactsToScreen();

		m_title = new JLabel();
		m_title.setText("Click on the contacts you want to add");
		m_title.setFont(new Font("Serif", Font.PLAIN, 20));
		this.add(BorderLayout.NORTH,m_title);
		
		
		
		m_savebtn = new JButton();
		m_savebtn.setFont(new Font("Serif", Font.PLAIN, 20));
		m_savebtn.setText("Save");
		this.add(m_savebtn,BorderLayout.SOUTH);

		this.setVisible(true);

		m_savebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// return arraylist
				view.setReceipients(m_ChosenContacts);
			}
		});

	}

	public void addContactsToScreen() {

		if (contacts != null) {
			

			for (Profile p : contacts.getContactList()) {
				JButton btn = new JButton();
				btn.setFont(new Font("Serif", Font.PLAIN, 20));
				btn.setText(p.getUserName());

				btn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						m_ChosenContacts.add(p.getUserName());
					}
				});

				m_ContentPane.add(btn);

			}

		}

	}

	private JButton m_savebtn;
	private ContactList contacts;
	private ArrayList<String> m_ChosenContacts = new ArrayList<String>();
	private JLabel m_title;
	private JPanel m_ContentPane;

}
