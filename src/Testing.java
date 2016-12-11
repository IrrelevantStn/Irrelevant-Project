

import java.awt.EventQueue;

public class Testing {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingView frame = new DrawingView(null,null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
