import java.util.ArrayList;

public class Graph {
	private static ArrayList<Node> nodes;
	
	public void addProfile(Profile p){
		
		 Node n = new Node(p);
		 nodes.add(n);
	}
	
	public static Node findNode(String name){
		Node n = null;
		for(Node user : nodes){
			if(user.getElement().getUsername().equals(name)){
				n = user;
			}
		}
		return n;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
