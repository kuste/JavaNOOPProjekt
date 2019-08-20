package controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.BsonString;

import models.Post;
import models.User;

public class DataController implements PropertyChangeListener {

	private static List<User> userList = new ArrayList<User>();
	private static List<Post> postList = new ArrayList<Post>();
	private List<Post> userPostList = new ArrayList<Post>();
	private Map<String, String> usrFields;

	public DataController() {
		usrFields = new LinkedHashMap<String, String>();
		

	}

	public void addUserToList(User user) {
		DataController.userList.add(user);

	}

	public void addPostToList(Post post) {
		DataController.postList.add(post);
	}

	public List<User> getUserList() {
		return userList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public List<Post> getUserPostList(String user_Id) {
		for (Post post : postList) {
			if (post.getUser().matches(user_Id)) {
				this.userPostList.add(post);
			}
		}
		return userPostList;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);

	}

	public void updateUserChange(String _id, BsonDocument bsonDocument) throws ClassNotFoundException {
		String id = _id;
		BsonDocument upVal = bsonDocument;
		System.out.println(id);
		// int index = userList.indexOf(id);
		User usr = null;
		int index = 0;
		for (User user : userList) {
			if (user.get_id().matches(id)) {
				usr = user;
				index = userList.indexOf(user);
			}

		}

		// System.out.println(usr.toString());

		usrFields.put("firstName", usr.getFisrtName());
		usrFields.put("lastName", usr.getLastName());
		usrFields.put("email", usr.getEmail());
		usrFields.put("password", usr.getPassword());

		upVal.forEach((k, v) -> {

			// System.out.println(usrFields.get(k));
			if (usrFields.get(k) != ((BsonString) v).getValue()) {
				usrFields.put(k, ((BsonString) v).getValue());
			}
			// System.out.println(usrFields.get(k));
		});

		User newUser = new User(usr.get_id(), usrFields.get("firstName"), usrFields.get("lastName"),
				usrFields.get("email"), usrFields.get("password"));

		// System.out.println(newUser.toString());

		userList.set(index, newUser);

	}

}
