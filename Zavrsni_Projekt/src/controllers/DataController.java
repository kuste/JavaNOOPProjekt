package controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.BsonDocument;

import models.Post;
import models.User;

/**
 * Local management of data
 * 
 */

public class DataController implements observable {

	private static List<User> userList = new ArrayList<User>();
	private static List<Post> postList = new ArrayList<Post>();
	private List<Post> userPostList = new ArrayList<Post>();
	private DbsController dbsController;
	private static ArrayList<observer> observers = new ArrayList<>();

	public DataController() {
	}

	/**
	 * Adds Users to list and notifies observers to update
	 * 
	 * @param user {@link User}
	 */

	public void addUserToList(User user) {
		DataController.userList.add(user);
		notifyObs();

	}

	/**
	 * Adds Posts to list and notifies observers to update
	 * 
	 * @param post {@link Post}
	 */
	public void addPostToList(Post post) {
		DataController.postList.add(post);
	}

	/**
	 * Updates the fields of Post when update from database occurs
	 * 
	 * @param postId       - String
	 * @param bsonDocument - BsonDocument 
	 * {@link BsonDocument Post}
	 */
	public void updatePostChange(String postId, BsonDocument bsonDocument) {

		dbsController = new DbsController();
		String id = postId;
		BsonDocument upVal = bsonDocument;
		System.out.println(upVal);
		// System.out.println(id);
		// int index = userList.indexOf(id);
		Post pst = null;
		int index = 0;
		for (Post post : postList) {
			if (post.get_id().matches(id)) {
				pst = post;
				index = postList.indexOf(post);
			}
		}
		String title = pst.getTitle();
		String descr = pst.getDescr();
		String qualifications = pst.getQualifications();
		String payment = pst.getPayment();
		Date startDate = pst.getStartDate();
		Date endDate = pst.getEndDate();
		String additionalInfo = pst.getAdditionalInfo();
		String whatIsOffered = pst.getWhatIsOffered();
		String contactEmail = pst.getContactEmail();

		for (String key : upVal.keySet()) {
			switch (key) {
			case "title":
				title = upVal.getString("title").getValue();
				break;
			case "descr":
				descr = upVal.getString("descr").getValue();
				break;
			case "qualifications":
				qualifications = upVal.getString("qualifications").getValue();
				break;
			case "payment":
				payment = upVal.getString("payment").getValue();
				break;
			case "additionalInfo":
				additionalInfo = upVal.getString("additionalInfo").getValue();
				break;
			case "whatIsOffered":
				whatIsOffered = upVal.getString("whatIsOffered").getValue();
				break;
			case "contactEmail":
				contactEmail = upVal.getString("contactEmail").getValue();
				break;
			case "startDate":
				startDate = new Date(upVal.getDateTime("startDate").getValue());
				break;
			case "endDate":
				endDate = new Date(upVal.getDateTime("endDate").getValue());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		}

		Post newPost = new Post(pst.get_id(), pst.getUser(), title, descr, qualifications, payment, startDate, endDate,
				additionalInfo, whatIsOffered, contactEmail);

		// System.out.println(newPost.toString());

		postList.set(index, newPost);
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

	/**
	 * Updates the fields of User when update from database occurs
	 * 
	 * @param _id          - String
	 * @param bsonDocument - BsonDocument {@link BsonDocument User}
	 * @throws ClassNotFoundException - {@link ClassNotFoundException}i
	 */

	public void updateUserChange(String _id, BsonDocument bsonDocument) throws ClassNotFoundException {
		dbsController = new DbsController();
		String id = _id;
		BsonDocument upVal = bsonDocument;
		User usr = null;
		int index = 0;
		for (User user : userList) {
			if (user.get_id().matches(id)) {
				usr = user;
				index = userList.indexOf(user);
			}
		}
		// System.out.println(usr.toString());

		String firstName = usr.getFisrtName();
		String lastName = usr.getLastName();
		String email = usr.getEmail();
		String password = usr.getPassword();
		Date dateRegistered = usr.getDateRegistered();

		for (String key : upVal.keySet()) {
			switch (key) {
			case "firstName":
				firstName = upVal.getString("firstName").getValue();
				break;
			case "lastName":
				lastName = upVal.getString("lastName").getValue();
				break;
			case "email":
				email = upVal.getString("email").getValue();
				break;
			case "password":
				password = upVal.getString("password").getValue();
				break;
			case "dateRegistered":
				dateRegistered = new Date(upVal.getDateTime("dateRegistered").getValue());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		}

		User newUser = new User(usr.get_id(), firstName, lastName, email, password, dateRegistered);

		userList.set(index, newUser);
		notifyObs();

	}

	public int deleteUserFromDb(String userId) {
		dbsController = new DbsController();
		User usr = null;
		int index = 0;
		for (User user : userList) {
			if (user.get_id().matches(userId)) {
				usr = user;
				index = userList.indexOf(user);
			}

		}
		userList.remove(index);
		dbsController.deleteUser(usr.get_id());
		deleteAllUserPosts(userId);
		return index;
	}

	private void deleteAllUserPosts(String userId) {

		List<Post> newUserPostList = getUserPostList(userId);
		newUserPostList.removeAll(newUserPostList);
		userPostList = newUserPostList;
		for (Post post : postList) {
			if (post.getUser().matches(userId)) {
				this.userPostList.remove(post);
			}
		}
		dbsController.deleteAllUserPosts(userId);

	}

	public void deletePost(String postId) {
		System.out.println(postId);
		for (int i = 0; i < postList.size(); i++) {
			Post post = postList.get(i);
			if (post.get_id().matches(postId)) {
				postList.remove(post);
			}
		}
	}

	@Override
	public void add(observer o) {
		observers.add(o);
	}

	@Override
	public void remove(observer o) {
		int index = observers.indexOf(o);
		observers.remove(index);

	}

	@Override
	public void notifyObs() {
		for (observer o : observers) {
			o.update(userList);
		}
	}
}
