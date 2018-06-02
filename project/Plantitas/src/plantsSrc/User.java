package plantsSrc;

public class User {

    private String username;
    private String password;
    private String email;
    private boolean logged;
    public static DB database = new DB();

    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;	
        logged = true;

    }
    
    public void logout() {
    	
    	logged = false;
    	
    }
    
    public void writePost (Post post) {
    	
    	
    	
    }
    
    public void addComment (Comment comment) {
    	
    	database.addComment(comment.)
    	
    }
    
    public Plant searchPlant(String name) {
		Plant plant = new Plant(name);
		return plant;
	}

}
