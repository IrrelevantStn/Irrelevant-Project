import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author Aisha Ekangaki
 * ContactsPanel.java is a partial implementation of the ContactsView interface to handle ContactList
 *
 */

public class ContactsPanel extends JPanel{
	
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
		m_SearchTitle.setBounds(500, 0, 75, 20);
	}
	
	public JTextField getSearchContactField(){
		return m_SearchField;
	}
	
	public void setSearchField(JTextField field){
		m_SearchField = field;
		m_SearchField.setBounds(575, 0, 150, 20);
	}
	
	public JButton getSearchContactButton(){
		return m_SearchContactList;
	}
	
	public void setSearchContactButton(JButton search){
		this.m_SearchContactList = search;
		this.m_SearchContactList.setBounds(725, 0, 75, 20);
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
	
	public void setContacts(ArrayList<Profile> contacts){
		int inc = 0;
		for(Profile p : contacts){
			String s = p.getFirstName() + " " + p.getLastName();
			JButton button = new JButton(s);
			button.setBounds(0, inc, 400, 40);
			m_Contacts.add(button);
			m_ContactListContainer.add(m_Contacts.get(m_Contacts.size() - 1));
			
			m_ContactListContainer.validate();
			inc += 40;
		}
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
		this.m_FriendRequests.setBounds(0, 560, 400, 235);
	}
	
	public ArrayList<JTextField> getFriendRequests(){
		return m_FriendRequestsList;
	}
	
	public void setFriendRequests(ArrayList<Edge> friendRequests) {
		int inc = 0;
		for(Edge e : friendRequests){
			Profile p = e.getFriend().getElement();
			String s = p.getFirstName() + " " + p.getLastName();
			JTextField text = new JTextField(s);
			text.setEditable(false);
			text.setBounds(0, inc, 200, 30);
			m_FriendRequestsList.add(text);
			m_FriendRequestContainer.add(m_FriendRequestsList.get(m_FriendRequestsList.size() - 1));
			JButton accept = new JButton("Accept");
			accept.setBounds(200, inc, 90, 30);
			this.m_AcceptButtons.add(accept);
			m_FriendRequestContainer.add(m_AcceptButtons.get(m_AcceptButtons.size() - 1));
			m_FriendRequestContainer.validate();
			JButton decline = new JButton("Decline");
			decline.setBounds(290, inc, 90, 30);
			this.m_DeclineButtons.add(decline);
			m_FriendRequestContainer.add(m_DeclineButtons.get(m_DeclineButtons.size() - 1));
			m_FriendRequestContainer.validate();
			inc += 40;
		}
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
	
	public JButton getSearchUserButton(){
		return m_SearchContactList;
	}
	
	public void setSearchUserButton(JButton search){
		this.m_SearchContactList = search;
		this.m_SearchContactList.setBounds(300, 0, 100, 20);
	}
		
	public ContactsPanel() {
		m_ContactListPanel = this;
		m_ContactListPanel.setBackground(Color.WHITE);
		m_ContactListPanel.setLayout(null);
		//constructs text field with default text
		this.setSearchContactTitle(new JTextField("Search Users:"));
		this.getSearchContactTitle().setEditable(false);
		m_ContactListPanel.add(this.getSearchContactTitle());
		
		//constructs text field editable text field
		this.setSearchField(new JTextField("Enter contact username here..."));
		m_ContactListPanel.add(this.getSearchContactField());
		
		//constructs button to search
		this.setSearchContactButton(new JButton("Search"));
		m_ContactListPanel.add(this.getSearchContactButton());
		
		//constructs title for scrollpane
		this.setScrollPaneTitle(new JTextField("Scroll through contacts below", 10));
		this.getScrollPaneTitle().setEditable(false);
		m_ContactListPanel.add(this.getScrollPaneTitle());
		
		
		Date date = new Date();
		Profile a = new Profile("aaa","Adam","Adam","Thomas","2342",date,"London",date,"profImg");
		Profile b = new Profile("bbb","Bob","Bob","Thomas","34523",date,"Swansea",date,"profImg");
		Profile cc = new Profile("ccc","Clara","Clara","Smith","65323",date,"Swansea",date,"profImg");
		Profile d = new Profile("ddd","David","David","Smith","7627",date,"London",date,"profImg");
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
		m_ContactListPanel.add(this.getFriendRequestTitle());
		
		//constructs scrollpane
		this.setScrollPane(new JScrollPane(m_ContactListContainer));
		this.getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		m_ContactListPanel.add(this.getScrollPane());
				
		m_FriendRequestContainer.setLayout(null);
		
		this.setFriendRequests(c.getFriendRequestList());
		
		//constructs friend request scrollpane
		this.setFriendRequestsScrollPane(new JScrollPane(m_FriendRequestContainer));
		this.getFriendRequestScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		m_ContactListPanel.add(this.getFriendRequestScrollPane());
		
		
		
		ContactsPanelHandler handler = new ContactsPanelHandler();
		this.getSearchContactField().addActionListener(handler);
		this.getSearchContactButton().addActionListener(handler);
		this.getScrollPaneTitle().addActionListener(handler);
		this.getFriendRequestTitle().addActionListener(handler);
				
		for(JButton button : this.getContacts()){
			button.addActionListener(handler);
		}
		
		for(JTextField text : this.getFriendRequests()){
			text.addActionListener(handler);
		}
		
		this.m_AcceptFriendRequest.addActionListener(handler);
		this.m_DeclineFriendRequest.addActionListener(handler);
	}
	
	private class ContactsPanelHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String s = "";
			
			if (event.getSource() == getSearchContactField()){
				s = getSearchContactField().getName();
				Node n = Graph.findNode(s);
				if(m_UserList.getContactList().contains(n.getElement())){
					ProfileView p = new ProfileView(n.getElement());
				} else {
					JLabel person = new JLabel(n.getElement().getFirstName() + " " + n.getElement().getLastName());
					person.setBounds(500, 30, 200, 20);
					m_ContactListPanel.add(person);
					JButton addFriend = new JButton("Add Friend");
					addFriend.setBounds(700, 30, 90, 20);
					m_ContactListPanel.add(addFriend);
				}
								
			} else if (event.getSource() == getSearchContactButton()){
				s = String.format("searchButton: %s", event.getActionCommand());
			} else if (event.getSource() == getScrollPaneTitle()){
				s = String.format("scrollPaneTitle: %s", event.getActionCommand());
			} 
			
			for(JButton button : m_Contacts){
				if(event.getSource() == button){
					s = button.getText();
					//m_UserList.findContact(s);
				}
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
	
	private ContactsPanel m_ContactListPanel;
	private JTextField m_SearchTitle;
	private JTextField m_SearchField;
	private JButton m_SearchContactList;
	private JPanel m_ContactListContainer = new JPanel();
	private JScrollPane m_ContactList;
	private JTextField m_ContactListTitle;
	private ArrayList<JButton> m_Contacts = new ArrayList<>();
	private ArrayList<JTextField> m_FriendRequestsList = new ArrayList<>();
	private ArrayList<JButton> m_AcceptButtons = new ArrayList<>();
	private ArrayList<JButton> m_DeclineButtons = new ArrayList<>();
	private JButton m_AcceptFriendRequest = new JButton("Accept");
	private JButton m_DeclineFriendRequest = new JButton("Decline");
	private JScrollPane m_FriendRequests;
	private JPanel m_FriendRequestContainer = new JPanel();
	private JTextField m_FriendRequestTitle;
	private ContactList m_UserList;
}