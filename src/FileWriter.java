import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FileWriter {

	private final String profFilePath = "Profile.txt";
	private final String contactsFilePath = "Contacts.txt";
	private final String convFilePath = "Conversations.txt";
	private final String drawFilePath = "Drawings.txt";
	
	

	public PrintWriter openFile(String filename) {

		File outputFile = new File(filename);
		PrintWriter out;

		try {

			out = new PrintWriter(outputFile);
			return out;
			
		} catch (FileNotFoundException e) {

			System.out.println("File not found");
			return null;

		}

	}

	public void closeFile(PrintWriter out) {

		out.close();

	}

	public Boolean writeProfile(Profile p) {

		PrintWriter out = openFile(profFilePath);
		
		String userid = Integer.toString(p.getProfId());
		String firstName = p.getFirstName();
		String surname = p.getSurname();
		String username = p.getUsername();
		String password = p.getPassword();
		Calendar temp = Calendar.getInstance();
		temp.setTime(p.getBirthday());
		String birthDay = Integer.toString(temp.DAY_OF_YEAR);
		String birthMonth = Integer.toString(temp.MONTH);
		String birthYear = Integer.toString(temp.YEAR);

		String city = p.getCity();
		String number = p.getNumber();
		String numNewMsg = Integer.toString(p.getNewMessages());
		temp.setTime(p.getBirthday());
		String lastLoginDay = Integer.toString(temp.DAY_OF_YEAR);
		String lastLoginMonth = Integer.toString(temp.MONTH);
		String lastLoginYear = Integer.toString(temp.YEAR);
		String profImg = p.getProfImg();

		String add = userid;
		add += ",";
		add += firstName;
		add += ",";
		add += surname;
		add += ",";
		add += username;
		add += ",";
		add += password;
		add += ",";
		add += birthDay;
		add += ",";
		add += birthMonth;
		add += ",";
		add += birthYear;
		add += ",";
		add += city;
		add += ",";
		add += number;
		add += ",";
		add += numNewMsg;
		add += ",";
		add += lastLoginDay;
		add += ",";
		add += lastLoginMonth;
		add += ",";
		add += lastLoginYear;
		add += ",";
		add += profImg;
		add += ",";

		out.println(add);

		closeFile(out);
		return true;

	}

	public Boolean writeProfiles(ArrayList<Profile> profiles) {

		for (Profile p : profiles) {

			writeProfile(p);

		}

		return true;

	}

	public Boolean writeContacts(ContactList contacts) {

		PrintWriter out = openFile(contactsFilePath);
		
		for (Profile p : contacts.getContacts()) {

			String isRequest;
			if (contacts.isRequest() == true) {
				isRequest = "true";
			} else
				isRequest = "false";

			String result = "";
			result += contacts.getProfile().getUsername();
			result += p.getUsername();
			result += isRequest;

			out.println(result);
		}

		closeFile(out);
		return true;
	}

	public Boolean writeConversation(String destination, String source, Date
			timeStamp, String textDesc, String data) {

		PrintWriter out = openFile(convFilePath);
		
		Calendar date = Calendar.getInstance();
		date.setTime(timeStamp);
		
		String day = Integer.toString(date.getFirstDayOfWeek());
		String month = Integer.toString(date.MONTH);
		String year = Integer.toString(date.YEAR);
		
		String printLine = "";
		printLine += destination;
		printLine += ",";
		printLine += source;
		printLine += ",";
		printLine += day;
		printLine += ",";
		printLine += month;
		printLine += ",";
		printLine += year;
		printLine += ",";
		printLine += textDesc;
		printLine += ",";
		printLine += data;
		
		
		out.println(printLine);
		
		closeFile(out);
		return true;
	}

	public Boolean writeDrawing(DrawingPalette drawing) {
		PrintWriter out = openFile(drawFilePath);
		
		String writeLine = "";
		String filePath = drawing.getFilePath();
		ArrayList<Profile> prof = drawing.getAuthors();

		writeLine += filePath;
		writeLine += ",";
		for (Profile p : prof) {
			writeLine += p.getUsername();
			writeLine += ",";
		}

		out.println(writeLine);

		closeFile(out);
		return true;
	}

}
