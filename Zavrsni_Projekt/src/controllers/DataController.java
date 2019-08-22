package controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.BsonString;

import models.Post;
import models.User;

public class DataController implements observable {

	private static List<User> userList = new ArrayList<User>();
	private static List<Post> postList = new ArrayList<Post>();
	private List<Post> userPostList = new ArrayList<Post>();
	private Map<String, String> usrFields;
	private DbsController dbsController;
	private static ArrayList<observer> observers = new ArrayList<>();

	public DataController() {
		usrFields = new LinkedHashMap<String, String>();
	}

	public void addUserToList(User user) {
		DataController.userList.add(user);
		notifyObs();

	}

	public void addPostToList(Post post) {
		DataController.postList.add(post);
	}

	public void updatePostChange(String postId, BsonDocument bsonDocument) throws ParseException {

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

	public void updateUserChange(String _id, BsonDocument bsonDocument) throws ClassNotFoundException {
		dbsController = new DbsController();
		String id = _id;
		BsonDocument upVal = bsonDocument;
		// System.out.println(id);
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

		System.out.println(newUser.toString());

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
