package plantsSrc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guest {
	private static DB database = new DB();

	public List<Post> searchPlant(String plant) {
		List<Post> plantList = new ArrayList<>();
		try {
			ResultSet res = database.makeQuery("SELECT * FROM post WHERE plant LIKE '" + plant + "'");
			while (res.next()) {
				plantList.add(new Post(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						res.getString(5)));
			}
		} catch (SQLException e) {
			return plantList;
		}
		return plantList;
	}

	public static int login(String username, String password) {
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

	public static boolean signUp(String username, String password, String email) {
		try {
			Random r = new Random();
			database.addUser(Integer.toString(r.nextInt(Integer.MAX_VALUE)), username, password, email, "0");
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

}
