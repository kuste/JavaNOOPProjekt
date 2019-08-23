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
/**
 * Class for visual representation of User Stats from database 
 * {@link User Posts}
 */
public class StatsPresenter extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable tableUserStats;
	private JLabel lblTableTitle;
	private JScrollPane scrollPane;
	private DataController dataController;

	public StatsPresenter() {
		setLayout(null);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		lblTableTitle = new JLabel("User Stats");
		lblTableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTableTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTableTitle.setBounds(52, 47, 125, 20);
		add(lblTableTitle);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 90, 600, 400);
		add(scrollPane);

		tableUserStats = new JTable();
		tableUserStats.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableUserStats.setEnabled(false);
		scrollPane.setViewportView(tableUserStats);
		dataController = new DataController();

		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "User Email", "Date Registered", "Total Posts" });

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		List<Post> userPostList = dataController.getPostList();
		for (int i = 0; i < dataController.getUserList().size(); i++) {
			int posts = searchList(dataController.getUserList().get(i).get_id(), userPostList);
			model.addRow(new String[] { dataController.getUserList().get(i).getEmail(),
					dataController.getUserList().get(i).getDateRegistered().toString(), String.valueOf(posts)

			});

		}
		tableUserStats.setModel(model);
		for (int i = 0; i < tableUserStats.getColumnCount(); i++) {

			tableUserStats.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		// tableUserStats.scrollPane.setPreferredSize(tableUserStats.getPreferredSize());
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
