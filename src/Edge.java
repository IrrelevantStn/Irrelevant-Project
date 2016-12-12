/**
 * @author Aisha Ekangaki
 * Edge.java stores the relationship between two users
 */
public class Edge {
	/**
	 * Creates an edge 
	 * @param user the user creating the edge
	 * @param friend the friend the relationship is created with
	 * @param isBidirectional false if not accepted, true is friend request is accepted
	 */
	public Edge(Node user, Node friend, boolean isBidirectional){
		this.USER = user;
		this.FRIEND = friend;
		this.m_isBidirectional = isBidirectional;
	}
	
	/**
	 * @return the user creating the ede
	 */
	public Node getUser() {
		return USER;
	}

	/**
	 * @return the friend the relationship is created with
	 */
	public Node getFriend() {
		return FRIEND;
	}

	/**
	 * @return boolean value to state what type of relationship
	 */
	public boolean isBidirectional() {
		return m_isBidirectional;
	}
	
	/**
	 * Sets the relationship between user and friend
	 * @param b boolean variable to depict the relationship
	 */
	public void setIsBidirectional(boolean b){
		this.m_isBidirectional = b;
	}
	
	
	private final Node USER;
	private final Node FRIEND;
	private boolean m_isBidirectional;
}
