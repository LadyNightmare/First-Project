package plantsSrc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Guest {

	private static final long serialVersionUID = 1L;
	private static DB database = new DB();

	public List<Plant> searchPlant(String plant) {
		List<Plant> plantList = new ArrayList<>();
		try {
			ResultSet res = database.makeQuery("SELECT * FROM plant WHERE plant LIKE '" + plant + "'");
			while (res.next()) {
				plantList.add(new Plant(res.getString(0), res.getString(1)));
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

	public void signUp(String username, String password, String email) {
		User user = new User(username, password, email, database);
	}

}
