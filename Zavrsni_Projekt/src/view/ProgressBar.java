package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class ProgressBar {

	public static void main(String args[]) {
		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("Loading", SwingConstants.CENTER));
		window.setBounds(500, 150, 300, 200);
		window.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		window.setVisible(false);
		JFrame frame = new JFrame();
		frame.add(new JLabel("Welcome Swing application..."));
		frame.setVisible(true);
		frame.setSize(300, 200);
		window.dispose();
	}
}
