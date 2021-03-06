package plantsSrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {
	private String url = "jdbc:mysql://localhost:3306/plant?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user = "root";
	private String password = "";
	private Connection con;

	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet makeQuery(String query) throws SQLException {
		ResultSet res = null;
		Statement stt = con.createStatement();
		res = stt.executeQuery(query);
		return res;
	}

	public void makeChange(String change) throws SQLException {
		Statement stt = con.createStatement();
		stt.execute(change);
	}

	public void addUser(String ID, String username, String password, String mail, String admin) throws SQLException {
		Statement stt = con.createStatement();
		stt.execute("INSERT INTO user (ID, Username, Password, Mail, Admin) VALUES" + "('" + ID + "', '" + username
				+ "', '" + password + "', '" + mail + "', '" + admin + "')");
	}

	public void addPlant(String plant, String description) throws SQLException {
		Statement stt = con.createStatement();
		stt.execute("INSERT INTO plant (Plant, Description) VALUES" + "('" + plant + "', '" + description + "')");
	}

	public void addPost(String ID, String head, String body, String username, String plant) throws SQLException {
		Statement stt = con.createStatement();
		String id_user = null;
		ResultSet res = this.makeQuery("SELECT * FROM `user` WHERE `user`.`Username` LIKE '" + username + "'");
		while (res.next()) {
			id_user = res.getString("ID");
		}
		stt.execute("INSERT INTO post (ID, Head, Body, User, Plant) VALUES" + "('" + ID + "', '" + head + "', '" + body
				+ "', '" + id_user + "', '" + plant + "')");
	}

	public void addComment(String comment_ID, String comment, String user, String post_ID) throws SQLException {
		Statement stt = con.createStatement();
		stt.execute("INSERT INTO comment (Comment_ID, Comment, User, Post_ID) VALUES" + "('" + comment_ID + "', '"
				+ comment + "', '" + user + "', '" + post_ID + "')");
	}

	public void deleteUser(String username) throws SQLException {
		Statement stt = con.createStatement();
		String id = null;
		ResultSet res = this.makeQuery("SELECT * FROM `user` WHERE `user`.`Username` LIKE '" + username + "'");
		while (res.next()) {
			id = res.getString("ID");
		}
		stt.execute("DELETE FROM `user` WHERE `user`.`ID` = " + id);
	}

	public void deletePlant(String plant) throws SQLException {
		Statement stt = con.createStatement();
		stt.execute("DELETE FROM `plant` WHERE `plant`.`Plant` LIKE '" + plant + "'");
	}

	public void deletePost(String ID) throws SQLException {
		Statement stt = con.createStatement();
		stt.execute("DELETE FROM `post` WHERE `post`.`ID` = " + ID);
	}

	public void deleteComment(String ID) throws SQLException {
		Statement stt = con.createStatement();
		stt.execute("DELETE FROM `comment` WHERE `comment`.`Comment_ID` = " + ID);
	}
	
	public List<Comment> getComments(String ID) throws SQLException{
		Statement stt = con.createStatement();
		ResultSet res = stt.executeQuery("SELECT * FROM comment WHERE Post_ID ="+ID);
		List<Comment> list = new ArrayList<>();
		while(res.next()) {
			list.add(new Comment(res.getString("Comment_ID"),res.getString("Comment"),res.getString("User"),res.getString("Post_ID")));
		}
		return list;
	}
}