import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB{
	String url = "jdbc:mysql://localhost:3306/plant?useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "";
    Connection con;
    public DB(){
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}    
    }
    
    public ResultSet makeQuery(String query){
        ResultSet res = null;
		try {
	    	Statement stt = con.createStatement();
			res = stt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return res;
    }
    
    public void addUser(String ID,String username,String password,String mail,String admin){
    	try{
    		Statement stt = con.createStatement();
    		stt.execute("INSERT INTO user (ID, Username, Password, Mail, Admin) VALUES" + 
                    "('"+ID+"', '"+username+"', '"+password+"', '"+mail+"', '"+admin+"')");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void addPlant(String plant, String description){
    	try{
    		Statement stt = con.createStatement();
    		stt.execute("INSERT INTO plant (Plant, Description) VALUES" + 
                    "('"+plant+"', '"+description+"')");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void addPost(String comment_ID,String comment,String user,String post_ID){
    	try{
    		Statement stt = con.createStatement();
    		stt.execute("INSERT INTO post (Comment_ID, Comment, User, Post_ID) VALUES" + 
                    "('"+comment_ID+"', '"+comment+"', '"+user+"', '"+post_ID+"')");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void deleteUser(String username){
    	try{
    		Statement stt = con.createStatement();
    		stt.execute("DELETE FROM user WHERE Username = "+ username);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void deleteRow(String query){
    	try{
    		Statement stt = con.createStatement();
    		stt.execute(query);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	
    /*public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/plant?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            ResultSet res = stt.executeQuery("SELECT * FROM user");
            while(res.next()){
            	System.out.println(res.getString(1) + " " + res.getString(2));
            }
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/
}