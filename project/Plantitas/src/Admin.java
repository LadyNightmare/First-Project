public class Admin extends User {
	
	public Admin(String username, String password, String mail, DB database){
		super(username,password,mail,database);
	}
	
	public void logout(){super.logout();}
	
	public void writePost(Post post){super.writePost(post);}
	
	public Plant[] searchPlant(String plant){return super.searchPlant(plant);}
	
	public void opUser(String username){
		super.database.makeChange("UPDATE `user` SET Admin=1 WHERE Username LIKE '" + username + "'");
	}
	public void deOpUser(String username){
		super.database.makeChange("UPDATE `user` SET Admin=0 WHERE Username LIKE '" + username + "'");
	}
	public void deleteComment(String comment_ID){
		super.database.deleteComment(comment_ID);
	}
	public void modifyPlant(String plant,String description){
		if(description.equals("")){
			super.database.deletePlant(plant);
		}else{
			super.database.makeChange("UPDATE `plant` SET Description='"+description+"' WHERE Plant LIKE '" + plant + "'");
		}
	}
	public void createPlant(String plant,String description){
		super.database.addPlant(plant, description);
	}
	public void deletePost(String ID){
		super.database.deletePost(ID);
		super.database.makeChange("DELETE FROM `comment` WHERE `comment`.`Post_ID` = "+ ID);
	}
}
