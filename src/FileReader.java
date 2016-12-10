import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {

	private final String profFilePath = "Profile.txt";
	private final String contactsFilePath = "Contacts.txt";
	private final String convFilePath = "Conversations.txt";
	private final String drawFilePath = "Drawings.txt";



	public Scanner openFile(String filename) {

		File inputFile = new File(filename);
		Scanner in;

		try {

			in = new Scanner(inputFile);
			return in;

		} catch (FileNotFoundException e) {

			System.out.println("File not found");
			return null;

		}

	}

	public void closeFile(Scanner in) {

		in.close();

	}

	public ArrayList<Profile> readProfiles() {

		Scanner m_in = openFile(profFilePath);
		
		ArrayList<Profile> profileList = new ArrayList<Profile>();
		
		while (m_in.hasNextLine()) {
			
			String user = m_in.nextLine();
			String[] userArray = user.split(",");
			
			int userid = Integer.parseInt(userArray[0]);
			String firstName = userArray[1];
			String surname = userArray[2];
			String username = userArray[3];
			String password = userArray[4];
			int birthDay = Integer.parseInt(userArray[5]);
			int birthMonth = Integer.parseInt(userArray[6]);
			int birthYear = Integer.parseInt(userArray[7]);
			Calendar cal = Calendar.getInstance();
			cal.set(birthYear, birthMonth, birthDay);
			Date birthday = cal.getTime();
			String city = userArray[8];
			String number = userArray[9];
			int numNewMsg = Integer.parseInt(userArray[10]);
			int lastLoginDay = Integer.parseInt(userArray[11]);
			int lastLoginMonth = Integer.parseInt(userArray[12]);
			int lastLoginYear = Integer.parseInt(userArray[13]);
			Calendar last = Calendar.getInstance();
			last.set(lastLoginDay, lastLoginMonth, lastLoginYear);
			Date lastLogin = last.getTime();
			String profImg = userArray[14];
			
			Profile temp = new Profile(username,firstName,surname,number,
                    birthday,city, numNewMsg,lastLogin,profImg,userid,password);
			profileList.add(temp);
			
		}
		
		closeFile(m_in);
		return profileList;

	}

	public Boolean readLogin(String username, String password) {

		Scanner m_in = openFile(profFilePath);
		
		while (m_in.hasNextLine()) {

			String record = m_in.nextLine();
			String[] recArray = record.split(",");

			if (recArray[0].equalsIgnoreCase(username)) {
				if (recArray[1].equals(password)) {
					closeFile(m_in);
					return true;

				} else
					closeFile(m_in);
					return false;
			}

		}
		closeFile(m_in);
		return false;

	}

	public Graph readUsers(ArrayList<Profile> profiles) {

		Graph graph = new Graph();
		
		for (Profile prof : profiles) {
			graph.addProfile(prof);
		}
		
		return graph;

	}

	public ContactList readContacts(String username) {
		Scanner m_in = openFile(contactsFilePath);
		ContactList contacts = new ContactList();
		
		while(m_in.hasNextLine()) {
			
			String line = m_in.nextLine();
			String[] lineArray = line.split(",");
			Boolean isRequest;

			isRequest = Objects.equals(lineArray[2], "true");

			if (username.equals(lineArray[0])) {
				contacts.addContact(lineArray[1],isRequest);
			}
			
		}
		closeFile(m_in);
		return contacts;
	}

	public Conversations readConversations() {

		Scanner m_in = openFile(convFilePath);
		Conversations conversation = new Conversations();

		
		while (m_in.hasNextLine()) {
			
			String conv = m_in.nextLine();
			String[] convArray = conv.split(",");
			
			String msgType = convArray[0];
			String source = convArray[1];
			String destination = convArray[2];
			Calendar temp = Calendar.getInstance();
		
			int timeStampDay = Integer.parseInt(convArray[3]);
			int timeStampMonth = Integer.parseInt(convArray[4]);
			int timeStampYear = Integer.parseInt(convArray[5]);
			temp.set(timeStampYear, timeStampMonth, timeStampDay);
			Date timeStamp = temp.getTime();
			
			
			String data = convArray[6];
			String textDesc = convArray[7];
			
			
			Message msg = null;
						
			switch (msgType) {
				
			case "url" :    msg = new UrlMessage(destination,source,
                    timeStamp,textDesc,data);
							break;
			case "text"	:	msg = new TextMessage(destination,source,
                    timeStamp,data);
							break;
			case "file"	:	msg = new FileMessage(destination,source,
                    timeStamp,textDesc,data);
							break;
			default		:	break;
				
				
			}
			
			conversation.addNewMessage(msg);
			
			
		}
		closeFile(m_in);
		return conversation;
	}
	
	public ArrayList<String> getUsernames() {
		ArrayList<String> usernames = new ArrayList<String>();
		Scanner m_in = openFile(profFilePath);
		
		while (m_in.hasNextLine()) {
			
			String profiles = m_in.nextLine();
			String[] profArray = profiles.split(",");
			
			String user = profArray[3];
			usernames.add(user);
		}
		
		closeFile(m_in);
		return usernames;
	}

	public ArrayList<DrawingPalette> readDrawings(Graph users) {

		Scanner m_in = openFile(drawFilePath);
		ArrayList<DrawingPalette> drawingList = new ArrayList<DrawingPalette>();
		DrawingPalette drawing = new DrawingPalette();
		
		while (m_in.hasNextLine()) {
			
			String line = m_in.nextLine();
			String[] lineArray = line.split(",");
			
			String filePath = lineArray[0];
			ArrayList<Profile> authors = new ArrayList<Profile>();
			for (int x = 1; x < lineArray.length; x++) {
				Profile p = users.findProfile(lineArray[x]);
				authors.add(p);
			}
			
			drawing.setFilePath(filePath);
			drawing.setAuthors(authors);
			drawingList.add(drawing);
			
		}
		
		closeFile(m_in);
		return drawingList;
	}

}
