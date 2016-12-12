import java.util.ArrayList;
/**
* @author Aisha Ekangaki
* Conversations.java stores the conversation history for all users
*/
public class Conversations {
	private ArrayList<Message> m_messages;
	
	/**
	* Creates a conversations object
	* @param messages is an arraylist of all the messages in the syste,
	*/
	Conversations(ArrayList<Message> messages){
		this.m_messages = messages;
	}
	
	/**
	* @return all the messages in the system
	*/
	public ArrayList<Message> getMessages(){
		return m_messages;
	}
	
	/**
	* Adds a newly sent message to the system
	* @param m the message to be written to the system
	*/
	public void addNewMessage(Message m){
		m_messages.add(m);
	}
}
