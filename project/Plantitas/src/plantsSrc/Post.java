package plantsSrc;
import java.util.ArrayList;
import java.util.List;

public class Post {
	static String ID; 
	static String head;
	static String body;
	static String username;
	static String plant;
	static List<Comment> comments;
	
	public Post(String ID,String head,String body,String username, String plant){
		this.ID=ID;
		this.head=head;
		this.body=body;
		this.username=username;
		this.plant=plant;
		comments = new ArrayList<>();
	}

	public static List<Comment> getComments() {
		return comments;
	}

	public static  String getID() {
		return ID;
	}

	public static String getHead() {
		return head;
	}

	public static String getBody() {
		return body;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPlant() {
		return plant;
	}
}
