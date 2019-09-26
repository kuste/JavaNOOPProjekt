package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.bson.types.ObjectId;

import controllers.DataController;
import models.User;

import javax.swing.JButton;
import java.awt.Font;

public class AddUserPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldFirstName;
	private JLabel lblFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JTextField textFieldRepeatPass;
	private JButton btnSubmit;
	private JLabel lblRepeatPassword;
	private JLabel lblPassword;
	private JLabel lblEMail;
	private JLabel lblLastName;
	private DataController dataController;

	public AddUserPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addConstraints();
		activateComp();
	}

	private void activateComp() {
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dataController = new DataController();
				
				// napravti klasu za validaciju polja
				if (textFieldPassword.getText().matches(textFieldRepeatPass.getText())) {

					User user = new User(new ObjectId().toString(), 
							textFieldFirstName.getText(),
							textFieldLastName.getText(), 
							textFieldEmail.getText(),
							textFieldPassword.getText(),
							new Date(System.currentTimeMillis()));
					dataController.addNewUser(user);
				}

			}
		});

	}

	private void addConstraints() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 70, 326, 70, 0 };
		gridBagLayout.rowHeights = new int[] { 60, 35, 50, 35, 50, 0, 50, 0, 50, 0, 0, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.SOUTH;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 0;
		add(lblFirstName, gbc_lblFirstName);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.ipady = 5;
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUserName.gridx = 1;
		gbc_textFieldUserName.gridy = 1;
		add(textFieldFirstName, gbc_textFieldUserName);
		textFieldFirstName.setColumns(25);

		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.SOUTH;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 2;
		add(lblLastName, gbc_lblLastName);

		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldLastName.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLastName.setColumns(25);
		GridBagConstraints gbc_textFieldLastName = new GridBagConstraints();
		gbc_textFieldLastName.ipady = 5;
		gbc_textFieldLastName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLastName.gridx = 1;
		gbc_textFieldLastName.gridy = 3;
		add(textFieldLastName, gbc_textFieldLastName);

		lblEMail = new JLabel("E - Mail");
		lblEMail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblEMail = new GridBagConstraints();
		gbc_lblEMail.anchor = GridBagConstraints.SOUTH;
		gbc_lblEMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEMail.gridx = 1;
		gbc_lblEMail.gridy = 4;
		add(lblEMail, gbc_lblEMail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setColumns(25);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.ipady = 5;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 5;
		add(textFieldEmail, gbc_textFieldEmail);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.SOUTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 6;
		add(lblPassword, gbc_lblPassword);

		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setColumns(25);
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.ipady = 5;
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPassword.gridx = 1;
		gbc_textFieldPassword.gridy = 7;
		add(textFieldPassword, gbc_textFieldPassword);

		lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblRepeatPassword = new GridBagConstraints();
		gbc_lblRepeatPassword.anchor = GridBagConstraints.SOUTH;
		gbc_lblRepeatPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepeatPassword.gridx = 1;
		gbc_lblRepeatPassword.gridy = 8;
		add(lblRepeatPassword, gbc_lblRepeatPassword);

		textFieldRepeatPass = new JTextField();
		textFieldRepeatPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldRepeatPass.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldRepeatPass.setColumns(25);
		GridBagConstraints gbc_textFieldRepeatPass = new GridBagConstraints();
		gbc_textFieldRepeatPass.ipady = 5;
		gbc_textFieldRepeatPass.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRepeatPass.gridx = 1;
		gbc_textFieldRepeatPass.gridy = 9;
		add(textFieldRepeatPass, gbc_textFieldRepeatPass);

		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.ipadx = 20;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 11;
		add(btnSubmit, gbc_btnSubmit);

	}
}
