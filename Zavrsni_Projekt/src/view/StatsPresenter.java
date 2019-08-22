package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controllers.DataController;

import javax.swing.JScrollPane;

public class StatsPresenter extends JPanel {
	/**
	 * 
	 */
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
				new String[] { "User Name", "Date Registered", "Last Login", "Total Posts" });

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < dataController.getUserList().size(); i++) {

			model.addRow(new String[] { dataController.getUserList().get(i).getFisrtName(),
					dataController.getUserList().get(i).getFisrtName(),
					dataController.getUserList().get(i).getFisrtName(),
					dataController.getUserList().get(i).getFisrtName() });

		}
		tableUserStats.setModel(model);
		for (int i = 0; i < tableUserStats.getColumnCount(); i++) {

			tableUserStats.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		// tableUserStats.scrollPane.setPreferredSize(tableUserStats.getPreferredSize());
	}

}
