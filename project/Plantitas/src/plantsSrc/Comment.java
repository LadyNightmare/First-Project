
public class Comment {
	String comment_ID;
	String comment;
	String user;
	String post_ID;
	
	public Comment(String comment_ID,String comment,String user,String post_ID){
		this.comment_ID=comment_ID;
		this.comment=comment;
		this.user=user;
		this.post_ID=post_ID;
	}

	public String getComment_ID() {
		return comment_ID;
	}

	public String getComment() {
		return comment;
	}

	public String getUser() {
		return user;
	}

	public String getPost_ID() {
		return post_ID;
	}
}
