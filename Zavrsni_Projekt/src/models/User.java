package models;

import java.util.Date;

/**
 * General User class
 * */

public class User {

	private String _id ;
	private String fisrtName;
	private String lastName;
	private String email;
	private String password;
	private Date dateRegistered;

	public User(String _id, String firstName, String lastName, String email, String password,Date dateRegistered) {
		super();
		this._id = _id;
		this.fisrtName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateRegistered = dateRegistered;
	}

	public String get_id() {
		return _id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
