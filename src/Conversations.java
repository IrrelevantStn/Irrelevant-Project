import java.util.ArrayList;

public class Conversations {
	private ArrayList<Message> m_messages;
	
	Conversations(ArrayList<Message> messages){
		this.m_messages = messages;
	}
	
	public void addNewMessage(Message m){
		m_messages.add(m);
	}

	public void getContent(Message m1){
		if (m1 instanceof TextMessage){

		}
		else if (m1 instanceof FileMessage){

		}
		else if (m1 instanceof PathMessage){

		}
		else{
			System.out.println("Didn't work, check the type of Message. " +
					"*shrug*");
		}
	}
}
