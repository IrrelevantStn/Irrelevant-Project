import java.io.*;
public class Login {
	FileReader fr;
	
	public boolean loginDetailsCorrect(String u, String p){
		if(fr.readLogin(u, p)){
			return true;
		}else{
			return false;
		}
	
	}
	

}

