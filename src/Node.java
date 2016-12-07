
import java.util.ArrayList;

public class Node {
	private ArrayList<Edge> m_edgeList = new ArrayList<>();
	private Profile m_element;
	
	public Node(Profile element){
		this.m_element = element;
	}
	
	public Profile getElement(){
		return m_element;
	}
	
	public ArrayList<Edge> getEdgeList(){
		return m_edgeList;
	}
	
	public void createEdge(String user, String friend, Boolean isBidirectional){		
		Node a = Graph.findNode(user);
		Node b = Graph.findNode(friend);
		Edge e = new Edge(a,b, isBidirectional);
		m_edgeList.add(e);
		System.out.println("Test works");
	}
	
	public String toString(){
		return("Profile: " + m_element);
	}
}
