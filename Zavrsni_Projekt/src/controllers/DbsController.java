package controllers;

import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;

import models.Post;
import models.User;

/**
 * Getting data from the Mongo database using mongo java driver
 * {@link MongoClient MongoDatabase}
 * 
 */

public class DbsController {

	private String posts;
	private String users;
	private String URI;
	private DataController dataController;
	private MongoClient mongoClient;
	private MongoDatabase database;

	public DbsController() {
		this.URI = "mongodb+srv://kuste:pass123456@node-rest-api-7y9da.mongodb.net/test?retryWrites=true&w=majority";
		this.dataController = new DataController();
	}

	public void getAllDataFromDb() {
		System.out.println("Getting data....");
		getPostsFromDb();
		getUsersFromDb();
		
	}

	/**
	 * Adds new user to database
	 * */
	public void addUserToDb(User user) {
		mongoClient = MongoClients.create(URI);
		database = mongoClient.getDatabase("test");
		System.out.println("Getting Posts...");
		MongoCollection<Document> collection = database.getCollection("users");
		Document doc = new Document()
				.append("firstName", user.getFisrtName())
				.append("lastName", user.getLastName())
				.append("email", user.getEmail())
				.append("password", user.getPassword())
				.append("dateRegistered", user.getDateRegistered());
				
		collection.insertOne(doc);
		
	}
	/**
	 * Connects to database and gets all posts
	 * 
	 */

	private void getPostsFromDb() {
		this.dataController = new DataController();
		mongoClient = MongoClients.create(URI);
		database = mongoClient.getDatabase("test");
		System.out.println("Getting Posts...");
		MongoCollection<Document> collection = database.getCollection("posts");
		MongoCursor<Document> cursor = collection.find().iterator();

		try {

			while (cursor.hasNext()) {

				Document doc = cursor.next();
				String _id = doc.getObjectId("_id").toString();
				String userId = doc.getObjectId("user").toString();
				String title = doc.getString("title");
				String descr = doc.getString("descr");
				String qualifications = doc.getString("qualifications");
				String payment = doc.getString("payment");
				Date startDate = doc.getDate("startDate");
				Date endDate = doc.getDate("endDate");
				String additionalInfo = doc.getString("additionalInfo");
				String whatIsOffered = doc.getString("whatIsOffered");
				String contactEmail = doc.getString("contactEmail");

				Post post = new Post(_id, userId, title, descr, qualifications, payment, startDate, endDate,
						additionalInfo, whatIsOffered, contactEmail);

				this.dataController.addPostToList(post);

				System.out.println(post.toString());
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("....cursor closed");
		}
		System.out.println("....done");

	}

	/**
	 * Connects to database and gets all users
	 * 
	 */
	private void getUsersFromDb() {
		this.dataController = new DataController();
		mongoClient = MongoClients.create(URI);
		database = mongoClient.getDatabase("test");
		System.out.println("Getting Posts...");
		MongoCollection<Document> collection = database.getCollection("users");
		MongoCursor<Document> cursor = collection.find().iterator();

		try {
			while (cursor.hasNext()) {

				Document doc = cursor.next();
				String _id = doc.getObjectId("_id").toString();
				String firstName = doc.getString("firstName");
				String lastName = doc.getString("lastName");
				String email = doc.getString("email");
				String password = doc.getString("password");
				Date dateRegistered = doc.getDate("dateRegistered");
				User user = new User(_id, firstName, lastName, email, password, dateRegistered);

				this.dataController.addUserToList(user);

				// System.out.println(user.toString());
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("....cursor closed");
		}

		System.out.println("....done");

	}

	/**
	 * Constantly listens for User updates in database
	 * 
	 */
	public void watchForUserUpdates() {
		this.dataController = new DataController();
		mongoClient = MongoClients.create(URI);
		database = mongoClient.getDatabase("test");
		MongoCollection<Document> userCollection = database.getCollection("users");
		MongoCursor<ChangeStreamDocument<Document>> userRes = userCollection.watch().iterator();
		try {
			while (userRes.hasNext()) {
				// System.out.println(res.next());
				ChangeStreamDocument<Document> userDoc = userRes.next();

				switch (userDoc.getOperationType().getValue()) {
				case "insert":
					System.out.println(userDoc.getOperationType().getValue());
					String _id = userDoc.getFullDocument().getObjectId("_id").toString();
					String firstName = userDoc.getFullDocument().getString("firstName");
					String lastName = userDoc.getFullDocument().getString("lastName");
					String email = userDoc.getFullDocument().getString("email");
					String password = userDoc.getFullDocument().getString("password");
					Date dateRegistered = userDoc.getFullDocument().getDate("dateRegistered");
					User user = new User(_id, firstName, lastName, email, password, dateRegistered);
					this.dataController.addUserToList(user);
					break;
				case "delete":
					System.out.println(userDoc.getOperationType().getValue());
					break;
				case "update":
					System.out.println(userDoc.getOperationType().getValue());
					dataController.updateUserChange(userDoc.getDocumentKey().getObjectId("_id").getValue().toString(),
							userDoc.getUpdateDescription().getUpdatedFields());
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + userDoc.getOperationType().getValue());
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("....cursor closed");
		}

	}

	/**
	 * Constantly listens for Post updates in data base
	 * 
	 */
	public void wathcForPostUpdates() {
		this.dataController = new DataController();
		mongoClient = MongoClients.create(URI);
		database = mongoClient.getDatabase("test");
		MongoCollection<Document> postCollection = database.getCollection("posts");
		MongoCursor<ChangeStreamDocument<Document>> postRes = postCollection.watch().iterator();
		try {

			while (postRes.hasNext()) {
				// System.out.println("postRes " + postRes.next());
				ChangeStreamDocument<Document> postDoc = postRes.next();
				switch (postDoc.getOperationType().getValue()) {
				case "insert":
					System.out.println(postDoc.getOperationType().getValue());
					String _id = postDoc.getFullDocument().getObjectId("_id").toString();
					String userId = postDoc.getFullDocument().getObjectId("user").toString();
					String title = postDoc.getFullDocument().getString("title");
					String descr = postDoc.getFullDocument().getString("descr");
					String qualifications = postDoc.getFullDocument().getString("qualifications");
					String payment = postDoc.getFullDocument().getString("payment");
					Date startDate = postDoc.getFullDocument().getDate("startDate");
					Date endDate = postDoc.getFullDocument().getDate("endDate");
					String additionalInfo = postDoc.getFullDocument().getString("additionalInfo");
					String whatIsOffered = postDoc.getFullDocument().getString("whatIsOffered");
					String contactEmail = postDoc.getFullDocument().getString("contactEmail");

					Post post = new Post(_id, userId, title, descr, qualifications, payment, startDate, endDate,
							additionalInfo, whatIsOffered, contactEmail);
					this.dataController.addPostToList(post);
					break;
				case "delete":
					System.out.println(postDoc.getOperationType().getValue());
					dataController.deletePost(postDoc.getDocumentKey().getObjectId("_id").getValue().toString());
					break;
				case "update":
					System.out.println(postDoc.getOperationType().getValue());
					dataController.updatePostChange(postDoc.getDocumentKey().getObjectId("_id").getValue().toString(),
							postDoc.getUpdateDescription().getUpdatedFields());
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + postDoc.getOperationType().getValue());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("....cursor closed");
		}
	}

	/**
	 * Gets all posts from given User in database
	 * 
	 * @param user_Id - String
	 * 
	 */
	public void getAllUserPostsFromDb(String user_Id) {

		// System.out.println("Getting data....");
		MongoClient mongoClient = MongoClients.create(URI);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("posts");
		MongoCursor<Document> cursor = collection.find().iterator();
		try {

			while (cursor.hasNext()) {

				Document doc = cursor.next();
				if (doc.getObjectId("_id").toString().matches(user_Id)) {

					String _id = doc.getObjectId("_id").toString();
					String userId = doc.getObjectId("user").toString();
					String title = doc.getString("title");
					String descr = doc.getString("descr");
					String qualifications = doc.getString("qualifications");
					String payment = doc.getString("payment");
					Date startDate = doc.getDate("startDate");
					Date endDate = doc.getDate("endDate");
					String additionalInfo = doc.getString("additionalInfo");
					String whatIsOffered = doc.getString("whatIsOffered");
					String contactEmail = doc.getString("contactEmail");

					Post post = new Post(_id, userId, title, descr, qualifications, payment, startDate, endDate,
							additionalInfo, whatIsOffered, contactEmail);

					System.out.println(post.toString());
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("....cursor closed");
		}

		System.out.println("....done");

	}

	/**
	 * Removes given user from database
	 * 
	 * @param userId - String 
	 */

	public void deleteUser(String userId) {
		MongoClient mongoClient = MongoClients.create(URI);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("users");
		collection.deleteOne(new Document("_id", new ObjectId(userId)));
	}

	/**
	 * Removes all posts from given User
	 * 
	 * @param  userId - String
	 */
	public void deleteAllUserPosts(String userId) {
		MongoClient mongoClient = MongoClients.create(URI);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("posts");
		MongoCursor<Document> cursor = collection.find().iterator();

		try {

			while (cursor.hasNext()) {
				Document doc = cursor.next();
				if (doc.getObjectId("user").toString().matches(userId)) {
					collection.deleteOne(doc);
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("....cursor closed");
		}

		System.out.println("....done");

	}

	public String getPosts() {
		return posts;
	}

	public String getUsers() {
		return users;
	}

}
