import java.util.ArrayList;

public class ContactList {

	public ContactList(Profile p){
		this.m_UserProfile = p;
		this.m_User = Graph.findNode(p.getUserName());
		setContactList();
		setFriendRequests();
		m_SystemContactLists.add(this);
	}
	
	private void setContactList(){
		for(Edge e : m_User.getEdgeList()){
			boolean isFriend = e.isBidirectional();
			if(isFriend && !m_ContactList.contains(e)){
				this.m_ContactList.add(e.getFriend().getElement());
			}
		}
	}
	
	private void setFriendRequests(){
		for(Edge e : m_User.getEdgeList()){
			boolean isFriend = e.isBidirectional();
			if(!isFriend && !m_FriendRequests.contains(e)){
				this.m_FriendRequests.add(e);
			} else if(isFriend && m_FriendRequests.contains(e)){
				this.m_FriendRequests.remove(e);
			}
		}
	}
	
	public ArrayList<Profile> getContactList(){
		return m_ContactList;
	}
	
	public ArrayList<Edge> getFriendRequestList(){
		return m_FriendRequests;
	}
	
	private Node getUser(){
		return m_User;
	}
	
	public static ContactList getContactList(String person) throws UserDoesNotExistException{
		ContactList userContactList = null;
		Node n = Graph.findNode(person);
		for(ContactList c : m_SystemContactLists){
			if(n.getElement().getUserName().equals(person)){
				userContactList = c;
			}
		}		
		if(userContactList == null){
			throw new UserDoesNotExistException("User not in the system");
		} else {
			return userContactList;
		}
	}
	
	public void addContact(String friendUsername) throws UserDoesNotExistException{
		if(friendUsername.equals(m_UserProfile.getUserName())){
			throw new IllegalArgumentException("User cannot add themselves");
		} else {
			Node friend = Graph.findNode(friendUsername);
			if(friend == null){
				throw new UserDoesNotExistException("User does not exist in the system.");
			} else {
				m_User.createEdge(m_UserProfile.getUserName(), friendUsername, false);
				ContactList friendList = getContactList(friendUsername);
				friendList.getUser().createEdge(friendUsername, m_UserProfile.getUserName(), false);
				this.addFriendRequest(m_User.getEdge(friendUsername));
			}
		}		
	}
	
	public void removeContact(Profile friend) throws UserDoesNotExistException{
		if(!m_ContactList.contains(friend)){
			throw new UserDoesNotExistException(friend + " is not your in your contact list");
		} else {
			m_ContactList.remove(friend);
		}
	}
	
	public Profile findContact(String name) throws UserDoesNotExistException{
		Profile friend = null;
		for(Profile p : m_ContactList){
			if(p.getUserName().equals(name)){
				friend = p;
				break;
			}
		}		
		if(friend == null){
			throw new UserDoesNotExistException(name + " is not in your contact list");
		} else {
		return friend;
		}
	}
	
	public void acceptFriendRequest(String newFriend){
		Node friend = Graph.findNode(newFriend);
		Edge friendEdge = friend.getEdge(m_UserProfile.getUserName());
		friendEdge.setIsBidirectional(true);
		m_User.createEdge(m_UserProfile.getUserName(), newFriend, true);
		m_ContactList.add(friend.getElement());
		this.removeFriendRequest(newFriend);
		
	}
	
	public void declineFriendRequest(String friendRequest){
		Node friend = Graph.findNode(friendRequest);
		Edge friendEdge = friend.getEdge(m_UserProfile.getUserName());
		friend.removeEdge(friendEdge);
		Edge userEdge = m_User.getEdge(friendRequest);
		this.m_FriendRequests.remove(userEdge);
	}
	
	private void removeFriendRequest(String person){
		for(Edge e : m_FriendRequests){
			if(e.getFriend().getElement().getUserName().equals(person)){
				m_FriendRequests.remove(e);
				break;
			}
		}
	}
	
	private void addFriendRequest(Edge e){
		m_FriendRequests.add(e);
	}

	
	
	private ArrayList<Profile> m_ContactList = new ArrayList<>();
	private ArrayList<Edge> m_FriendRequests = new ArrayList<>();
	private static ArrayList<ContactList> m_SystemContactLists = new ArrayList<>();
	private Profile m_UserProfile;
	private Node m_User;
}
