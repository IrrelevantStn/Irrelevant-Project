

import java.util.ArrayList;

public class Register {

	public Register(Profile NewProfile) {
		this.m_NewProfile = NewProfile;
	}

	public void createNewUser() {

		ArrayList<Profile> profiles = new FileReader().readProfiles();
		if (null == profiles) {
			profiles = new ArrayList<Profile>();
		}

		profiles.add(m_NewProfile);
		new FileWriter().writeProfiles(profiles);

	}

	public boolean checkUserName() {

		ArrayList<String> userNames = new FileReader().getUsernames();
		if (null == userNames) {
			return true;
		}

		for (String p : userNames) {
			if (m_NewProfile.getUserName().equals(p)) {
				return false;
			}
		}
		return true;
	}

	private Profile m_NewProfile;
}
