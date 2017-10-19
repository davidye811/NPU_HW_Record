package client;

import java.sql.SQLException;

import services.CourseService;

/*  Important Note:
 *  You need to have the MySQL Connector J .jar file on your classpath.
 *  It has been added to this project -- make sure you know how to add it
 *  to your future projects.
 */
public class DbClient {
	public static void main(String args[]) {
		String collegeName;
		int i;

		if (args.length < 1) {
			System.out.println("Enter a college name");
			System.exit(1);
		}

		/* Support multi-word college names such as 'Computer Science' */
		collegeName = args[0];
		for (i = 1; i < args.length; i++) {
			collegeName = collegeName + " " + args[i];
		}

		try {
			CourseService.printCourses(collegeName); // query DB and print results
			CourseService.shutdown();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

}
