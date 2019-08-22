package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.border.EtchedBorder;

import controllers.DataController;
import controllers.DbsController;
import models.Post;

public class UserPresenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnViewPosts;
	private JButton btnDeleteUser;
	private JLabel lblFirstLabel;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblUserFirstName;
	private JLabel lblUserLastName;
	private JLabel lblUserEmail;
	private String _id;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private DataController dataController;
	private JPanel panelCenter;
	private JScrollPane scrollPane;

	public UserPresenter(JPanel panelCenter, JScrollPane scrollPane, String _id, String userFistName,
			String userLastName, String userEmail) {
		super();
		dataController = new DataController();
		this.panelCenter = panelCenter;
		this.scrollPane = scrollPane;
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this._id = _id;
		this.userFirstName = userFistName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;

		layoutComp();
		setConstraints();
		activateComp();
	}

	private void setConstraints() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.columnWidths = new int[] { 81, 115, 115, 115, 227, 108, 0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		gridBagLayout.rowHeights = new int[] { 80, 75, 0 };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_btnViewPosts = new GridBagConstraints();
		gbc_btnViewPosts.anchor = GridBagConstraints.NORTH;
		gbc_btnViewPosts.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnViewPosts.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewPosts.gridy = 1;
		gbc_btnViewPosts.gridx = 5;
		add(btnViewPosts, gbc_btnViewPosts);
		GridBagConstraints gbc_btnDeleteUser = new GridBagConstraints();
		gbc_btnDeleteUser.anchor = GridBagConstraints.SOUTH;
		gbc_btnDeleteUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeleteUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteUser.gridy = 0;
		gbc_btnDeleteUser.gridx = 5;
		add(btnDeleteUser, gbc_btnDeleteUser);
		GridBagConstraints gbc_lblFirstLabel = new GridBagConstraints();
		gbc_lblFirstLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblFirstLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstLabel.gridy = 0;
		gbc_lblFirstLabel.gridx = 1;
		add(lblFirstLabel, gbc_lblFirstLabel);
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblLastName.gridx = 2;
		gbc_lblLastName.gridy = 0;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		add(lblLastName, gbc_lblLastName);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEmail.gridx = 3;
		gbc_lblEmail.gridy = 0;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		add(lblEmail, gbc_lblEmail);
		GridBagConstraints gbc_lblUserFirstName = new GridBagConstraints();
		gbc_lblUserFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUserFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserFirstName.gridx = 1;
		gbc_lblUserFirstName.gridy = 1;
		add(lblUserFirstName, gbc_lblUserFirstName);
		GridBagConstraints gbc_lblUserLastName = new GridBagConstraints();
		gbc_lblUserLastName.anchor = GridBagConstraints.NORTH;
		gbc_lblUserLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUserLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserLastName.gridy = 1;
		gbc_lblUserLastName.gridx = 2;
		add(lblUserLastName, gbc_lblUserLastName);
		GridBagConstraints gbc_lblUserEmail = new GridBagConstraints();
		gbc_lblUserEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUserEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserEmail.gridy = 1;
		gbc_lblUserEmail.gridx = 3;
		add(lblUserEmail, gbc_lblUserEmail);
	}

	private void layoutComp() {

		btnViewPosts = new JButton("View Posts");
		btnViewPosts.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnDeleteUser = new JButton("Delete");
		btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblFirstLabel = new JLabel("First Name");
		lblFirstLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblUserFirstName = new JLabel(userFirstName);
		lblUserFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblUserLastName = new JLabel(userLastName);
		lblUserLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblUserEmail = new JLabel(userEmail);
		lblUserEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	private void activateComp() {

		btnDeleteUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null,
						"Do you really want to delete user " + userFirstName + " and all of his posts?",
						"Delete Dialog", JOptionPane.YES_NO_OPTION);
				// 0=yes, 1=no
				System.out.println(input);
				if (input == 0) {
					panelCenter.remove(dataController.deleteUserFromDb(_id));
				}
				panelCenter.updateUI();
				panelCenter.revalidate();
			}
		});
		btnViewPosts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Post> userPostList = dataController.getUserPostList(_id);
				System.out.println(userPostList.size());
				if (userPostList.size() == 0) {
					JOptionPane.showMessageDialog(null, "This user has no posts", "Info Message",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					panelCenter.removeAll();

					for (int i = 0; i < userPostList.size(); i++) {

						PostPresenter postPresenter = new PostPresenter(userPostList.get(i).get_id(),
								userPostList.get(i).getUser(), userPostList.get(i).getTitle(),
								userPostList.get(i).getDescr(), userPostList.get(i).getQualifications(),
								userPostList.get(i).getPayment(), userPostList.get(i).getStartDate().toString(),
								userPostList.get(i).getEndDate().toString(), userPostList.get(i).getAdditionalInfo(),
								userPostList.get(i).getWhatIsOffered(), userPostList.get(i).getContactEmail());

						panelCenter.add(postPresenter);
					}
					panelCenter.updateUI();
					panelCenter.revalidate();
					scrollPane.getViewport().setViewPosition(new Point(0, 0));
				}
			}
		});
	}

}
