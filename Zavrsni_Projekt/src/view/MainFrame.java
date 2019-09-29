package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import controllers.DataController;
import controllers.observable;
import controllers.observer;
import models.User;

import javax.swing.JScrollPane;
import java.awt.GridLayout;

/**
 * @author Ivica Kustura
 */
public class MainFrame extends JFrame implements observer {

	/**
	 * Class that contains all visual elements of the application it implements
	 * custom Observer patter for real time user updates {@link observer observable}
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JButton btnClose;
	private JPanel panelTop;
	private JPanel panelLeft;
	private JPanel panelCenter;
	private JButton btnShowStats;
	private JButton btnGetUsers;
	private DataController dataController;
	private JScrollPane scrollPane;
	private UserPresenter userPresenter;
	private StatsPresenter statsPresenter;
	private AddNewUserPanel addUserPanel;
	private List<User> userList;
	private JButton buttonAddNewUser;

	public MainFrame() {
		dataController = new DataController();

		setSize(1400, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);

		mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		panelTop = new JPanel();
		panelTop.setBackground(new Color(50, 155, 156));
		panelTop.setBounds(0, 0, 1400, 60);
		mainPanel.add(panelTop);
		panelTop.setLayout(null);

		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(42, 89, 107));
		panelLeft.setBounds(0, 60, 250, 660);
		mainPanel.add(panelLeft);
		panelLeft.setLayout(null);

		btnClose = new JButton("Close");
		btnClose.setBounds(60, 600, 130, 30);
		panelLeft.add(btnClose);

		btnShowStats = new JButton("Show Data");
		btnShowStats.setBounds(60, 45, 130, 30);
		panelLeft.add(btnShowStats);

		btnGetUsers = new JButton("Show Users");
		btnGetUsers.setBounds(60, 107, 130, 30);
		panelLeft.add(btnGetUsers);
		
		buttonAddNewUser = new JButton("Add User");
		buttonAddNewUser.setBounds(60, 167, 130, 30);
		panelLeft.add(buttonAddNewUser);
		

		scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 60, 1150, 660);
		mainPanel.add(scrollPane);

		panelCenter = new JPanel();
		scrollPane.setViewportView(panelCenter);

		panelCenter.setBackground(new Color(235, 245, 245));
		GridLayout gl_panelCenter = new GridLayout(0, 1);
		panelCenter.setLayout(gl_panelCenter);
		gl_panelCenter.setVgap(25);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panelCenter.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));

		setVisible(true);

		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);

		activateComp();

	}

	/**
	 * Method for adding action listeners to the components
	 * 
	 * 
	 */
	private void activateComp() {

	
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		btnShowStats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCenter.removeAll();
				panelCenter.updateUI();
				panelCenter.revalidate();
				statsPresenter = new StatsPresenter();
				panelCenter.add(statsPresenter);

			}
		});
		btnGetUsers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userList = dataController.getUserList();
				panelCenter.removeAll();
				panelCenter.updateUI();
				panelCenter.revalidate();
				for (int i = 0; i < userList.size(); i++) {
					userPresenter = new UserPresenter(panelCenter, scrollPane, userList.get(i).get_id(),
							userList.get(i).getFisrtName(), userList.get(i).getLastName(), userList.get(i).getEmail());

					panelCenter.add(userPresenter);
				}
			}
		});
		buttonAddNewUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelCenter.removeAll();
				panelCenter.updateUI();
				panelCenter.revalidate();
				addUserPanel = new AddNewUserPanel();
				panelCenter.add(addUserPanel);
			}
		});

	}

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	/**
	 * Inner class that allows dragging the application with mouse
	 **/
	private static class FrameDragListener extends MouseAdapter {

		private final JFrame frame;
		private Point mouseDownCompCoords = null;

		public FrameDragListener(JFrame frame) {
			this.frame = frame;
		}

		public void mouseReleased(MouseEvent e) {
			mouseDownCompCoords = null;
		}

		public void mousePressed(MouseEvent e) {
			mouseDownCompCoords = e.getPoint();
		}

		public void mouseDragged(MouseEvent e) {
			Point currCoords = e.getLocationOnScreen();
			frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
		}
	}

	@Override
	public void subscribe(observable o) {
		o.add(this);
	}

	/**
	 * Updates users on panelCenter
	 * 
	 * @param userList - List
	 */

	@Override
	public void update(List<User> userList) {
		System.out.println(userList.size());
		panelCenter.removeAll();

		for (int i = 0; i < userList.size(); i++) {
			userPresenter = new UserPresenter(panelCenter, scrollPane, userList.get(i).get_id(),
					userList.get(i).getFisrtName(), userList.get(i).getLastName(), userList.get(i).getEmail());

			panelCenter.add(userPresenter);
		}
		panelCenter.updateUI();
		panelCenter.revalidate();
		panelCenter.repaint();

	}
}
