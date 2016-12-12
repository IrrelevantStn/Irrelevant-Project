import java.util.ArrayList;

/**
 * @author Aisha Ekangaki
 * ContactList.java is a class that contains all the friend operations that are available in Skypertawe
 */

public class ContactList {
	
	/**
	 * @param p The profile of the current user of the system
	 * Retrieves contact list details about the user currently logged in
	 */
	public ContactList(Profile p){
		this.m_UserProfile = p;
		this.m_User = Graph.findNode(p.getUserName());
		setContactList();
		setFriendRequests();
		m_SystemContactLists.add(this);
	}
	
	/**
	 * Sets the contact list of user by finding edges that the friend request has been accepted
	 */
	private void setContactList(){
		for(Edge e : m_User.getEdgeList()){
			boolean isFriend = e.isBidirectional();
			if(isFriend == true && !m_ContactList.contains(e)){
				this.m_ContactList.add(e.getFriend().getElement());
			}
		}
	}
	/**
	 * Sets the list of friend request of the user by finding edges that the friend request that is still pending
	 */
	private void setFriendRequests(){
		for(Edge e : m_User.getEdgeList()){
			boolean isFriend = e.isBidirectional();
			if(isFriend == false && !m_FriendRequests.contains(e)){
				this.m_FriendRequests.add(e);
			} else if(isFriend == true && m_FriendRequests.contains(e)){
				this.m_FriendRequests.remove(e);
			}
		}
	}
	
	/**
	 * @return An arraylist of profiles, which is the user's contact list
	 */
	public ArrayList<Profile> getContactList(){
		return m_ContactList;
	}
	
	/**
	 * @return An arraylist of edges, which are the user's friend requests yet to be accepted
	 */
	public ArrayList<Edge> getFriendRequestList(){
		return m_FriendRequests;
	}
	
	/**
	 * @return The node of the current user from the graph
	 */
	private Node getUser(){
		return m_User;
	}
	
	/**
	 * A list if all contact lists in the system
	 * @param person the username of the user who's contact list is to be found
	 * @return the contact list for the user that matches the parameter person
	 * @throws UserDoesNotExistException if the user being searched for does not have a contact list in the system
	 */
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
	
	/**
	 * Adds a contact to the contact list
	 * @param friendUsername the username of the friend to be added
	 * @throws UserDoesNotExistException if the current user tries to add themselves or a 
	 * 										friend is added who isn't in the system 
	 */
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
	
	/**
	 * Removes a contact from the contact list
	 * @param friend username of the friend being removed
	 * @throws UserDoesNotExistException if the friend being removed is not in the contact list
	 */
	public void removeContact(Profile friend) throws UserDoesNotExistException{
		if(!m_ContactList.contains(friend)){
			throw new UserDoesNotExistException(friend + " is not your in your contact list");
		} else {
			m_ContactList.remove(friend);
		}
	}
	
	/**
	 * Finds contact in contact list from username
	 * @param name contact's username to be found
	 * @return the profile of the contact to be found
	 * @throws UserDoesNotExistException if the contact is not in their contact list
	 */
	public Profile findContact(String name) throws UserDoesNotExistException{
		Profile friend = null;
		for(Profile p : m_ContactList){
			String s = p.getFirstName() + " " + p.getLastName();
			if(p.getUserName().equals(name) || s.equals(name)){
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
	
	/**
	 * Accepts friend request
	 * @param newFriend the friend who sent the request
	 */
	public void acceptFriendRequest(String newFriend){
		Node friend = Graph.findNode(newFriend);
		Edge friendEdge = friend.getEdge(m_UserProfile.getUserName());
		friendEdge.setIsBidirectional(true);
		m_User.createEdge(m_UserProfile.getUserName(), newFriend, true);
		m_ContactList.add(friend.getElement());
		this.removeFriendRequest(newFriend);
		
	}
	
	/**
	 * Declines friend request
	 * @param friendRequest the friend who sent the request
	 */
	public void declineFriendRequest(String friendRequest){
		Node friend = Graph.findNode(friendRequest);
		Edge friendEdge = friend.getEdge(m_UserProfile.getUserName());
		friend.removeEdge(friendEdge);
		Edge userEdge = m_User.getEdge(friendRequest);
		this.m_FriendRequests.remove(userEdge);
	}
	
	/**
	 * Removes edge from friend requests once request is declined or accepted
	 * @param person the person who sent the request
	 */
	private void removeFriendRequest(String person){
		for(Edge e : m_FriendRequests){
			if(e.getFriend().getElement().getUserName().equals(person)){
				m_FriendRequests.remove(e);
				break;
			}
		}
	}
	
	/**
	 * Adds a friend request to the arraylist when a contact is added
	 * @param e edge to be added to friend requests
	 */
	private void addFriendRequest(Edge e){
		m_FriendRequests.add(e);
	}

	
	private ArrayList<Profile> m_ContactList = new ArrayList<>();
	private ArrayList<Edge> m_FriendRequests = new ArrayList<>();
	private static ArrayList<ContactList> m_SystemContactLists = new ArrayList<>();
	private Profile m_UserProfile;
	private Node m_User;
}
