import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ContactsView extends JFrame {
	public static void main(String[] args){
		//MainFrame frame = new MainFrame();

		Date date = new Date();
		Profile a = new Profile("aaa","Adam","Adam","Thomas","2342",date,"London");
		Profile b = new Profile("bbb","Bob","Bob","Thomas","34523",date,"Swansea");
		Profile cc = new Profile("ccc","Clara","Clara","Smith","65323",date,"Swansea");
		Profile d = new Profile("ddd","David","David","Smith","7627",date,"London");
		Graph.addProfile(a);
		Graph.addProfile(b);
		Graph.addProfile(cc);
		Graph.addProfile(d);
		ContactList c = new ContactList(a);
		ContactList f = new ContactList(b);
		ContactList g = new ContactList(cc);
		ContactList h = new ContactList(d);
				
		c.addContact("bbb");
		c.addContact("ccc");
		c.addContact("ddd");
		f.addContact("aaa");
		g.addContact("aaa");
		h.addContact("aaa");
		System.out.println(c.getFriendRequestList());
		System.out.println(Graph.findNode("aaa").getEdgeList());
		//f.acceptFriendRequest("aaa");
		c.acceptFriendRequest("bbb");
		c.acceptFriendRequest("ccc");
		//c.acceptFriendRequest("ddd");
		System.out.println(Graph.findNode("aaa").getEdgeList());
		System.out.println(c.getContactList());
		ContactsView frame = new ContactsView(c);
		ContactsPanel contacts = new ContactsPanel(c);
		frame.add(contacts,BorderLayout.WEST);
		contacts.setSize(500,600);
		contacts.setVisible(true);
	}
	
	public ContactsView(ContactList userList){
		this.setTitle("Skypertawe Contact List");
		this.setSize(800, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		handler = new ContactsPanelHandler(this);
		
		m_ContactListPanel = new JPanel();
		m_ContactListPanel.setSize(800,600);
		m_ContactListPanel.setVisible(true);
	
				
		this.m_UserList = userList;
		
		/*		
		//Creating components for SearchPanel
		//constructs text field with default text
		m_SearchTitle = new JTextField("Search Users:");
		m_SearchTitle.setEditable(false);
		m_SearchTitle.setBounds(0, 0, 300, 20);
		m_SearchPanel.add(m_SearchTitle);
				
		//constructs text field editable text field
		m_SearchField = new JTextField("Enter username here...");
		m_SearchField.setBounds(0, 25, 290, 20);
		m_SearchPanel.add(m_SearchField);
		m_SearchField.addActionListener(handler);
		
		//constructs button to search
		m_SearchButton = new JButton("Search");
		m_SearchButton.setBounds(0, 50, 150, 20);
		m_SearchPanel.add(m_SearchButton);
		m_SearchButton.addActionListener(handler);
		
		
		//Creating components for ContactsPanel
		m_Title = new JLabel("Contacts List");
		m_Title.setBounds(0, 0, 500, 20);
		m_ContactListPanel.add(m_Title);
		
		//constructs title for scrollpane
		m_ContactListTitle = new JTextField("Scroll through contacts below", 10);
		m_ContactListTitle.setEditable(false);
		m_ContactListTitle.setBounds(0, 50, 500, 20);
		m_ContactListPanel.add(m_ContactListTitle);
		
		m_ContactListContainer.setLayout(null);
		this.setContacts(m_UserList.getContactList());

		//constructs friend request title
		m_FriendRequestTitle = new JTextField("Scroll through friend requests below", 10);
		m_FriendRequestTitle.setEditable(false);
		m_FriendRequestTitle.setBounds(0, 540 , 500, 20);
		m_ContactListPanel.add(m_FriendRequestTitle);
		
		//constructs contact list scrollpane
		m_ContactList = new JScrollPane(m_ContactListContainer);
		m_ContactList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		m_ContactList.setBounds(0, 40, 500, 500);
		m_ContactListPanel.add(m_ContactList);
				
		m_FriendRequestContainer.setLayout(null);		
		this.setFriendRequests(m_UserList.getFriendRequestList());
		
		//constructs friend request scrollpane
		m_FriendRequests = new JScrollPane(m_FriendRequestContainer);
		m_FriendRequests.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		m_FriendRequests.setBounds(0, 560, 500, 240);
		m_ContactListPanel.add(m_FriendRequests);
		
		//add components to contacts panel
		
		
		
		
		
		
		//adds components to search panel
		
		
		this.add(m_ContactListPanel, BorderLayout.WEST);
		this.add(m_SearchPanel,BorderLayout.EAST);
		
		this.setVisible(true);
		 */
		m_ContactListPanel.setBackground(Color.WHITE);
		m_ContactListPanel.setLayout(null);
		//constructs text field with default text
		this.setTitle(new JTextField("Contact List"));
		m_Title.setEditable(false);
		m_ContactListPanel.add(m_Title);
		
		//constructs title for scrollpane
		this.setScrollPaneTitle(new JTextField("Scroll through contacts below", 10));
		this.getScrollPaneTitle().setEditable(false);
		this.add(this.getScrollPaneTitle());
		
		
		Date date = new Date();
		Profile a = new Profile("aaa","Adam","Adam","Thomas","2342",date,"London");
		Profile b = new Profile("bbb","Bob","Bob","Thomas","34523",date,"Swansea");
		Profile cc = new Profile("ccc","Clara","Clara","Smith","65323",date,"Swansea");
		Profile d = new Profile("ddd","David","David","Smith","7627",date,"London");
		Graph.addProfile(a);
		Graph.addProfile(b);
		Graph.addProfile(cc);
		Graph.addProfile(d);
		ContactList c = new ContactList(a);
		ContactList f = new ContactList(b);
		ContactList g = new ContactList(cc);
		ContactList h = new ContactList(d);
				
		c.addContact("bbb");
		c.addContact("ccc");
		c.addContact("ddd");
		f.addContact("aaa");
		g.addContact("aaa");
		h.addContact("aaa");
		System.out.println(c.getFriendRequestList());
		System.out.println(Graph.findNode("aaa").getEdgeList());
		//f.acceptFriendRequest("aaa");
		c.acceptFriendRequest("bbb");
		c.acceptFriendRequest("ccc");
		//c.acceptFriendRequest("ddd");
		System.out.println(Graph.findNode("aaa").getEdgeList());
		System.out.println(c.getContactList());
		
		m_ContactListContainer.setLayout(null);
		this.setContacts(c.getContactList());

		//constructs friend request title
		this.setFriendRequestTitle(new JTextField("Scroll through friend requests below", 10));
		this.getFriendRequestTitle().setEditable(false);
		this.add(this.getFriendRequestTitle());
		
		//constructs scrollpane
		this.setScrollPane(new JScrollPane(m_ContactListContainer));
		this.getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(this.getScrollPane());
				
		m_FriendRequestContainer.setLayout(null);
		
		this.setFriendRequests(c.getFriendRequestList());
		
		//constructs friend request scrollpane
		this.setFriendRequestsScrollPane(new JScrollPane(m_FriendRequestContainer));
		this.getFriendRequestScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(this.getFriendRequestScrollPane());
		
		
		
		ContactsPanelHandler handler = new ContactsPanelHandler(this);
		//this.getSearchContactTitle().addActionListener(handler);
		//this.getSearchContactField().addActionListener(handler);
		
		this.getScrollPaneTitle().addActionListener(handler);
		this.getFriendRequestTitle().addActionListener(handler);
				
		for(JButton button : this.getContacts()){
			button.addActionListener(handler);
		}
		
		for(JTextField text : this.getFriendRequests()){
			text.addActionListener(handler);
		}
		
		//this.m_AcceptFriendRequest.addActionListener(handler);
		//this.m_DeclineFriendRequest.addActionListener(handler);
	}
	
	public JTextField getContactListTitle(){
		return m_Title;
	}
	
	public void setTitle(JTextField title){
		this.m_Title = title;
		m_Title.setBounds(0, 0, 500, 20);
		m_ContactListPanel.add(m_Title);
	}
	
	public JButton getAcceptFriendRequest(){
		return m_AcceptFriendRequest;
	}
	
	public void setAcceptFriendRequest(JButton accept){
		m_AcceptFriendRequest = accept;
	}
	
	public JButton getDeclineFriendRequest(){
		return m_DeclineFriendRequest;
	}
	
	public void setDeclineFriendRequest(JButton decline){
		m_DeclineFriendRequest = decline;
	}
	
	public JTextField getSearchContactTitle(){
		return m_SearchTitle;
	}
	
	public void setSearchContactTitle(JTextField title){
		m_SearchTitle = title;
		m_SearchTitle.setBounds(0, 0, 100, 20);
	}
	
	public JTextField getSearchContactField(){
		return m_SearchField;
	}
	
	public void setSearchField(JTextField field){
		m_SearchField = field;
		m_SearchField.setBounds(100, 0, 200, 20);
	}
	
	public JTextField getScrollPaneTitle(){
		return m_ContactListTitle;
	}
	
	public void setScrollPaneTitle(JTextField title){
		m_ContactListTitle = title;
		m_ContactListTitle.setBounds(0, 20, 400, 20);
	}
	
	public JScrollPane getScrollPane(){
		return m_ContactList;
	}
	
	public void setScrollPane(JScrollPane contactList){
		this.m_ContactList = contactList;
		this.m_ContactList.setBounds(0, 40, 400, 500);
	}
	
	public ArrayList<JButton> getContacts(){
		return m_Contacts;
	}
		
	public JTextField getFriendRequestTitle(){
		return m_FriendRequestTitle;
	}
	
	public void setFriendRequestTitle(JTextField title){
		m_FriendRequestTitle = title;
		m_FriendRequestTitle.setBounds(0, 540, 400, 20);
	}
	
	public JScrollPane getFriendRequestScrollPane(){
		return m_FriendRequests;
	}
	
	public void setFriendRequestsScrollPane(JScrollPane friendRequests){
		this.m_FriendRequests = friendRequests;
		this.m_FriendRequests.setBounds(0, 560, 400, 185);
	}
	
	public ArrayList<JTextField> getFriendRequests(){
		return m_FriendRequestsList;
	}
		
	public JTextField getSearchUserTitle(){
		return m_SearchTitle;
	}
	
	public final boolean setSearchUserTitle(JTextField title){
		boolean test = true;
		if(test){
			System.out.println("ContactsPanel::setSearchTitle()");
		}
		m_SearchTitle = title;
		m_SearchTitle.setBounds(0, 0, 100, 20);
		return true;
	}
	
	public JTextField getSearchUserField(){
		return m_SearchField;
	}
	
	public final boolean setSearchUserField(JTextField field){
		boolean test = true;
		if(test){
			System.out.println("ContactsPanel::setSearchField()");
		}
		m_SearchField = field;
		m_SearchField.setBounds(100, 0, 200, 20);
		
		return true;
	}
	
	private void setContacts(ArrayList<Profile> contacts){
		int inc = 0;
		for(Profile p : contacts){
			String s = p.getFirstName() + " " + p.getLastName();
			JButton button = new JButton(s);
			button.setBounds(0, inc, 500, 40);
			button.addActionListener(handler);
			m_Contacts.add(button);
			m_ContactListContainer.add(m_Contacts.get(m_Contacts.size() - 1));
			
			m_ContactListContainer.validate();
			inc += 40;
		}
	}
	
	private void setFriendRequests(ArrayList<Edge> friendRequests) {
		int inc = 0;
		for(Edge e : friendRequests){
			Profile p = e.getFriend().getElement();
			String s = p.getFirstName() + " " + p.getLastName();
			JTextField text = new JTextField(s);
			text.setEditable(false);
			text.setBounds(0, inc, 300, 30);
			m_FriendRequestsList.add(text);
			m_FriendRequestContainer.add(m_FriendRequestsList.get(m_FriendRequestsList.size() - 1));
			JButton accept = new JButton("Accept");
			accept.setBounds(200, inc, 90, 30);
			accept.addActionListener(handler);
			this.m_AcceptButtons.add(accept);
			m_FriendRequestContainer.add(m_AcceptButtons.get(m_AcceptButtons.size() - 1));
			m_FriendRequestContainer.validate();
			JButton decline = new JButton("Decline");
			decline.setBounds(290, inc, 90, 30);
			decline.addActionListener(handler);
			this.m_DeclineButtons.add(decline);
			m_FriendRequestContainer.add(m_DeclineButtons.get(m_DeclineButtons.size() - 1));
			m_FriendRequestContainer.validate();
			inc += 40;
		}
	}
	
	
	private class ContactsPanelHandler implements ActionListener{
		private ContactsView frame;
		
		ContactsPanelHandler(ContactsView frame){
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent event){		
			String s = "";
			if(event.getSource() == m_SearchField){
				m_UserList.findContact(m_SearchField.getText());
			} else if (event.getSource() == m_SearchButton){
				s = String.format("contactListTitle: %s", event.getActionCommand());
			} 
			
			for(JButton button : m_Contacts){
				if(event.getSource() == button){
					s = button.getText();
					Profile p = m_UserList.findContact(s);
					ProfileView pro = new ProfileView(p);				}
			}
			
			for(JTextField text : m_FriendRequestsList){
				if(event.getSource() == text){
					s = String.format("friendRequestFrom %s", event.getActionCommand());
				}
			}
			for(JButton accept : m_AcceptButtons){
				if(event.getSource() == accept){
					s = String.format("acceptButton: %s", event.getActionCommand());
				}
			}
			
			for(JButton decline : m_DeclineButtons){
				if(event.getSource() == decline){
					s = String.format("declineButton: %s", event.getActionCommand());
				}
			}
			
			JOptionPane.showMessageDialog(null, s);
		}
	}
	
	
	private JPanel m_ContactListPanel;
	private JPanel m_SearchPanel;

	private ContactsPanelHandler handler;
	
	private JPanel m_ContactListContainer = new JPanel();
	private JPanel m_FriendRequestContainer = new JPanel();
	
	private JScrollPane m_ContactList;
	private JTextField m_ContactListTitle;
	private ArrayList<JButton> m_Contacts = new ArrayList<>();
	private ArrayList<JTextField> m_FriendRequestsList = new ArrayList<>();
	private ArrayList<JButton> m_AcceptButtons = new ArrayList<>();
	private ArrayList<JButton> m_DeclineButtons = new ArrayList<>();

	private JScrollPane m_FriendRequests;
	private JTextField m_FriendRequestTitle;
	private JButton m_SearchButton;
	private JTextField m_SearchTitle;
	private JTextField m_SearchField;
	private JTextField m_Title;
	private ContactList m_UserList;
	
	private JButton m_AcceptFriendRequest;
	private JButton m_DeclineFriendRequest;
	
}

