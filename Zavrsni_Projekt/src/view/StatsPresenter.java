package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.DataController;
import models.User;

import javax.swing.JScrollPane;

public class StatsPresenter extends JPanel {
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
		scrollPane.setBounds(85, 89, 652, 210);
		add(scrollPane);

		tableUserStats = new JTable();
		tableUserStats.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableUserStats.setEnabled(false);
		scrollPane.setViewportView(tableUserStats);
		dataController = new DataController();

		DefaultTableModel model = new DefaultTableModel(null,
				new String[] { "User Name", "Date Registered", "Last Login", "Total Posts" });

		model.addRow(new String[] { dataController.getUserList().get(0).getFisrtName(),
				dataController.getUserList().get(0).getFisrtName(),
				dataController.getUserList().get(0).getFisrtName(),
				dataController.getUserList().get(0).getFisrtName()});
		tableUserStats.setModel(model);

	}
}
