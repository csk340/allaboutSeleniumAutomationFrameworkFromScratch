package IntegrationOfDBwithJDBCAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;;


public class DBIntegration {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String host ="localhost";
		String port =  "3306";
		String URL = "jdbc:mysql://"+host+":"+port+"/ChinmayDB";
		Connection conn= DriverManager.getConnection(URL, "root", "TIGER");
		Statement s = conn.createStatement();
		ResultSet rs =s.executeQuery("select *\r\n"
				+ "from MyFirstTableMySQLDB\r\n"
				+ "where id=456;");
		
		rs.next(); //Very imp as here by default control on DB is on 0th index/base index so now we need to move to 1st index thats why we need this line
		System.out.println(rs.getString("location"));
		System.out.println(rs.getString("age"));
	}

}
