package plantsSrc;

import java.util.ArrayList;
import java.util.List;

public class Post {
	 String ID;
	 String head;
	 String body;
	 String username;
	 String plant;
	 List<Comment> comments;

	public Post(String ID, String head, String body, String username, String plant) {
		this.ID = ID;
		this.head = head;
		this.body = body;
		this.username = username;
		this.plant = plant;
		comments = new ArrayList<>();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public  String getID() {
		return ID;
	}

	public String getHead() {
		return head;
	}

	public  String getBody() {
		return body;
	}

	public  String getUsername() {
		return username;
	}

	public  String getPlant() {
		return plant;
	}
}
