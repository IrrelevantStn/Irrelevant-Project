
import java.util.ArrayList;

/**
 * @author Aisha Ekangaki
 * Node.java contains information for each user
 */
public class Node {
	/**
	 * Creates a node
	 * @param element stores the user's profile as the element
	 */
	public Node(Profile element){
		this.m_element = element;
	}
	
	/**
	 * @return the profile of a user in the system
	 */
	public Profile getElement(){
		return m_element;
	}
	
	/**
	 * @return the list of edges associated with that user, friends and friend requests
	 */
	public ArrayList<Edge> getEdgeList(){
		return m_edgeList;
	}
	
	/**
	 * Creates an edge for the node to create a relationship with another user
	 * @param user the user's username that is creating the edge
	 * @param friend the username of friend being added
	 * @param isBidirectional differs between friends and friend requests
	 */
	public void createEdge(String user, String friend, Boolean isBidirectional){		
		Node a = Graph.findNode(user);
		Node b = Graph.findNode(friend);
		Edge e = new Edge(a,b, isBidirectional);
		m_edgeList.add(e);
		System.out.println("Test works");
	}
	
	/**
	 * Gets the edge that represents the friendship
	 * @param friend username of friend's edge to be found
	 * @return the edge of the friend
	 * @throws IllegalArgumentException if there is no relationaship between the user and friend
	 */
	public Edge getEdge(String friend) throws IllegalArgumentException{
		Edge friendEdge = null;
		for(Edge e : m_edgeList){
			if(e.getFriend().getElement().getUserName().equals(friend)){
				friendEdge = e;
			}
		}
		if(friendEdge == null){
			throw new IllegalArgumentException("No edge exists between " + m_element.getUserName() + " and " + friend);
		} else {
			return friendEdge;
		}
	}
	
	/**
	 * Removes an edge from the node
	 * @param e edge to be removed
	 */
	public void removeEdge(Edge e){
		m_edgeList.remove(e);
	}
	
	
	private ArrayList<Edge> m_edgeList = new ArrayList<>();
	private Profile m_element;
}
