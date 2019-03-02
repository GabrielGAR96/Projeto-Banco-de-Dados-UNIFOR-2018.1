package teste;

import java.sql.Connection;
import java.sql.DriverManager;


public class sqlConnection {
	public static Connection dbConnector() {
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastros2?useSSL=true", "root", "f3i35uqe");
			return con;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
