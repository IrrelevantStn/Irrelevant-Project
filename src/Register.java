

import java.util.ArrayList;

public class Register {

	public Register(Profile NewProfile ) {
		this.NewProfile = NewProfile;
	}
	
	public void createNewUser() {
		
		ArrayList<Profile> profiles = new FileReader().readProfiles();
		if (null == profiles ) {
			profiles = new ArrayList<Profile>();
		}
		
		profiles.add(NewProfile );
		new FileWriter().writeProfiles(profiles );
		
	}
	
	public boolean checkUserName() {
		
		ArrayList<String > userNames = new FileReader().getUsernames();
		if (null==userNames ) {
			return true;
		}
		
		for (String p: userNames ) {
			if (NewProfile.getUserName().equals(p ) ) {
				return false;
			}
		}
		return true;
	}
	
	private Profile NewProfile;	
}
