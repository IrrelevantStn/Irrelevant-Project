import java.util.ArrayList;

public class ContactList {
	private ArrayList<Profile> m_contactList = new ArrayList<>();
	
	public ArrayList<Profile> getContactList(){
		return m_contactList;
	}
	
	public void addContact(String friend) throws UserDoesNotExistException{
		Node n = Graph.findNode(friend);
		if(n == null){
			throw new UserDoesNotExistException("User does not exist in the system.");
		} else {
			m_contactList.add(n.getElement());
			System.out.println("Friend: " + friend +" successfully added");
		}
	}
	
	public void removeContact(Profile friend){
		m_contactList.remove(friend);
		System.out.println("Friend: " + friend + " has been removed");
	}
	
	public Profile findContact(String name) throws UserDoesNotExistException{
		Profile friend = null;
		for(Profile p : m_contactList){
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
	
	public String toString(){
		return("ContactList test works");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
