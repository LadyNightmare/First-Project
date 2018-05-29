import java.sql.*;

public class BD
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/plant?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}