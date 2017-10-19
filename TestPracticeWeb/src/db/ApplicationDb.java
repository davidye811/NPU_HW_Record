package db;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.AccountDbFailure;
import npuBus.domain.Application;

/* Methods to perform operations on the bank database */
public class ApplicationDb {
	private static int maxTimesToRetry = 3;

	public static Application getApplicationWithApplicationid(int studentid) throws  AccountDbFailure,SQLException {
		Application curApplication;
		Connection dbConn;
    	Connection dbConn2;
    	  dbConn = BusAppDataSource.getConnection();
          dbConn2 = BusAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
          curApplication=getApplicationWithDbConnection(dbConn,studentid);
		return curApplication;
	}

	private static Application getApplicationWithDbConnection(Connection dbConn, int studentid)  throws  AccountDbFailure,SQLException{
		String readCurApplicationSql="select * from busdb.Application b where b.studentid=?";
		Application curApplication=new Application();
		try(PreparedStatement readCurApplicationStmt =dbConn.prepareStatement(readCurApplicationSql)){
			readCurApplicationStmt.setInt(1, studentid);
			curApplication=getApplicationWithSqlStmt(readCurApplicationStmt);
		}
		return curApplication;
	}

	private static Application getApplicationWithSqlStmt(PreparedStatement readCurApplicationStmt) throws SQLException {
		Application curApplication =new Application();
		try(ResultSet results =readCurApplicationStmt.executeQuery();){
			if(results.next()){
				curApplication.setBusid(results.getString("Busid"));
				curApplication.setCarryon(results.getString("Carryon"));
				curApplication.setDescription(results.getString("Description"));
				curApplication.setStudentid(results.getInt("Studentid"));
			}
		}
		return curApplication;
	}
	public static void updateApplicationWithApplication(Application apl) throws  AccountDbFailure,SQLException {
		Application curApplication;
		Connection dbConn;
    	Connection dbConn2;
    	  dbConn = BusAppDataSource.getConnection();
          dbConn2 = BusAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
          updateApplicationWithDbConnection(dbConn,apl);
          dbConn.commit();
          dbConn2.commit();
          dbConn.close();
	}

	private static void updateApplicationWithDbConnection(Connection dbConn, Application Application) throws SQLException, AccountDbFailure {
		String readCurApplicationSql="UPDATE `busdb`.`Application` SET  `studentid`=?, `busid`=?, `carryon`=?, `description`=?";
		
		try(PreparedStatement readCurApplicationStmt =dbConn.prepareStatement(readCurApplicationSql)){
			readCurApplicationStmt.setInt(1, Application.getStudentid());
			readCurApplicationStmt.setString(2, Application.getBusid());
			readCurApplicationStmt.setString(3, Application.getCarryon());
			readCurApplicationStmt.setString(4, Application.getDescription());
			updateApplicationWithSqlStmt(readCurApplicationStmt);
		}
		
		// TODO Auto-generated method stub
		
	}

	private static void updateApplicationWithSqlStmt(PreparedStatement readCurApplicationStmt) throws AccountDbFailure, SQLException {
		// TODO Auto-generated method stub
		int rowAffected;
		 rowAffected=readCurApplicationStmt.executeUpdate();
		 if(rowAffected==-1){
			throw new AccountDbFailure(-1,"update fail");
			}
		}
	
	public static void insertApplicationWithApplication(Application Application) throws  AccountDbFailure,SQLException {
		Connection dbConn;
    	Connection dbConn2;
    	  dbConn = BusAppDataSource.getConnection();
          dbConn2 = BusAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
          insertApplicationWithDbConnection(dbConn,Application);
          dbConn.commit();
          dbConn.close();
          
	}

	private static void insertApplicationWithDbConnection(Connection dbConn, Application Application) throws SQLException, AccountDbFailure {
		String readCurApplicationSql="INSERT INTO `busdb`.`application` (`studentid`, `busid`, `carryon`, `description`) VALUES (?, ?, ?, ?);";
		try(PreparedStatement readCurApplicationStmt =dbConn.prepareStatement(readCurApplicationSql)){
			readCurApplicationStmt.setInt(1, Application.getStudentid());
			readCurApplicationStmt.setString(2, Application.getBusid());
			readCurApplicationStmt.setString(3, Application.getCarryon());
			readCurApplicationStmt.setString(4, Application.getDescription());
			insertApplicationWithSqlStmt(readCurApplicationStmt);
		}
		
		// TODO Auto-generated method stub
		
	}

	private static void insertApplicationWithSqlStmt(PreparedStatement readCurApplicationStmt) throws SQLException, AccountDbFailure {
		
		 int results = readCurApplicationStmt.executeUpdate();
		    // Get the current balance 
				if (results != 1) {  /* Exactly one row should have been updated */
					if (results == 0) {
						/* Our "dirty check" indicated that some other connection changed the row we were working on.   We'll rollback and retry (redo) the entire transaction */
						throw new AccountDbFailure(AccountDbFailure.RETRY);
					}
					
					/* More than one row modified? */
					throw new AccountDbFailure(AccountDbFailure.STMT_FAILED, "Expected only one row to be affected by the deposit operation");
				} 
			}

	

	
	
}
