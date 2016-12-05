package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FileReader {

	Scanner m_in;

	public void openFile(String filename) {

		File inputFile = new File(filename);
		m_in = null;

		try {

			m_in = new Scanner(inputFile);

		} catch (FileNotFoundException e) {

			System.out.println("File not found");
			System.exit(0);

		}

	}

	public void closeFile(String filename) {

		m_in.close();

	}

	public ArrayList<Profile> readProfiles() {

		ArrayList<Profile> profileList = new ArrayList<Profile>();
		
		while (m_in.hasNextLine() == true) {
			
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
			
			Profile temp = new Profile(username,firstName,surname,number,birthday,city,
					numNewMsg,lastLogin,profImg,userid,password);
			profileList.add(temp);
			
		}
		
		return profileList;

	}

	public Boolean readLogin(String username, String password) {

		while (m_in.hasNextLine() == true) {

			String record = m_in.nextLine();
			String[] recArray = record.split(",");

			if (recArray[0].equalsIgnoreCase(username)) {
				if (recArray[1].equals(password)) {

					return true;

				} else
					return false;
			}

		}

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
		
		ContactList contacts = new ContactList();
		
		while(m_in.hasNextLine() == true) {
			
			String line = m_in.nextLine();
			String[] lineArray = line.split(",");
			Boolean isRequest;
			
			if (lineArray[2] == "true") {
				isRequest = true;
			} else isRequest = false;
			
			
			if (username.equals(lineArray[0])) {
				contacts.addContact(lineArray[1],isRequest);
			}
			
		}
		return contacts;
	}

	public Conversations readConversations() {
		
		Conversations conversation = new Conversations();

		
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
			
			conversation.addMessage(msg);
			
			
		}

		return conversation;
	}
	
	public ArrayList<String> getUsernames() {
		ArrayList<String> usernames = new ArrayList<String>();
		while (m_in.hasNextLine() == true) {
			
			String profiles = m_in.nextLine();
			String[] profArray = profiles.split(",");
			
			String user = profArray[3];
			usernames.add(user);
		}
		
		return usernames;
	}

	public ArrayList<DrawingPalette> readDrawings(Graph users) {

		ArrayList<DrawingPalette> drawingList = new ArrayList<DrawingPalette>();
		DrawingPalette drawing = new DrawingPalette();
		
		while (m_in.hasNextLine() == true) {
			
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
		
		return drawingList;
	}

}
