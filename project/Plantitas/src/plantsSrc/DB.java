package plantsSrc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public ResultSet makeQuery(String query) {
		ResultSet res = null;
		try {
			Statement stt = con.createStatement();
			res = stt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public void makeChange(String change) {
		try {
			Statement stt = con.createStatement();
			stt.execute(change);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addUser(String ID, String username, String password, String mail, String admin) {
		try {
			Statement stt = con.createStatement();
			stt.execute("INSERT INTO user (ID, Username, Password, Mail, Admin) VALUES" + "('" + ID + "', '" + username
					+ "', '" + password + "', '" + mail + "', '" + admin + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPlant(String plant, String description) {
		try {
			Statement stt = con.createStatement();
			stt.execute("INSERT INTO plant (Plant, Description) VALUES" + "('" + plant + "', '" + description + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPost(String ID, String head, String body, String username, String plant) {
		try {
			Statement stt = con.createStatement();
			String id_user = null;
			ResultSet res = this.makeQuery("SELECT * FROM `user` WHERE `user`.`Username` LIKE '" + username + "'");
			while (res.next()) {
				id_user = res.getString("ID");
			}
			stt.execute("INSERT INTO post (ID, Head, Body, User, Plant) VALUES" + "('" + ID + "', '" + head + "', '"
					+ body + "', '" + id_user + "', '" + plant + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addComment(String comment_ID, String comment, String user, String post_ID) {
		try {
			Statement stt = con.createStatement();
			stt.execute("INSERT INTO comment (Comment_ID, Comment, User, Post_ID) VALUES" + "('" + comment_ID + "', '"
					+ comment + "', '" + user + "', '" + post_ID + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String username) {
		try {
			Statement stt = con.createStatement();
			String id = null;
			ResultSet res = this.makeQuery("SELECT * FROM `user` WHERE `user`.`Username` LIKE '" + username + "'");
			while (res.next()) {
				id = res.getString("ID");
			}
			stt.execute("DELETE FROM `user` WHERE `user`.`ID` = " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePlant(String plant) {
		try {
			Statement stt = con.createStatement();
			stt.execute("DELETE FROM `plant` WHERE `plant`.`Plant` LIKE '" + plant + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePost(String ID) {
		try {
			Statement stt = con.createStatement();
			stt.execute("DELETE FROM `post` WHERE `post`.`ID` = " + ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteComment(String ID) {
		try {
			Statement stt = con.createStatement();
			stt.execute("DELETE FROM `comment` WHERE `comment`.`Comment_ID` = " + ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}