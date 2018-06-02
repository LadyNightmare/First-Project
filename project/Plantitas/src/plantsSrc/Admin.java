package plantsSrc;
import java.sql.SQLException;

import java.util.List;

public class Admin extends User {
	
	public Admin(String username, String password, String mail, DB database){
		super(username,password,mail,database);
	}
	
	public void logout(){super.logout();}
	
	public void writePost(Post post){super.writePost(post);}
	
	public List<Plant> searchPlant(String plant){return super.searchPlant(plant);}
	
	public void opUser(String username){
		try {
			super.database.makeChange("UPDATE `user` SET Admin=1 WHERE Username LIKE '" + username + "'");
		} catch (SQLException e) {
			
		}
	}
	public void deOpUser(String username){
		try {
			super.database.makeChange("UPDATE `user` SET Admin=0 WHERE Username LIKE '" + username + "'");
		} catch (SQLException e) {
			
		}
	}
	public void deleteComment(String comment_ID){
		try {
			super.database.deletePost(comment_ID);
		} catch (SQLException e) {
			
		}
	}
	public void modifyPlant(String plant,String description){
		try{
			if(description.equals("")){
				super.database.deletePlant(plant);
			}else{
				super.database.makeChange("UPDATE `plant` SET Description='"+description+"' WHERE Plant LIKE '" + plant + "'");
			}
		}catch(SQLException e){
			
		}
	}
	public void createPlant(String plant,String description){
		try {
			super.database.addPlant(plant, description);
		} catch (SQLException e) {
			
		}
	}
	public void deletePost(String ID){
		try {
			super.database.deletePost(ID);
			super.database.makeChange("DELETE FROM `comment` WHERE `comment`.`Post_ID` = "+ ID);
		} catch (SQLException e) {
			
		}
		
	}
}
