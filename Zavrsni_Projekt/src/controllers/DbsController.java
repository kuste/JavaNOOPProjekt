package controllers;

import java.util.Date;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;

import models.Post;
import models.User;

public class DbsController extends Thread {

	private String posts;
	private String users;
	private String URI;
	private DataController dataController;
	private MongoClient mongoClient;
	private MongoDatabase database;

	public DbsController() {
		this.URI = "mongodb+srv://kuste:pass123456@node-rest-api-7y9da.mongodb.net/test?retryWrites=true&w=majority";
		this.dataController = new DataController();
		System.out.println("Getting data....");

	}

	public void getAllDataFromDb() {
		getPostsFromDb();
		getUsersFromDb();
	}

	private void getPostsFromDb() {
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

	private void getUsersFromDb() {
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
				User user = new User(_id, firstName, lastName, email, password);

				this.dataController.addUserToList(user);

				// System.out.println(user.toString());
			}
			MongoCursor<ChangeStreamDocument<Document>> res = collection.watch().iterator();

			while (res.hasNext()) {
				// System.out.println(res.next());
				ChangeStreamDocument<Document> doc = res.next();

				if (doc.getUpdateDescription().getUpdatedFields() != null) {
					dataController.updateUserChange(doc.getDocumentKey().getObjectId("_id").getValue().toString(),
							doc.getUpdateDescription().getUpdatedFields());

				} else {

					System.out.println("Nothing to update");
				}

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("....cursor closed");
		}

		System.out.println("....done");

	}

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

	public String getPosts() {
		return posts;
	}

	public String getUsers() {
		return users;
	}

}
