
import java.util.ArrayList;

public class Node {
	ArrayList<Edge> edgeList = new ArrayList<>();
	Profile element;
	
	public Node(Profile element){
		this.element = element;
	}
	
	public Profile getElement(){
		return element;
	}
	
	public ArrayList<Edge> getEdgeList(){
		return edgeList;
	}
	
	public void createEdge(String user, String friend, Boolean isBidirectional){
		
		Node a = Graph.findNode(user);
		Node b = Graph.findNode(friend);
		Edge e = new Edge(a,b, isBidirectional);
		edgeList.add(e);
	}	
}
