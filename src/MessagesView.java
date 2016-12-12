import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MessagesView extends JFrame {


	public MessagesView(Profile user,ContactList contacts,Conversations conversations) {

		this.user = user;
		this.contacts = contacts;
		this.conv = conversations;
		
		//Setting up JFrame
		this.setTitle("Chat");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);

		// Set up Button handlers
		Handler handler = new Handler(this);
		
		// Sent panel
		m_SentPanel = new JPanel();
		m_SentPanel.add(new JLabel("Sent Messages"));

		// Received panel
		m_ReceivedPanel = new JPanel();
		m_ReceivedPanel.add(new JLabel("Received Messages"));

		// Bottom panel
		m_BottomPanel = new JPanel();

		// Adding bottom panel elements
		m_FieldLbl = new JLabel();
		m_FieldLbl.setText(LABEL_TEXT);
		m_FieldLbl.setFont(new Font("Serif", Font.BOLD, 20));

		m_MessageField = new JTextField(10);
		m_MessageField.setFont(new Font("Serif", Font.PLAIN, 20));

		m_FileBtn = new JButton();
		m_FileBtn.setText("Attach File");
		m_FileBtn.setFont(new Font("Serif",Font.PLAIN,20));
		m_FileBtn.addActionListener(handler);
		
		m_SendBtn = new JButton();
		m_SendBtn.setText("Send");
		m_SendBtn.setFont(new Font("Serif", Font.PLAIN, 20));
		m_SendBtn.addActionListener(handler);

		m_ChooseConv = new JComboBox<String>();
		m_ChooseConv.setFont(new Font("Serif", Font.PLAIN, 20));
		m_ChooseConv.addActionListener(handler);

		m_AddReceipient = new JButton();
		m_AddReceipient.setText("Add Recepient");
		m_AddReceipient.setFont(new Font("Serif", Font.PLAIN, 20));
		m_AddReceipient.addActionListener(handler);

		fillComboBox();

		m_BottomPanel.add(m_FieldLbl);
		m_BottomPanel.add(m_MessageField);
		m_BottomPanel.add(m_SendBtn);
		m_BottomPanel.add(m_FileBtn);
		m_BottomPanel.add(m_ChooseConv);
		m_BottomPanel.add(m_AddReceipient);

		

		// Set up scroll panels
		m_SentScrollPane = new JScrollPane(m_SentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		m_ReceivedScrollPane = new JScrollPane(m_ReceivedPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		this.add(BorderLayout.SOUTH, m_BottomPanel);
		this.add(BorderLayout.WEST, m_SentPanel);
		this.add(BorderLayout.EAST, m_ReceivedPanel);
		// m_contentPane.add(m_SentScrollPane);
		// m_contentPane.add(m_ReceivedScrollPane);

		this.setVisible(true);

	}

	private class Handler implements ActionListener {

		MessagesView frame;
		
		public Handler(MessagesView frame) {
			this.frame = frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == m_ChooseConv) {
				// Load the conversation

				getMessage(m_ChooseConv.getSelectedItem().toString());
				System.out.println("Combo Box changed");
			}
			if (e.getSource() == m_SendBtn) {
				// Send the message
				if (m_MessageField.getText().equals("") == false) {
					if (receipients.size() > 1) {
						sendMultiReceipient(m_MessageField.getText());
					} else {
						sendMsg(m_MessageField.getText());
					}
					
					m_MessageField.setText("");
				}

				System.out.println("Send button pressed");

			}
			if (e.getSource() == m_AddReceipient) {
				// Bring up receipient dialog
				System.out.println("Add receipient button pressed");
				ChooseContacts choose = new ChooseContacts(frame);
				
			}
			
			if (e.getSource() == m_FileBtn) {
				int returnVal = fileChoose.showOpenDialog(frame);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
					if (receipients.size() > 1) {
						sendMultiReceipient(fileChoose.getSelectedFile().getPath());
					} else {
						sendMsg(fileChoose.getSelectedFile().getPath());
					}
					
				}
				
				m_MessageField.setText("");
				
			}

		}

	}

	public void fillComboBox() {

		if (contacts != null) {

			int length = contacts.getContactList().size();
			String[] list = new String[length];

			int i = 0;
			for (Profile p : contacts.getContactList()) {

				list[i] = p.getUserName();
				i++;
			}

			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(list);
			m_ChooseConv.setModel(model);

		}

	}

	public void sendMultiReceipient(String message) {

		if (message.contains("www.") && !message.contains("http://")) {
			String type = "url";
			for (String dest : receipients) {
				String source = user.getUserName();
				Calendar date = Calendar.getInstance();
				Date time = date.getTime();
				String msg = "http://";
				msg += message;
				
				FileWriter write = new FileWriter();
				write.writeConversation(type, dest, source, time, "", msg);
			}
			
		} else if (message.contains("http://")) {
			String type = "url";
			for (String dest : receipients) {
				String source = user.getUserName();
				Calendar date = Calendar.getInstance();
				Date time = date.getTime();

				FileWriter write = new FileWriter();
				write.writeConversation(type, dest, source, time, "", message);
			}

		} else if (message.contains(".txt")) {
			String type = "file";

			for (String dest : receipients) {
				String source = user.getUserName();
				Calendar date = Calendar.getInstance();
				Date time = date.getTime();

				FileWriter write = new FileWriter();
				write.writeConversation(type, dest, source, time, "", message);
			}

		} else {

			String type = "text";
			for (String dest : receipients) {
				String source = user.getUserName();
				Calendar date = Calendar.getInstance();
				Date time = date.getTime();

				FileWriter write = new FileWriter();
				write.writeConversation(type, dest, source, time, "", message);
			}

		}

	}

	public void sendMsg(String message) {

		if (message.contains("www.") && !message.contains("http://")) {
			String type = "url";

			FileWriter writer = new FileWriter();
			String source = user.getUserName();
			String destination = m_ChooseConv.getSelectedItem().toString();

			Calendar date = Calendar.getInstance();
			Date time = date.getTime();
			String msg = "http://";
			msg += message;

			writer.writeConversation(type, destination, source, time, "", msg);
		}
		
		if (message.contains("http://")) {
			String type = "url";

			FileWriter writer = new FileWriter();
			String source = user.getUserName();
			String destination = m_ChooseConv.getSelectedItem().toString();

			Calendar date = Calendar.getInstance();
			Date time = date.getTime();

			writer.writeConversation(type, destination, source, time, "", message);

		} else if (message.contains(".txt")) {
			String type = "file";
			FileWriter writer = new FileWriter();
			String source = user.getUserName();
			String destination = m_ChooseConv.getSelectedItem().toString();

			Calendar date = Calendar.getInstance();
			Date time = date.getTime();

			writer.writeConversation(type, destination, source, time, "", message);
		} else {
			String type = "text";

			FileWriter writer = new FileWriter();
			String source = user.getUserName();
			String destination = m_ChooseConv.getSelectedItem().toString();

			Calendar date = Calendar.getInstance();
			Date time = date.getTime();

			writer.writeConversation(type, destination, source, time, "", message);

		}

	}

	public void getMessage(String selectedItem) {

		for (Message m : conv.getMessages()) {
			if (m.getSource() == selectedItem) {

				if ((m instanceof TextMessage) == true) {
					TextMessage msg = (TextMessage) m;
					JLabel lbl = new JLabel();
					lbl.setText(msg.getContentText());
					lbl.setForeground(Color.BLACK);
					m_SentPanel.add(lbl);

				} else if ((m instanceof UrlMessage) == true) {
					UrlMessage msg = (UrlMessage) m;
					JLabel lbl = new JLabel();
					
					
					lbl.setText("<html> Website : <a href=\"\">" + msg.getWebAddress() + "</a></html>");
			        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
					m_SentPanel.add(lbl);
			        setHyperlink(lbl,msg.getWebAddress());
					
					
					
				} else {
					FileMessage file = (FileMessage) m;
					JLabel lbl = new JLabel();
					lbl.setText(file.getContentText());
					lbl.setForeground(Color.BLACK);
					m_SentPanel.add(lbl);

				}

			} else if (m.getDestination() == selectedItem) {

				if ((m instanceof TextMessage) == true) {
					TextMessage msg = (TextMessage) m;
					JLabel lbl = new JLabel();
					lbl.setText(msg.getContentText());
					lbl.setForeground(Color.BLACK);
					m_ReceivedPanel.add(lbl, BorderLayout.WEST);

				} else if ((m instanceof UrlMessage) == true) {
					UrlMessage msg = (UrlMessage) m;
					JLabel lbl = new JLabel();
					lbl.setText("<html> Website : <a href=\"\">" + msg.getWebAddress() + "</a></html>");
			        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
					m_SentPanel.add(lbl);
			        setHyperlink(lbl,msg.getWebAddress());
				} else {
					FileMessage file = (FileMessage) m;
					JLabel lbl = new JLabel();
					lbl.setText(file.getContentText());
					lbl.setForeground(Color.BLACK);
					m_ReceivedPanel.add(lbl, BorderLayout.WEST);

				}
			}

		}
	}
	
	
	public void setHyperlink(JLabel label,String link) {
		label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(link));
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("There is a problem opening this link");
                }
            }
        });
	}
	
	
	public void setReceipients(ArrayList<String> list) {
		receipients = list;
	}
	
	
	private JFileChooser fileChoose = new JFileChooser();

	private JButton m_FileBtn;
	private JButton m_SendBtn;
	private JTextField m_MessageField;
	private JPanel m_ReceivedPanel;
	private JPanel m_SentPanel;
	private JPanel m_BottomPanel;
	private ArrayList<String> receipients = new ArrayList<String>();
	
	private Profile user;
	private ContactList contacts;
	private Conversations conv;
	
	private final String LABEL_TEXT = "Enter Text";
	private JScrollPane m_SentScrollPane;
	private JScrollPane m_ReceivedScrollPane;
	private JButton m_AddReceipient;
	private JComboBox<String> m_ChooseConv;
	private JLabel m_FieldLbl;
}
