package view;

import javax.swing.SwingUtilities;

import controllers.DataController;
import controllers.DbsController;

/**
 * 
 * This is the main class that runs the application and calls methodes for
 * fetching data from Mongo database
 * 
 * @author Ivica Kustura
 * @version 1.00
 * @since august 2019
 * 
 * 
 * 
 *
 */

public class App {

	private static DbsController dbsController;
	private static MainFrame mf;
	private static DataController dc;

	/**
	 * Calling database controller for fetching data and adding separate threads for
	 * real time updates {@link DbsController MainFrame DataController}
	 * 
	 * @param args - String[]
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				dbsController = new DbsController();
				mf = new MainFrame();
				dc = new DataController();
				mf.subscribe(dc);
				dbsController.getAllDataFromDb();

				new Thread(new Runnable() {
					@Override
					public void run() {
						dbsController.watchForUserUpdates();

					}
				}).start();
				new Thread(new Runnable() {
					@Override
					public void run() {
						dbsController.wathcForPostUpdates();
					}
				}).start();

				System.out.println("App Running....");
			}
		});

	}

}
