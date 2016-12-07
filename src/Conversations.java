import java.util.ArrayList;

public class Conversations {
	private ArrayList<Message> m_msgSent;
	private ArrayList<Message> m_msgReceived;
	
	Conversations(ArrayList<Message> msgSent, ArrayList<Message> msgReceived){
		this.m_msgSent = msgSent;
		this.m_msgReceived = msgReceived;
	}
	
	public void saveChanges(){
		FileWriter.conversationHistory(m_msgSent, m_msgReceived);
	}
	
}
