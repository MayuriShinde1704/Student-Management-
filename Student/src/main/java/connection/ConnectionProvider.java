package connection;

import java.sql.Connection;
import java.sql.*;
public class ConnectionProvider {
	public static Connection getConnection() throws Exception{
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
	
		}
		catch(Exception e) {
			
		}
		return connection;
	}

}