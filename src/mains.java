import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mains {
    static final String DB_URL = "jdbc:mysql://localhost:3306/students";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
       Connection conn= null;
       Statement st = null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Connecting to the selected database");
           conn=DriverManager.getConnection(DB_URL,USER,PASS);
           System.out.println("Connected to the database successfuly");
           System.out.println("Created table in selected database");
           st = conn.createStatement();

           String sql = "CREATE TABLE REGISTRATION"+"(id INTEGER not null,"
           +"first_name VARCHAR(255)," +"last_name VARCHAR(255),"+"age INTEGER,"
           +"PRIMARY KEY(id))";

           st.executeUpdate(sql);
           System.out.println("Table is creating in given database");



       }catch(SQLException ex){
           ex.printStackTrace();

       }catch(Exception ex){
           ex.printStackTrace();

       }finally {
           try {
               if (st != null)
                   conn.close();
               }catch(SQLException ex){
               ex.printStackTrace();
           }try{
               if (conn != null)
                   conn.close();
           }catch (SQLException ex){
               ex.printStackTrace();
           }
           System.out.println("Created successfully");
       }

    }
}