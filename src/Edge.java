
public class Edge {
	private final Node USER;
	private final Node FRIEND;
	private boolean m_isBidirectional;
	
	public Edge(Node user, Node friend, boolean isBidirectional){
		this.USER = user;
		this.FRIEND = friend;
		this.m_isBidirectional = isBidirectional;
	}

	public Node getUser() {
		return USER;
	}

	public Node getFriend() {
		return FRIEND;
	}

	public boolean isBidirectional() {
		return m_isBidirectional;
	}
	
	public void setIsBidirectional(boolean b){
		this.m_isBidirectional = b;
	}
	
	public String toString(){
		return("Edge test works");
	}
}
