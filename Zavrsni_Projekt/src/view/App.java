package view;

import javax.swing.SwingUtilities;

import controllers.DbsController;

public class App {

	private static DbsController dbsController;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				new MainFrame();
				System.out.println("App Running....");

			}
		});
		new Thread(new Runnable() {

			@Override
			public void run() {
				dbsController = new DbsController();
				dbsController.getAllDataFromDb();
			
				
			}
		}).start();
	}

}
