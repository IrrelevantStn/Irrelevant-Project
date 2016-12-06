
public class Edge {
	private final Node a;
	private final Node b;
	private boolean isBidirectional;
	
	public Edge(Node a, Node b, boolean isBidirectional){
		this.a = a;
		this.b = b;
		this.isBidirectional = isBidirectional;
	}

	public Node getA() {
		return a;
	}

	public Node getB() {
		return b;
	}

	public boolean isBidirectional() {
		return isBidirectional;
	}
	
	public void setIsBidirectional(boolean m){
		this.isBidirectional = m;
	}
}
