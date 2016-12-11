import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MessagesView extends JFrame {

	public static void main(String[] args) {
		MessagesView test = new MessagesView();

		Message m;
		m = new TextMessage("ryanjh97", "david", new Date(9, 12, 10), "message");

		if ((m instanceof TextMessage) == true) {
			System.out.println("Test Passed");
			TextMessage msg = (TextMessage) m;
			System.out.println(msg.getContentText());
		}
	}

	public void setMessagePanels() {

		SimpleAttributeSet sentStyle = new SimpleAttributeSet();
		StyleConstants.setForeground(sentStyle, Color.BLACK);

		SimpleAttributeSet recStyle = new SimpleAttributeSet();
		StyleConstants.setForeground(recStyle, Color.BLUE);

		m_SentMsgArea = new JTextPane();
		m_SentMsgArea.setContentType("text/html");

		m_SentMsgArea.setEditable(false);
		m_SentMsgArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		sentDoc = m_SentMsgArea.getStyledDocument();

		try {
			sentDoc.insertString(sentDoc.getLength(), "Sent Messages\n", sentStyle);
		} catch (Exception e) {
			System.out.println(e);
		}

		m_SentScrollPane = new JScrollPane(m_SentMsgArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		m_ReceivedMsgArea = new JTextPane();

		m_ReceivedMsgArea.setContentType("text/html");

		m_ReceivedMsgArea.setEditable(false);

		recDoc = m_ReceivedMsgArea.getStyledDocument();

		m_ReceivedMsgArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		try {
			recDoc.insertString(recDoc.getLength(), "Received Messages\n", recStyle);
		} catch (Exception e) {
			System.out.println(e);
		}

		m_ReceivedScrollPane = new JScrollPane(m_ReceivedMsgArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public MessagesView() {

		this.setTitle("Chat");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);

		m_contentPane = new JPanel();
		this.add(BorderLayout.CENTER, m_contentPane);
		m_contentPane.setLayout(new BoxLayout(m_contentPane, BoxLayout.X_AXIS));

		m_BottomPanel = new JPanel();

		Handler handler = new Handler();

		setMessagePanels();

		m_FieldLbl = new JLabel();
		m_FieldLbl.setText(LABEL_TEXT);
		m_FieldLbl.setFont(new Font("Serif", Font.BOLD, 20));

		m_MessageField = new JTextField(10);
		m_MessageField.setFont(new Font("Serif", Font.PLAIN, 20));

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
		m_BottomPanel.add(m_ChooseConv);
		m_BottomPanel.add(m_AddReceipient);

		this.add(BorderLayout.SOUTH, m_BottomPanel);
		m_contentPane.add(m_SentScrollPane);
		m_contentPane.add(m_ReceivedScrollPane);

		this.setVisible(true);
	}

	private class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == m_ChooseConv) {
				// Load the conversation
				m_SentMsgArea.setText("");
				m_ReceivedMsgArea.setText("");
				getMessage(m_ChooseConv.getSelectedItem().toString());
				System.out.println("Combo Box changed");
			}
			if (e.getSource() == m_SendBtn) {
				// Send the message
				System.out.println("Send button pressed");

			}
			if (e.getSource() == m_AddReceipient) {
				// Bring up receipient dialog
				System.out.println("Add receipient button pressed");
			}

		}

	}

	public void sendMultiReceipient(String message) {

		for (String dest : receipients) {
			String source = user.getUserName();
			Calendar date = Calendar.getInstance();
			Date time = date.getTime();

			FileWriter write = new FileWriter();
			write.writeConversation(dest, source, time, "", message);
		}

	}

	public void sendMsg(String message) {

		FileWriter writer = new FileWriter();
		String source = user.getUserName();
		String destination = m_ChooseConv.getSelectedItem().toString();

		Calendar date = Calendar.getInstance();
		Date time = date.getTime();

		writer.writeConversation(destination, source, time, "", message);

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

	public void getMessage(String selectedItem) {

		try {

			for (Message m : conv.getMessages()) {
				if (m.getSource() == selectedItem) {

					if ((m instanceof TextMessage) == true) {
						TextMessage msg = (TextMessage) m;
						sentDoc.insertString(sentDoc.getLength(), msg.getContentText(), null);
						sentDoc.insertString(sentDoc.getLength(), "\n", null);
					} else if ((m instanceof UrlMessage) == true) {
						UrlMessage msg = (UrlMessage) m;
						sentDoc.insertString(sentDoc.getLength(), msg.getWebAddress(), null);
						sentDoc.insertString(sentDoc.getLength(), "\n", null);
					} else {
						FileMessage file = (FileMessage) m;
						sentDoc.insertString(sentDoc.getLength(), file.getContentText(), null);
						sentDoc.insertString(sentDoc.getLength(), "\n", null);
					}

				} else if (m.getDestination() == selectedItem) {

					if ((m instanceof TextMessage) == true) {
						TextMessage msg = (TextMessage) m;
						recDoc.insertString(recDoc.getLength(), msg.getContentText(), null);
						recDoc.insertString(recDoc.getLength(), "\n", null);
					} else if ((m instanceof UrlMessage) == true) {
						UrlMessage msg = (UrlMessage) m;
						recDoc.insertString(recDoc.getLength(), msg.getWebAddress(), null);
						recDoc.insertString(recDoc.getLength(), "\n", null);
					} else {
						FileMessage file = (FileMessage) m;
						recDoc.insertString(recDoc.getLength(), file.getContentText(), null);
						recDoc.insertString(recDoc.getLength(), "\n", null);
					}
				}

			}

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	
	
	private StyledDocument sentDoc;
	private StyledDocument recDoc;

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

	private JTextPane m_SentMsgArea;
	private JTextPane m_ReceivedMsgArea;
	private JButton m_SendBtn;
	private JTextField m_MessageField;
	private JPanel m_contentPane;
	private JPanel m_BottomPanel;
}
