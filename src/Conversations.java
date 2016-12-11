import java.util.ArrayList;

public class Conversations {
	private ArrayList<Message> m_messages;
	
	Conversations(ArrayList<Message> messages){
		this.m_messages = messages;
	}
	
	public void addNewMessage(Message m){
		m_messages.add(m);
	}
}
