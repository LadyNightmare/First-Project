package plantsSrc;

import java.util.LinkedList;

public class Post {
	private static String head, body;
	private static Plant plant;
	private static LinkedList<Comment> Comments;
	
	public Post(String head, String body, Plant plant) {
		this.head = head;
		this.body = body;
		this.plant = plant;
	}
}
