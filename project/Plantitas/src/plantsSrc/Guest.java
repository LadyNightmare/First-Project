package plantsSrc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Guest {
	
	private static final long serialVersionUID = 1L;
	private static DB database = new DB();

	public Plant searchPlant(String name) {
		Plant plant = new Plant(name);
		return plant;
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

	public void signUp(String username) {
		User user = new User(username);
	}

}
