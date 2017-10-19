package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseService {
	private static String dbSourceUrl = "jdbc:mysql://localhost/cs532_coursedb_ex";
	static private Connection courseDbConn;
	static private String userId = "root";
	static private String dbPassword = "1";
	
	
	public static Connection getConnection() throws SQLException {
		if (courseDbConn == null) {
			courseDbConn =  DriverManager.getConnection(dbSourceUrl, userId, dbPassword);
		}
		
		return courseDbConn;
	}
	
	public static void shutdown() throws SQLException {
		if (courseDbConn != null) {
			courseDbConn.close();
		}
	}
	
	public static void printCourses(String college) throws SQLException {
		Connection dbConn;
		String queryStr = "SELECT coursename, coursenum " + "FROM courses "
				+ "WHERE College = '" + college + "'";
		
		dbConn = getConnection();
		Statement queryStmt = dbConn.createStatement();
		ResultSet results;
		String courseName, courseNum;

		results = queryStmt.executeQuery(queryStr);
		while (results.next()) { // process results
			courseName = results.getString("coursename");
			courseNum = results.getString("coursenum");
			System.out.println(courseName + "    " + courseNum);
		}

		// Free resources
		results.close();
		queryStmt.close();
	}
}
