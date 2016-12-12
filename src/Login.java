import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Objects;

public class Login {
	FileReader fr = new FileReader();
	
	public boolean loginDetailsCorrect(String u, String p){
        //System.out.println("In loginDetails");
        return Objects.equals(fr.readPassword(u), Encrypt.hashString(p, fr.readSalt(u)));
	}
	
	
	public ArrayList<Profile> getProfiles() {
		
		ArrayList<Profile> profiles = fr.readProfiles();
		return profiles;
		
	}
	
	public Graph readUsers(ArrayList<Profile> profiles) {
		
		Graph graph = fr.readUsers(profiles);
		return graph;
	}
	
	public Conversations getConv() {
		Conversations conv = fr.readConversations();
		return conv;
	}
	
	public ContactList getContacts(String username) {
		ContactList contacts = fr.readContacts(username);
		return contacts;
		
	}
	
	
}