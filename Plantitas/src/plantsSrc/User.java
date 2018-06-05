package plantsSrc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private String mail;
	protected static DB database = new DB();

	public User(String username, String password, String mail, DB database) {
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.database = new DB();
	}
	
	public String getUsername() {
		return username;
	}

	public int login(String username, String password) {
		// returns -1 if it doesnt exist, 0 if normal user, 1 if admin
		int admin = 0;
		try {
			ResultSet result = database.makeQuery(
					"SELECT * FROM user WHERE Username LIKE '" + username + "' AND Password LIKE '" + password + "'");
			while (result.next()) {
				admin = Integer.parseInt(result.getString("Admin"));
			}
		} catch (SQLException e) {
			return -1;
		}
		return admin;
	}

	public void logout() {

	}

	public static void writePost(Post post) {
		try {
			database.addPost(post.ID, post.head, post.body, post.username, post.plant);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addComment(Comment comment) {
		try {
			database.addComment(comment.comment_ID, comment.comment, comment.user, comment.post_ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Post> searchPlant(String plant) {
		List<Post> plantList = new ArrayList<>();
		try {
			ResultSet res = database.makeQuery("SELECT * FROM post WHERE plant LIKE '" + plant + "'");
			while (res.next()) {
				plantList.add(new Post(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5)));
			}
		} catch (SQLException e) {
			System.out.println("Error searching the plant");
			return plantList;
		}
		return plantList;
	}
}
