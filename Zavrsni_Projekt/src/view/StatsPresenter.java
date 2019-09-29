package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controllers.DataController;
import models.Post;
import models.User;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Class for visual representation of User Stats from database {@link User
 * Posts}
 */
public class StatsPresenter extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableUserStats;
	private JLabel lblTableTitle;
	private JScrollPane scrollPane;
	private DataController dataController;

	public StatsPresenter() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);   
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setConstraintsAndLayout(gridBagLayout);
		
	}

	private void setConstraintsAndLayout(GridBagLayout gridBagLayout) {
		gridBagLayout.columnWidths = new int[] { 50, 633, 50, 0 };
		gridBagLayout.rowHeights = new int[] { 47, 20, 400, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
	        

		lblTableTitle = new JLabel("User Stats");
		lblTableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTableTitle = new GridBagConstraints();
		gbc_lblTableTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTableTitle.fill = GridBagConstraints.VERTICAL;
		gbc_lblTableTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTableTitle.gridx = 1;
		add(lblTableTitle, gbc_lblTableTitle);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		tableUserStats = new JTable();
		tableUserStats.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableUserStats.setEnabled(false);
		scrollPane.setViewportView(tableUserStats);
		dataController = new DataController();

		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "User Email", "Date Registered", "Total Posts" });

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		tableUserStats.setModel(model);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		List<Post> userPostList = dataController.getPostList();
		for (int i = 0; i < dataController.getUserList().size(); i++) {
			int posts = searchList(dataController.getUserList().get(i).get_id(), userPostList);
			model.addRow(new String[] { dataController.getUserList().get(i).getEmail(),
					dataController.getUserList().get(i).getDateRegistered().toString(), String.valueOf(posts)

			});

		}
		for (int i = 0; i < tableUserStats.getColumnCount(); i++) {

			tableUserStats.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
	}

	private int searchList(String userId, List<Post> userPostList) {

		int count = 0;
		for (Post post : userPostList) {
			if (post.getUser().matches(userId)) {
				count++;
			}
		}

		return count;

	}
}
