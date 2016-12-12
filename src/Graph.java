import java.util.ArrayList;

/**
 * @author Aisha Ekangaki
 * Graph.java creates a graph for all the users in the system to be stored in
 *
 */
public class Graph {
	
	/**
	 * @return an arraylist of all the users in the system
	 */
	public static ArrayList<Node> getAllUsers(){
		return m_nodes;
	}
	
	/**
	 * Adds a profile to the graph
	 * @param p profile to be added
	 */
	public static void addProfile(Profile p){
		 Node n = new Node(p);
		 m_nodes.add(n);
		 System.out.println("The profile with the username: " + p.getUserName() +
				 			" has been successfully added to the system.");
	}
	
	/**
	 * Deletes a profile from the graph
	 * @param name username of profile to be deleted
	 * @throws UserDoesNotExistException if the profile does not exist in the system
	 */
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
	
	/**
	 * Finds a node in the graph
	 * @param name username of the user to be found
	 * @return the node of the user
	 * @throws UserDoesNotExistException if the user is not in the system
	 */
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
	
	private static ArrayList<Node> m_nodes = new ArrayList<>();
}
