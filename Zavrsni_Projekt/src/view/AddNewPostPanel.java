package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.bson.types.ObjectId;

import models.Post;
import models.User;

import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import controllers.DataController;

import javax.swing.border.TitledBorder;
/**
 * Class for adding new posts {@link User
 * Posts}
 */
public class AddNewPostPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblUserId;
	private JLabel lblTitle;
	private JLabel lblDescr;
	private JLabel lblqualific;
	private JLabel lblPayment;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JLabel lblAdditionalInfo;
	private JLabel lblWhatIsOffered;
	private JLabel lblContactEmail;
	private JTextField textFieldUser;
	private JTextField textFieldTitle;
	private JTextField textFieldPayment;
	private JTextField textFieldContactEmail;
	private JTextArea textAreaDescription;
	private JTextArea textAreaAdditionalInfo;
	private JTextArea textAreaWhatIsOffered;
	private JTextArea textAreaQualifications;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JButton btnSubmit;
	private JCalendar calendarStartDate;
	private JCalendar calendaerEndDate;
	private JPanel panel;
	private JPanel panel_1;
	private DataController dataController;

	public AddNewPostPanel(String _id) {
		layoutComp();
		activateComp();
		this.dataController = new DataController();
		this.textFieldUser.setText(_id);
	}

	private void activateComp() {
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Post post = new Post(new ObjectId().toString(),
						new ObjectId(textFieldUser.getText().toString()).toString(), textFieldTitle.getText().strip(),
						textAreaDescription.getText().strip(), textAreaQualifications.getText().strip(),
						textFieldPayment.getText().strip(), calendarStartDate.getDate(), calendaerEndDate.getDate(),
						textAreaAdditionalInfo.getText().strip(), textAreaWhatIsOffered.getText().strip(),
						textFieldContactEmail.getText().strip());
				dataController.addNewPost(post);

			}
		});
	}

	private void layoutComp() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 60, 152, 356, 75, 0 };
		gridBagLayout.rowHeights = new int[] { 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 70, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblUserId = new JLabel("User");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblUserId = new GridBagConstraints();
		gbc_lblUserId.anchor = GridBagConstraints.WEST;
		gbc_lblUserId.fill = GridBagConstraints.VERTICAL;
		gbc_lblUserId.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserId.gridx = 1;
		gbc_lblUserId.gridy = 0;
		add(lblUserId, gbc_lblUserId);

		textFieldUser = new JTextField();
		textFieldUser.setEditable(false);
		textFieldUser.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldUser.setColumns(35);
		GridBagConstraints gbc_textFieldUser = new GridBagConstraints();
		gbc_textFieldUser.anchor = GridBagConstraints.WEST;
		gbc_textFieldUser.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUser.gridx = 2;
		gbc_textFieldUser.gridy = 0;
		add(textFieldUser, gbc_textFieldUser);

		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		add(lblTitle, gbc_lblTitle);

		textFieldTitle = new JTextField();
		textFieldTitle.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTitle.setColumns(35);
		GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
		gbc_textFieldTitle.anchor = GridBagConstraints.WEST;
		gbc_textFieldTitle.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTitle.gridx = 2;
		gbc_textFieldTitle.gridy = 1;
		add(textFieldTitle, gbc_textFieldTitle);

		lblDescr = new JLabel("Description");
		lblDescr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescr.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDescr = new GridBagConstraints();
		gbc_lblDescr.fill = GridBagConstraints.BOTH;
		gbc_lblDescr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescr.gridx = 1;
		gbc_lblDescr.gridy = 2;
		add(lblDescr, gbc_lblDescr);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.WEST;
		gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		textAreaDescription = new JTextArea();
		scrollPane.setViewportView(textAreaDescription);
		textAreaDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaDescription.setRows(3);
		textAreaDescription.setColumns(35);

		lblqualific = new JLabel("Qualifications");
		lblqualific.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblqualific.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblqualific = new GridBagConstraints();
		gbc_lblqualific.anchor = GridBagConstraints.WEST;
		gbc_lblqualific.fill = GridBagConstraints.VERTICAL;
		gbc_lblqualific.insets = new Insets(0, 0, 5, 5);
		gbc_lblqualific.gridx = 1;
		gbc_lblqualific.gridy = 3;
		add(lblqualific, gbc_lblqualific);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.anchor = GridBagConstraints.WEST;
		gbc_scrollPane_1.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 3;
		add(scrollPane_1, gbc_scrollPane_1);

		textAreaQualifications = new JTextArea();
		scrollPane_1.setViewportView(textAreaQualifications);
		textAreaQualifications.setRows(3);
		textAreaQualifications.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaQualifications.setColumns(35);

		lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPayment = new GridBagConstraints();
		gbc_lblPayment.anchor = GridBagConstraints.WEST;
		gbc_lblPayment.fill = GridBagConstraints.VERTICAL;
		gbc_lblPayment.insets = new Insets(0, 0, 5, 5);
		gbc_lblPayment.gridx = 1;
		gbc_lblPayment.gridy = 4;
		add(lblPayment, gbc_lblPayment);

		textFieldPayment = new JTextField();
		textFieldPayment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPayment.setColumns(35);
		GridBagConstraints gbc_textFieldPayment = new GridBagConstraints();
		gbc_textFieldPayment.anchor = GridBagConstraints.WEST;
		gbc_textFieldPayment.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPayment.gridx = 2;
		gbc_textFieldPayment.gridy = 4;
		add(textFieldPayment, gbc_textFieldPayment);

		lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStartDate.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 1;
		gbc_lblStartDate.gridy = 5;
		add(lblStartDate, gbc_lblStartDate);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 356, 0 };
		gbl_panel.rowHeights = new int[] { 68, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		calendarStartDate = new JCalendar();
		GridBagConstraints gbc_calendarStartDate = new GridBagConstraints();
		gbc_calendarStartDate.fill = GridBagConstraints.BOTH;
		gbc_calendarStartDate.gridx = 0;
		gbc_calendarStartDate.gridy = 0;
		panel.add(calendarStartDate, gbc_calendarStartDate);

		lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndDate.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate.gridx = 1;
		gbc_lblEndDate.gridy = 6;
		add(lblEndDate, gbc_lblEndDate);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 6;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 356, 0 };
		gbl_panel_1.rowHeights = new int[] { 68, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		calendaerEndDate = new JCalendar();
		GridBagConstraints gbc_calendaerEndDate = new GridBagConstraints();
		gbc_calendaerEndDate.fill = GridBagConstraints.BOTH;
		gbc_calendaerEndDate.gridx = 0;
		gbc_calendaerEndDate.gridy = 0;
		panel_1.add(calendaerEndDate, gbc_calendaerEndDate);

		lblAdditionalInfo = new JLabel("Additional Info");
		lblAdditionalInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdditionalInfo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAdditionalInfo = new GridBagConstraints();
		gbc_lblAdditionalInfo.fill = GridBagConstraints.BOTH;
		gbc_lblAdditionalInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdditionalInfo.gridx = 1;
		gbc_lblAdditionalInfo.gridy = 7;
		add(lblAdditionalInfo, gbc_lblAdditionalInfo);

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.anchor = GridBagConstraints.WEST;
		gbc_scrollPane_2.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 7;
		add(scrollPane_2, gbc_scrollPane_2);

		textAreaAdditionalInfo = new JTextArea();
		scrollPane_2.setViewportView(textAreaAdditionalInfo);
		textAreaAdditionalInfo.setRows(3);
		textAreaAdditionalInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaAdditionalInfo.setColumns(35);

		lblWhatIsOffered = new JLabel("What Is Offered");
		lblWhatIsOffered.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWhatIsOffered.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblWhatIsOffered = new GridBagConstraints();
		gbc_lblWhatIsOffered.fill = GridBagConstraints.BOTH;
		gbc_lblWhatIsOffered.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatIsOffered.gridx = 1;
		gbc_lblWhatIsOffered.gridy = 8;
		add(lblWhatIsOffered, gbc_lblWhatIsOffered);

		scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.anchor = GridBagConstraints.WEST;
		gbc_scrollPane_3.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_3.gridx = 2;
		gbc_scrollPane_3.gridy = 8;
		add(scrollPane_3, gbc_scrollPane_3);

		textAreaWhatIsOffered = new JTextArea();
		scrollPane_3.setViewportView(textAreaWhatIsOffered);
		textAreaWhatIsOffered.setRows(3);
		textAreaWhatIsOffered.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaWhatIsOffered.setColumns(35);

		lblContactEmail = new JLabel("Contact Email");
		lblContactEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContactEmail.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblContactEmail = new GridBagConstraints();
		gbc_lblContactEmail.anchor = GridBagConstraints.WEST;
		gbc_lblContactEmail.fill = GridBagConstraints.VERTICAL;
		gbc_lblContactEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactEmail.gridx = 1;
		gbc_lblContactEmail.gridy = 9;
		add(lblContactEmail, gbc_lblContactEmail);

		textFieldContactEmail = new JTextField();
		textFieldContactEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldContactEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldContactEmail.setColumns(35);
		GridBagConstraints gbc_textFieldContactEmail = new GridBagConstraints();
		gbc_textFieldContactEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContactEmail.anchor = GridBagConstraints.WEST;
		gbc_textFieldContactEmail.gridx = 2;
		gbc_textFieldContactEmail.gridy = 9;
		add(textFieldContactEmail, gbc_textFieldContactEmail);

		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.ipadx = 10;
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 10;
		add(btnSubmit, gbc_btnSubmit);
	}
}
