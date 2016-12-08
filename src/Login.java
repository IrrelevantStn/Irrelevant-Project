import java.io.*;
public class Login {
	FileReader fr;
	
	public void loginDetailsCorrect(String u, String p){
		if(fr.readLogin(u, p)){
			MainMenuView();
		}else{
			LoginView("Failed Login");
		}
	
	}
	

}
