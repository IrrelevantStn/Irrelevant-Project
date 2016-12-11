import java.util.Objects;

public class Login {
	FileReader fr = new FileReader();
	
	public boolean loginDetailsCorrect(String u, String p){
        //System.out.println("In loginDetails");
        return Objects.equals(fr.readPassword(u), p);
	}
}

