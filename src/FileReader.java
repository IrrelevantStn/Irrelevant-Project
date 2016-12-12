

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FileReader {

	private final String profFilePath = "src\\Profile.txt";
	private final String contactsFilePath = "src\\Contacts.txt";
	private final String convFilePath = "src\\Conversations.txt";
	private final String drawFilePath = "src\\Drawings.txt";
	
	

	public Scanner openFile(String filename) {

		File inputFile = new File(filename);
		Scanner in = null;

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

	public ArrayList<Profile> readProfiles() throws NoSuchProviderException, NoSuchAlgorithmException{

		Scanner m_in = openFile(profFilePath);
		if (null == m_in ) {
			return null;
		}
		
		ArrayList<Profile > profileList = new ArrayList<Profile>();
		
		while (m_in.hasNextLine() ) {
			
			String user = m_in.nextLine();
			String[] userArray = user.split(",");

			String firstName = userArray[0];
			String lastName = userArray[1];
			String userName = userArray[2];
			byte[] salt = userArray[3].getBytes();
			String password = userArray[4];
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy" );
			Date birthday = null;
			try {
				birthday = sdf.parse(userArray[5] + userArray[6] +
						userArray[7]);
			} catch (ParseException e ) {
				// e.printStackTrace();
				birthday = Calendar.getInstance().getTime();
			}

			String city = userArray[8];
//			int newMessages = Integer.parseInt(userArray[7] );
			String telephone = userArray[9];
			
			Date lastLogin = null;
			try {
				lastLogin = sdf.parse(userArray[10] + userArray[11] +
						userArray[12] );
			} catch (ParseException e ) {
				// e.printStackTrace();
				lastLogin = Calendar.getInstance().getTime();
			}
			
			String profImg = userArray[13];
			
			Profile temp = new Profile(userName, password, salt, firstName,
					lastName, telephone, birthday, city, lastLogin, profImg
			);
			
//			temp.setLastLogin(lastLogin);
//			temp.setProfImg(profImg);

			profileList.add(temp);
		}
		
		closeFile(m_in);
		return profileList;

	}

	public String readPassword(String username) {

		Scanner m_in = openFile(profFilePath);
		
		while (m_in.hasNextLine() == true) {

			String record = m_in.nextLine();
			String[] recArray = record.split(",");

			if (recArray[0].equalsIgnoreCase(username)) {
				closeFile(m_in);
				return recArray[1];
			}
		}
		closeFile(m_in);
		return null;

	}

    public byte[] readSalt(String username) {

        Scanner m_in = openFile(profFilePath);

        while (m_in.hasNextLine() == true) {

            String record = m_in.nextLine();
            String[] recArray = record.split(",");

            if (recArray[0].equalsIgnoreCase(username)) {
                closeFile(m_in);
                return recArray[2].getBytes();
            }
        }
        closeFile(m_in);
        return null;

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
		
		while(m_in.hasNextLine() == true) {
			
			String line = m_in.nextLine();
			String[] lineArray = line.split(",");
			Boolean isRequest;
			
			if (lineArray[2] == "true") {
				isRequest = true;
			} else isRequest = false;
			
			
			if (username.equals(lineArray[0])) {
				contacts.addContact(lineArray[1]);
			}
			
		}
		closeFile(m_in);
		return contacts;
	}

	public Conversations readConversations() {
		
		Scanner m_in = openFile(convFilePath);
		Conversations conversation = new Conversations(new ArrayList<Message>());

		
		while (m_in.hasNextLine() == true) {
			
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
				
			case "url" :    msg = new UrlMessage(destination,source,timeStamp,textDesc,data);
							break;
			case "text"	:	msg = new TextMessage(destination,source,timeStamp,data);
							break;
			case "file"	:	msg = new FileMessage(destination,source,timeStamp,textDesc,data);
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
		
		while(m_in.hasNextLine() == true) {
			
			String profiles = m_in.nextLine();
			String[] profArray = profiles.split(",");
			
			String user = profArray[3];
			usernames.add(user);
		}
		
		closeFile(m_in);
		return usernames;
	}

	public ArrayList<String> readDrawings(Graph users,Profile p) {

		Scanner m_in = openFile(drawFilePath);
		ArrayList<String> drawingList = new ArrayList<String>();
		//DrawingPalette drawing = new DrawingPalette();
		
		while (m_in.hasNextLine() == true) {
			
			String line = m_in.nextLine();
			String[] lineArray = line.split(",");
			
			String filePath = lineArray[0];
			ArrayList<Profile> authors = new ArrayList<Profile>();
			
			Boolean isAuthor = false;
			
			for (int x = 1; x < lineArray.length; x++) {
				Profile prof = users.findNode(lineArray[x]).getElement();
				if (prof == p) {
					isAuthor = true;
				}
				authors.add(p);
			}
			
			drawingList.add(filePath);
			
		}
		
		closeFile(m_in);
		return drawingList;
	}

}
