import java.util.ArrayList;
import java.util.Objects;

public class Login {
	FileReader fr = new FileReader();
	
	public boolean loginDetailsCorrect(String u, String p){
        //System.out.println("In loginDetails");
        return Objects.equals(fr.readPassword(u), Encrypt.hashString(p, fr.readSalt(u)));
	}
	
	
	public ArrayList<Profile> getProfiles() {

        return fr.readProfiles();
		
	}
	
	public Graph readUsers(ArrayList<Profile> profiles) {

        return fr.readUsers(profiles);
	}
	
	public Conversations getConv() {
        return fr.readConversations();
	}
	
	public ContactList getContacts(Profile user) {
        return fr.readContacts(user);
		
	}
	
	
}