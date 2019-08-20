package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class PostPresenter extends JPanel {
	private JLabel lbl_id;
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
	private JTextField textField_Id;
	private JTextField textFieldUser;
	private JTextField textFieldTitle;
	private JTextField textFieldPayment;
	private JTextField textFieldStartDate;
	private JTextField textFieldEndDate;
	private JTextField textFieldContactEmail;
	private JTextArea textAreaDescription;
	private JTextArea textAreaAdditionalInfo;
	private JTextArea textAreaWhatIsOffered;
	private JTextArea textAreaQualifications;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private String post_id;
	private String postUserId;
	private String postTitle;
	private String postDescr;
	private String postqualific;
	private String postPayment;
	private String postStartDate;
	private String postEndDate;
	private String postAdditionalInfo;
	private String postWhatIsOffered;
	private String postContactEmail;

	public PostPresenter(String post_id, String postUserId, String postTitle, String postDescr, String postqualific,
			String postPayment, String postStartDate, String postEndDate, String postAdditionalInfo,
			String postWhatIsOffered, String postContactEmail) {

		this.post_id = post_id;
		this.postUserId = postUserId;
		this.postTitle = postTitle;
		this.postDescr = postDescr;
		this.postqualific = postqualific;
		this.postPayment = postPayment;
		this.postStartDate = postStartDate;
		this.postEndDate = postEndDate;
		this.postAdditionalInfo = postAdditionalInfo;
		this.postWhatIsOffered = postWhatIsOffered;
		this.postContactEmail = postContactEmail;
		layoutComp();

		this.textField_Id.setText(this.post_id);
		this.textFieldUser.setText(this.postUserId);
		this.textFieldTitle.setText(this.postTitle);
		this.textAreaDescription.setText(this.postDescr);
		this.textAreaQualifications.setText(this.postqualific);
		this.textFieldPayment.setText(this.postPayment);
		this.textFieldStartDate.setText(this.postStartDate);
		this.textFieldEndDate.setText(this.postEndDate);
		this.textAreaAdditionalInfo.setText(this.postAdditionalInfo);
		this.textAreaWhatIsOffered.setText(this.postWhatIsOffered);
		this.textFieldContactEmail.setText(this.postContactEmail);
	}

	

	private void layoutComp() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 152, 356, 0 };
		gridBagLayout.rowHeights = new int[] { 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 68, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lbl_id = new JLabel("_Id");
		lbl_id.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_id.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_id = new GridBagConstraints();
		gbc_lbl_id.fill = GridBagConstraints.BOTH;
		gbc_lbl_id.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_id.gridx = 1;
		gbc_lbl_id.gridy = 0;
		add(lbl_id, gbc_lbl_id);

		textField_Id = new JTextField();
		textField_Id.setEditable(false);
		textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_Id = new GridBagConstraints();
		gbc_textField_Id.anchor = GridBagConstraints.WEST;
		gbc_textField_Id.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Id.gridx = 2;
		gbc_textField_Id.gridy = 0;
		add(textField_Id, gbc_textField_Id);
		textField_Id.setColumns(35);

		lblUserId = new JLabel("User");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblUserId = new GridBagConstraints();
		gbc_lblUserId.anchor = GridBagConstraints.WEST;
		gbc_lblUserId.fill = GridBagConstraints.VERTICAL;
		gbc_lblUserId.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserId.gridx = 1;
		gbc_lblUserId.gridy = 1;
		add(lblUserId, gbc_lblUserId);

		textFieldUser = new JTextField();
		textFieldUser.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldUser.setEditable(false);
		textFieldUser.setColumns(35);
		GridBagConstraints gbc_textFieldUser = new GridBagConstraints();
		gbc_textFieldUser.anchor = GridBagConstraints.WEST;
		gbc_textFieldUser.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUser.gridx = 2;
		gbc_textFieldUser.gridy = 1;
		add(textFieldUser, gbc_textFieldUser);

		lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.WEST;
		gbc_lblTitle.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 2;
		add(lblTitle, gbc_lblTitle);

		textFieldTitle = new JTextField();
		textFieldTitle.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldTitle.setEditable(false);
		textFieldTitle.setColumns(35);
		GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
		gbc_textFieldTitle.anchor = GridBagConstraints.WEST;
		gbc_textFieldTitle.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTitle.gridx = 2;
		gbc_textFieldTitle.gridy = 2;
		add(textFieldTitle, gbc_textFieldTitle);

		lblDescr = new JLabel("Description");
		lblDescr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescr.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDescr = new GridBagConstraints();
		gbc_lblDescr.fill = GridBagConstraints.BOTH;
		gbc_lblDescr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescr.gridx = 1;
		gbc_lblDescr.gridy = 3;
		add(lblDescr, gbc_lblDescr);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.WEST;
		gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);

		textAreaDescription = new JTextArea();
		scrollPane.setViewportView(textAreaDescription);
		textAreaDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaDescription.setRows(3);
		textAreaDescription.setColumns(35);
		textAreaDescription.setEditable(false);

		lblqualific = new JLabel("Qualifications");
		lblqualific.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblqualific.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblqualific = new GridBagConstraints();
		gbc_lblqualific.anchor = GridBagConstraints.WEST;
		gbc_lblqualific.fill = GridBagConstraints.VERTICAL;
		gbc_lblqualific.insets = new Insets(0, 0, 5, 5);
		gbc_lblqualific.gridx = 1;
		gbc_lblqualific.gridy = 4;
		add(lblqualific, gbc_lblqualific);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.anchor = GridBagConstraints.WEST;
		gbc_scrollPane_1.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);

		textAreaQualifications = new JTextArea();
		scrollPane_1.setViewportView(textAreaQualifications);
		textAreaQualifications.setRows(3);
		textAreaQualifications.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaQualifications.setEditable(false);
		textAreaQualifications.setColumns(35);

		lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPayment = new GridBagConstraints();
		gbc_lblPayment.anchor = GridBagConstraints.WEST;
		gbc_lblPayment.fill = GridBagConstraints.VERTICAL;
		gbc_lblPayment.insets = new Insets(0, 0, 5, 5);
		gbc_lblPayment.gridx = 1;
		gbc_lblPayment.gridy = 5;
		add(lblPayment, gbc_lblPayment);

		textFieldPayment = new JTextField();
		textFieldPayment.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPayment.setEditable(false);
		textFieldPayment.setColumns(35);
		GridBagConstraints gbc_textFieldPayment = new GridBagConstraints();
		gbc_textFieldPayment.anchor = GridBagConstraints.WEST;
		gbc_textFieldPayment.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPayment.gridx = 2;
		gbc_textFieldPayment.gridy = 5;
		add(textFieldPayment, gbc_textFieldPayment);

		lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStartDate.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.WEST;
		gbc_lblStartDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 1;
		gbc_lblStartDate.gridy = 6;
		add(lblStartDate, gbc_lblStartDate);

		textFieldStartDate = new JTextField();
		textFieldStartDate.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldStartDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldStartDate.setEditable(false);
		textFieldStartDate.setColumns(35);
		GridBagConstraints gbc_textFieldStartDate = new GridBagConstraints();
		gbc_textFieldStartDate.anchor = GridBagConstraints.WEST;
		gbc_textFieldStartDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldStartDate.gridx = 2;
		gbc_textFieldStartDate.gridy = 6;
		add(textFieldStartDate, gbc_textFieldStartDate);

		lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndDate.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.anchor = GridBagConstraints.WEST;
		gbc_lblEndDate.fill = GridBagConstraints.VERTICAL;
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate.gridx = 1;
		gbc_lblEndDate.gridy = 7;
		add(lblEndDate, gbc_lblEndDate);

		textFieldEndDate = new JTextField();
		textFieldEndDate.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEndDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldEndDate.setEditable(false);
		textFieldEndDate.setColumns(35);
		GridBagConstraints gbc_textFieldEndDate = new GridBagConstraints();
		gbc_textFieldEndDate.anchor = GridBagConstraints.WEST;
		gbc_textFieldEndDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEndDate.gridx = 2;
		gbc_textFieldEndDate.gridy = 7;
		add(textFieldEndDate, gbc_textFieldEndDate);

		lblAdditionalInfo = new JLabel("Additional Info");
		lblAdditionalInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdditionalInfo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAdditionalInfo = new GridBagConstraints();
		gbc_lblAdditionalInfo.fill = GridBagConstraints.BOTH;
		gbc_lblAdditionalInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdditionalInfo.gridx = 1;
		gbc_lblAdditionalInfo.gridy = 8;
		add(lblAdditionalInfo, gbc_lblAdditionalInfo);

		scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.anchor = GridBagConstraints.WEST;
		gbc_scrollPane_2.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 8;
		add(scrollPane_2, gbc_scrollPane_2);

		textAreaAdditionalInfo = new JTextArea();
		scrollPane_2.setViewportView(textAreaAdditionalInfo);
		textAreaAdditionalInfo.setRows(3);
		textAreaAdditionalInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaAdditionalInfo.setEditable(false);
		textAreaAdditionalInfo.setColumns(35);

		lblWhatIsOffered = new JLabel("What Is Offered");
		lblWhatIsOffered.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWhatIsOffered.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblWhatIsOffered = new GridBagConstraints();
		gbc_lblWhatIsOffered.fill = GridBagConstraints.BOTH;
		gbc_lblWhatIsOffered.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatIsOffered.gridx = 1;
		gbc_lblWhatIsOffered.gridy = 9;
		add(lblWhatIsOffered, gbc_lblWhatIsOffered);

		scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.anchor = GridBagConstraints.WEST;
		gbc_scrollPane_3.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.gridx = 2;
		gbc_scrollPane_3.gridy = 9;
		add(scrollPane_3, gbc_scrollPane_3);

		textAreaWhatIsOffered = new JTextArea();
		scrollPane_3.setViewportView(textAreaWhatIsOffered);
		textAreaWhatIsOffered.setRows(3);
		textAreaWhatIsOffered.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaWhatIsOffered.setEditable(false);
		textAreaWhatIsOffered.setColumns(35);

		lblContactEmail = new JLabel("Contact Email");
		lblContactEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContactEmail.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblContactEmail = new GridBagConstraints();
		gbc_lblContactEmail.anchor = GridBagConstraints.WEST;
		gbc_lblContactEmail.fill = GridBagConstraints.VERTICAL;
		gbc_lblContactEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblContactEmail.gridx = 1;
		gbc_lblContactEmail.gridy = 10;
		add(lblContactEmail, gbc_lblContactEmail);

		textFieldContactEmail = new JTextField();
		textFieldContactEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldContactEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldContactEmail.setEditable(false);
		textFieldContactEmail.setColumns(35);
		GridBagConstraints gbc_textFieldContactEmail = new GridBagConstraints();
		gbc_textFieldContactEmail.anchor = GridBagConstraints.WEST;
		gbc_textFieldContactEmail.gridx = 2;
		gbc_textFieldContactEmail.gridy = 10;
		add(textFieldContactEmail, gbc_textFieldContactEmail);
	}

}
