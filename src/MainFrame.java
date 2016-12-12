import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Aisha Ekangaki
 * MainFrame.java is class that helps to display the partial implementation of ContactsPanel.java
 *
 */
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
		
		ContactsPanel p = new ContactsPanel();
		m.add(p, BorderLayout.WEST);

		p.setSize(400,800);
		p.setVisible(true);
	}

}