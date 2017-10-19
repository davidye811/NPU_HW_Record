package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.AccountDbFailure;
import npuBus.domain.Bus;

/* Methods to perform operations on the bank database */
public class Busdb {
	private static int maxTimesToRetry = 3;

	public static Bus getBusWithBusid(String busid) throws  AccountDbFailure,SQLException {
		Bus curBus;
		Connection dbConn;
    	Connection dbConn2;
    	  dbConn = BusAppDataSource.getConnection();
          dbConn2 = BusAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
          curBus=getBusWithDbConnection(dbConn,busid);
		return curBus;
	}

	private static Bus getBusWithDbConnection(Connection dbConn, String busid)  throws  AccountDbFailure,SQLException{
		String readCurBusSql="select * from busdb.bus b where b.busid=?";
		Bus curBus=new Bus();
		try(PreparedStatement readCurBusStmt =dbConn.prepareStatement(readCurBusSql)){
			readCurBusStmt.setString(1, busid);
			curBus=getBusWithSqlStmt(readCurBusStmt);
		}
		return curBus;
	}

	private static Bus getBusWithSqlStmt(PreparedStatement readCurBusStmt) throws SQLException {
		Bus curBus =new Bus();
		try(ResultSet results =readCurBusStmt.executeQuery();){
			if(results.next()){
				curBus.setBusId(results.getString("busid"));
				curBus.setCapability(results.getInt("capability"));
				curBus.setDrivername(results.getString("drivername"));
				curBus.setPhone(results.getString("phone"));
			}
		}
		return curBus;
	}
	public static void updateBusWithBus(Bus bus) throws  AccountDbFailure,SQLException {
		Bus curBus;
		Connection dbConn;
    	Connection dbConn2;
    	  dbConn = BusAppDataSource.getConnection();
          dbConn2 = BusAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
          updateBusWithDbConnection(dbConn,bus);
          dbConn.commit();
          dbConn2.commit();
          dbConn.close();
	}

	private static void updateBusWithDbConnection(Connection dbConn, Bus bus) throws SQLException, AccountDbFailure {
		String readCurBusSql="UPDATE `busdb`.`bus` SET  `drivername`=?, `phone`=?, `capability`=? WHERE `busid`=?;";
	
		try(PreparedStatement readCurBusStmt =dbConn.prepareStatement(readCurBusSql)){
			readCurBusStmt.setString(1, bus.getDrivername());
			readCurBusStmt.setString(2, bus.getPhone());
			readCurBusStmt.setInt(3, bus.getCapability());
			readCurBusStmt.setString(4, bus.getBusId());
			updateBusWithSqlStmt(readCurBusStmt);
		}
		
		// TODO Auto-generated method stub
		
	}

	private static void updateBusWithSqlStmt(PreparedStatement readCurBusStmt) throws AccountDbFailure, SQLException {
		// TODO Auto-generated method stub
		int rowAffected;
		 rowAffected=readCurBusStmt.executeUpdate();
		 if(rowAffected==-1){
			throw new AccountDbFailure(-1,"update fail");
			}
		}
	
	public static void insertBusWithBus(Bus bus) throws  AccountDbFailure,SQLException {
		Connection dbConn;
    	Connection dbConn2;
    	  dbConn = BusAppDataSource.getConnection();
          dbConn2 = BusAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
          insertBusWithDbConnection(dbConn,bus);
          dbConn.commit();
	}

	private static void insertBusWithDbConnection(Connection dbConn, Bus bus) throws SQLException, AccountDbFailure {
		String readCurBusSql="INSERT INTO `busdb`.`bus` ( `busid`, `drivername`, `phone`, `capability`) VALUES (?,?,?,?)";
		
		try(PreparedStatement readCurBusStmt =dbConn.prepareStatement(readCurBusSql)){
			readCurBusStmt.setString(1, bus.getBusId());
			readCurBusStmt.setString(2, bus.getDrivername());
			readCurBusStmt.setString(3, bus.getPhone());
			readCurBusStmt.setInt(4, bus.getCapability());
			insertBusWithSqlStmt(readCurBusStmt);
		}
		
		// TODO Auto-generated method stub
		
	}

	private static void insertBusWithSqlStmt(PreparedStatement readCurBusStmt) throws SQLException, AccountDbFailure {
		
		 int results = readCurBusStmt.executeUpdate();
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
