import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	public MainFrame(){
		setTitle("Skypertawe");
		setSize(1000, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setVisible(true);
	}
	
	public static void main(String[] args){
		MainFrame m = new MainFrame();
		Date date = new Date();
		Profile a = new Profile("aaa","Adam","Adam","Thomas","2342",date,"London");
		Profile b = new Profile("bbb","Bob","Bob","Thomas","34523",date,"Swansea");
		Profile cc = new Profile("ccc","Clara","Clara","Smith","65323",date,"Swansea");
		Profile d = new Profile("ddd","David","David","Smith","7627",date,"London");
		Graph.addProfile(a);
		Graph.addProfile(b);
		Graph.addProfile(cc);
		Graph.addProfile(d);
		ContactList c = new ContactList(a);
		ContactList f = new ContactList(b);
		ContactList g = new ContactList(cc);
		ContactList h = new ContactList(d);
		
		c.addContact("bbb");
		c.addContact("ccc");
		c.addContact("ddd");
		f.addContact("aaa");
		g.addContact("aaa");
		h.addContact("aaa");
		
		c.acceptFriendRequest("bbb");
		c.acceptFriendRequest("ccc");
		//JPanel panel = new JPanel();
		ContactsPanel p = new ContactsPanel(c);
		//p.setPreferredSize(new Dimension(200, 600));
		m.add(p, BorderLayout.WEST);
		//p.setTitle("Skypertawe Contacts List");
		//p.setLocationRelativeTo(null);
		//p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(400,800);
		p.setVisible(true);
	}

}
