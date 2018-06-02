import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private String mail;
	protected DB database;
	
	public User(String username, String password, String mail, DB database){
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.database = database;
	}
	
	public void logout(){}
	
	public void writePost(Post post){
		try {
			database.addPost(post.ID, post.head, post.body, post.username, post.plant);
		} catch (SQLException e) {
			
		}
	}
	
	public void addComment(Comment comment){
		try{
			database.addComment(comment.comment_ID, comment.comment, comment.user, comment.post_ID);
		}catch(SQLException e){
			
		}
	}
	
	public List<Plant> searchPlant(String plant){
		List<Plant> plantList = new ArrayList<>();
		try {
			ResultSet res = database.makeQuery("SELECT * FROM plant WHERE plant LIKE '"+plant+"'");
			while(res.next()){
				plantList.add(new Plant(res.getString(0), res.getString(1)));
			}
		} catch (SQLException e) {
			return plantList;
		}
		return plantList;
	}
}
