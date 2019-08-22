package view;

import javax.swing.SwingUtilities;

import controllers.DataController;
import controllers.DbsController;

/**
 * @author Ivica Kustura
 * @version 1.00
 * @since august 2019
 * 
 *
 */
public class App {

	private static DbsController dbsController;

	private static MainFrame mf;
	private static DataController dc;

	public static void main(String[] args) {
		dbsController = new DbsController();
		mf = new MainFrame();
		dc = new DataController();
		mf.subscribe(dc);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				dbsController.getAllDataFromDb();

				System.out.println("App Running....");
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

			}
		});

	}

}
