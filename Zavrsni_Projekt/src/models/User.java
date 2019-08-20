package models;

public class User {

	private String _id;
	private String fisrtName;
	private String lastName;
	private String email;
	private String password;

	public User(String _id, String firstName, String lastName, String email, String password) {
		super();
		this._id = _id;
		this.fisrtName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [_id=" + _id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	

}
