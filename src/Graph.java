import java.util.ArrayList;

public class Graph {
	private static ArrayList<Node> m_nodes = new ArrayList<>();
	
	public static ArrayList<Node> getAllUsers(){
		return m_nodes;
	}
	
	public static void addProfile(Profile p){
		 Node n = new Node(p);
		 m_nodes.add(n);
		 System.out.println("The profile with the username: " + p.getUserName() +
				 			" has been successfully added to the system.");
	}
	
	public static void deleteProfile(String name) throws UserDoesNotExistException{
		for (Node user : m_nodes) { 
		    if (user.getElement().getUserName().equals(name)) {
		       m_nodes.remove(user);
		       System.out.println("Successfully deleted account with username: " + name);
		        break;
		    } else {
		    	throw new UserDoesNotExistException("The user " + name + " does not exist in the system.");
		    }
		}
	}
	
	public static Node findNode(String name) throws UserDoesNotExistException{
		Node n = null;
		for (Node user : m_nodes) { 
			String s = user.getElement().getFirstName() + " " + user.getElement().getLastName();
		    if (user.getElement().getUserName().equals(name) || s.equals(name)) {
		        n = user;
		        break;
		    }
		}
		if(n==null){
			throw new UserDoesNotExistException("User does not exist in the system.");
		} else {
			return n;
		}		
	}
	
	public String toString(){
		return("Graph test works");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
