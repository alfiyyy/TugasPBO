package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import static model.LoginModel.DB_URL;

public class Connector {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/geometri";
    static final String USER = "root";
    static final String PASS = "";
    
    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement pstmt;

    public Connector() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        } catch (Exception e) {
            System.out.println("Connection Failed");
        }
    }
}

    

