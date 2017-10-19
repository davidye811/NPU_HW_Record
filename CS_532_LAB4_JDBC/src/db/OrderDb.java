package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.order;
import exceptions.AccountDbFailure;

/* Methods to perform operations on the bank database */
public class OrderDb {
	private static int maxTimesToRetry = 3;
	
	/* Illustrate using two Database connections and the challenges that occur.   In this case the
	 * first database connection attempts to add "amt" to the account balance.    Meanwhile, a second
	 * database connection is also working.   It attempts to add $10.00 to the SAME bank account.
	 * Each database connection uses transactions.   What happens?   Can you analyze the behavior that
	 * you expect to happen by looking at the code?   Can you explain the behavior?
	 * Note:  This is not intended as production code, it is an experiment.
	 */
	public static void showAllAccountState()throws AccountDbFailure, SQLException{
		double curBal;
    	double newBalance = 0.0;
    	int rowsAffected;
    	String strBuf="";
    	Connection dbConn;
    	Connection dbConn2;
    	  dbConn = OrderAppDataSource.getConnection();
          dbConn2 = OrderAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
		try {
// 			 selectAllStmt.executeQuery();
			 strBuf+=doAllQueryPrepareSql(dbConn)+"\n";
			 strBuf+=productShowPrepareSql(dbConn)+"\n";
			 strBuf+=accountShowPrepareSql(dbConn)+"\n";
			 System.out.println(strBuf);
		} catch (SQLException ex) {
			
			throw new AccountDbFailure(AccountDbFailure.STMT_FAILED);
		}
		

	}
	public static void insertOrderState(order newOrder)throws AccountDbFailure, SQLException{
		double curBal;
    	double newBalance = 0.0;
    	int rowsAffected;
    	String strBuf;
    	Connection dbConn;
    	Connection dbConn2;
    	  dbConn = OrderAppDataSource.getConnection();
          dbConn2 = OrderAppDataSource.getConnection();
          dbConn.setAutoCommit(false);
          dbConn2.setAutoCommit(false);
		try {
// 			 selectAllStmt.executeQuery();
			 insertOrderQueryPrepareSql(dbConn,newOrder);
			 adjustSmountInSstock(dbConn, newOrder);
			 updateCustomerAccount(dbConn, newOrder);
			 dbConn.commit();
		} catch (SQLException ex) {
			
			throw new AccountDbFailure(AccountDbFailure.STMT_FAILED);
		}
		

	}
    private static void updateCustomerAccount(Connection dbConn,order order) throws AccountDbFailure, SQLException {
    	double curBal;
    	double newBalance = 0.0;
    	int rowsAffected;
    	double sumExpense;
        String updateCurBalSql = "UPDATE account SET balance = ? where id = ? AND balance = ?;";
        
        // Get the current balance 
        curBal = getAcctBalanceWithConn(order.getCusid(), dbConn);
		sumExpense=getSumExpensePreparedSql(order.getId(),dbConn)*order.getAmount();
		newBalance = curBal -sumExpense;
		
		// Update the balance 
		try (PreparedStatement updateCurBalStmt = dbConn.prepareStatement(updateCurBalSql)) {
			updateCurBalStmt.setDouble(1, newBalance);
			updateCurBalStmt.setInt(2, order.getCusid());
			updateCurBalStmt.setDouble(3, curBal);
			rowsAffected = updateCurBalStmt.executeUpdate();
			if (rowsAffected != 1) {  
				if (rowsAffected == 0) {
						throw new AccountDbFailure(AccountDbFailure.RETRY);
				}
				
				
				throw new AccountDbFailure(AccountDbFailure.STMT_FAILED, "Expected only one row to be affected by the deposit operation");
			} 
		} 
		
	}
	private static double getSumExpensePreparedSql(int id, Connection dbConn) throws SQLException {
		String readCurBalSql = "select p.price as Totalprice from orderdb.product p,orderdb.order o where o.id=? and o.id=p.id ";
		double curBal=0.0;
	    // Get the current balance 
		try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
			/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
			 * Your code will look simpler, neater, and more professional!
			 */
			readCurBalStmt.setInt(1,id);
			curBal=getSumExpenseRetrieve(readCurBalStmt);
		} 
		return curBal;
	}
	private static double getSumExpenseRetrieve(PreparedStatement readCurBalStmt) throws SQLException {
		double curBal=0.0;
	      
        // Get the current balance 
		try (ResultSet results = readCurBalStmt.executeQuery();) {
			if(results.next()){
				
				curBal+=results.getDouble("Totalprice");
				}
			}
		return curBal;
	}
	private static void adjustSmountInSstock(Connection dbConn,order order) throws AccountDbFailure, SQLException {
		int curAmt;
    	int newAmount = 0;
    	int rowsAffected;
        String updateCurBalSql = "UPDATE `orderdb`.`product` SET numinstock = ? where id = ? AND numinstock = ?;";
        
        // Get the current balance 
        curAmt = getProductAmountPreparedSql(order.getCusid(), dbConn);
		
		newAmount = curAmt - order.getAmount();
		if(newAmount<0)
			throw new AccountDbFailure(AccountDbFailure.STMT_FAILED, "The product has been sold out");
		// Update the balance 
		try (PreparedStatement updateCurBalStmt = dbConn.prepareStatement(updateCurBalSql)) {
			updateCurBalStmt.setInt(1, newAmount);
			updateCurBalStmt.setInt(2, order.getId());
			updateCurBalStmt.setInt(3, curAmt);
			rowsAffected = updateCurBalStmt.executeUpdate();
			if (rowsAffected != 1) {  /* Exactly one row should have been updated */
				if (rowsAffected == 0) {
					/* Our "dirty check" indicated that some other connection changed the row we were working on.   We'll rollback and retry (redo) the entire transaction */
					throw new AccountDbFailure(AccountDbFailure.RETRY);
				}
				
				/* More than one row modified? */
				throw new AccountDbFailure(AccountDbFailure.STMT_FAILED, "Expected only one row to be affected by the deposit operation");
			} 
		} 
		
	}
	private static int getProductAmountPreparedSql(int id, Connection dbConn) throws SQLException, AccountDbFailure {
	    	int curAmt;
	    	String readCurBalSql = "SELECT numinstock " + "FROM `orderdb`.`product` " + "WHERE id = ?";
	      
	        // Get the current balance 
			try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
				/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
				 * Your code will look simpler, neater, and more professional!
				 */
				curAmt = getProductAmountRetrieve(id, readCurBalStmt);
			} 
			
			return curAmt;
	    }
	private static int getProductAmountRetrieve(int id, PreparedStatement readCurBalStmt) throws AccountDbFailure, SQLException {
		int curAmt;
		readCurBalStmt.setInt(1, id);
		try (ResultSet results = readCurBalStmt.executeQuery();) {
			if (!results.next()) {
				throw new AccountDbFailure(AccountDbFailure.BAD_ACCT_ID, "Unknown account id: " + id);
			} else {
				curAmt = results.getInt("numinstock");
			}
			}
		return curAmt;
		}
	
	
	public static void depositToAccountTwoConn(int accountId, double amt) throws AccountDbFailure, SQLException {
    	double curBal;
    	double newBalance = 0.0;
    	int rowsAffected;
    	Connection dbConn;
    	Connection dbConn2;
      
        String updateCurBalSql = "UPDATE account SET balance = ? where id = ? ;";
        
        dbConn = OrderAppDataSource.getConnection();
        dbConn2 = OrderAppDataSource.getConnection();
        
        // Turn off auto-commit so we can use transactions
        dbConn.setAutoCommit(false);
        dbConn2.setAutoCommit(false);

        // Get the current balance with the first connection
        curBal = getAcctBalanceWithConn(accountId, dbConn);
		
		newBalance = curBal + amt;
		
		// Update the balance using the first connection (dbConn) but don't commit
		try (PreparedStatement updateCurBalStmt = dbConn.prepareStatement(updateCurBalSql)) {
			updateCurBalStmt.setDouble(1, newBalance);
			updateCurBalStmt.setInt(2, accountId);
			rowsAffected = updateCurBalStmt.executeUpdate();
			if (rowsAffected != 1) {
				dbConn.rollback();
				throw new AccountDbFailure(AccountDbFailure.STMT_FAILED);
			} 
		} catch (SQLException ex) {
			dbConn.rollback();
			throw new AccountDbFailure(AccountDbFailure.STMT_FAILED);
		}
		
		// Get the current balance using the second connection (dbConn2)
        curBal = getAcctBalanceWithConn(accountId, dbConn2);

		newBalance = curBal + 10.0;  /* only add 10 dollars -- different from first deposit */
		dbConn.commit();  /* Commit changes made with our first connection  */

		// Update the balance using our second connection (dbConn2)
		try (PreparedStatement updateCurBalStmt = dbConn2.prepareStatement(updateCurBalSql)) {
			updateCurBalStmt.setDouble(1, newBalance);
			updateCurBalStmt.setInt(2, accountId);
			rowsAffected = updateCurBalStmt.executeUpdate();
			if (rowsAffected != 1) {
				dbConn2.rollback();
				throw new AccountDbFailure(AccountDbFailure.STMT_FAILED);
			} else {
				dbConn2.commit();   // Commit changes made with second connection (dbConn2)
			}
		} catch (SQLException ex) {
			dbConn.rollback();
			throw new AccountDbFailure(AccountDbFailure.STMT_FAILED);
		}
	
        System.out.println("Previous balance: " + curBal);
        System.out.println("New balance: " + newBalance);
        
        dbConn.close();
        dbConn2.close();

    }
    
    
    /* Perform a deposit operation -- call this method if we already have a connection  */
    public static void depositToAccountWithConn(int accountId, double amt, Connection dbConn) throws AccountDbFailure, SQLException {
    	double curBal;
    	double newBalance = 0.0;
    	int rowsAffected;
        String updateCurBalSql = "UPDATE account SET balance = ? where id = ? AND balance = ?;";
        
        // Get the current balance 
        curBal = getAcctBalanceWithConn(accountId, dbConn);
		
		newBalance = curBal + amt;
		
		// Update the balance 
		try (PreparedStatement updateCurBalStmt = dbConn.prepareStatement(updateCurBalSql)) {
			updateCurBalStmt.setDouble(1, newBalance);
			updateCurBalStmt.setInt(2, accountId);
			updateCurBalStmt.setDouble(3, curBal);
			rowsAffected = updateCurBalStmt.executeUpdate();
			if (rowsAffected != 1) {  /* Exactly one row should have been updated */
				if (rowsAffected == 0) {
					/* Our "dirty check" indicated that some other connection changed the row we were working on.   We'll rollback and retry (redo) the entire transaction */
					throw new AccountDbFailure(AccountDbFailure.RETRY);
				}
				
				/* More than one row modified? */
				throw new AccountDbFailure(AccountDbFailure.STMT_FAILED, "Expected only one row to be affected by the deposit operation");
			} 
		} 
    }
    
    /* Call this method if we are not currently using a connection (so we need to obtain a connection)
     * The method: 1) obtains a connection, 2) starts a transaction, 3) performs the database work, 4) commits or rolls back the transaction,
     * 5) releases the connection
     */
    public static void depositToAccount(int accountId, double amt) throws AccountDbFailure, SQLException {
      
    	try (Connection dbConn = OrderAppDataSource.getConnection()) {
    		// Turn off auto-commit so we can use transactions.  No changes will be permanent until we commit the transaction.
            dbConn.setAutoCommit(false);
            
            /* We are now operating under a transaction, rollback on an exception or commit on successful completion */
            try {
            	depositToAccountWithConn(accountId, amt, dbConn);
            	dbConn.commit();   /* End of transaction.  Since it was successful, commit it. */
            } catch (AccountDbFailure ex) {
            	dbConn.rollback();
            	throw ex;  /* rethrow the exception so the caller function can recover from this failure */
            } catch (Exception ex) {
            	/* This is a catch-all -- rollback transaction and throw a more useful exception */
    			dbConn.rollback();
    			throw new AccountDbFailure(AccountDbFailure.STMT_FAILED, ex.getMessage());
    		}
    	} 
    }
    
    /* If there is a failure in doing the deposit because of other connections using the same row,
     * retry the operation.
     */
    public static void doDepositToAcctRetry(int accountId, double amt) throws AccountDbFailure, SQLException {
    	int numAttempts = 0;
    	
		while (numAttempts < maxTimesToRetry) {
			try {
				depositToAccount(accountId, amt);
				return;
			} catch (AccountDbFailure dbFailureEx) {
				if (dbFailureEx.getFailureReason() != AccountDbFailure.RETRY) {
					/* Rethrow the exception, we can't handle it here. */
					throw dbFailureEx;
				}
			}
			
			numAttempts++;
		}
		
		throw new AccountDbFailure(AccountDbFailure.RETRY_LIMIT_EXCEEDED, maxTimesToRetry + " attempts to perform the update were unsuccessful.  Aborting operation.");
    }
    
    /* Given a Statement, execute it to get the result set, then pull the balance from the result set */
    private static double doAcctBalanceQuery(int accountId, PreparedStatement readCurBalStmt) throws AccountDbFailure, SQLException {
    	double curBal;
      
    	readCurBalStmt.setInt(1, accountId);
    	
        // Get the current balance 
		try (ResultSet results = readCurBalStmt.executeQuery();) {
			if (!results.next()) {
				throw new AccountDbFailure(AccountDbFailure.BAD_ACCT_ID, "Unknown account id: " + accountId);
			} else {
				curBal = results.getDouble("balance");
			}
		} 
		
		return curBal;
    }
    
    /* Call this method if we want to get the balance but already have a connection (are currently in a transaction) */
    private static double getAcctBalanceWithConn(int accountId, Connection dbConn) throws AccountDbFailure, SQLException {
    	double curBal;
    	String readCurBalSql = "SELECT balance " + "FROM account " + "WHERE id = ?";
      
        // Get the current balance 
		try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
			/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
			 * Your code will look simpler, neater, and more professional!
			 */
			curBal = doAcctBalanceQuery(accountId, readCurBalStmt);
		} 
		
		return curBal;
    }
//    private static String doAllQueryConnect(PreparedStatement selectAllStmt) throws AccountDbFailure, SQLException {
//    	String builder = null;
//        // Get the current balance 
//
//			try (Connection dbConn = OrderAppDataSource.getConnection()){
//					builder=doAllQueryRetrieve(dbConn);
//				} 
//			return builder;
//	
//    }
	private static String doAllQueryPrepareSql(Connection dbConn) throws SQLException, AccountDbFailure {
		String curBal;
    	String readCurBalSql = "SELECT * FROM `orderdb`.`order`";
      
        // Get the current balance 
		try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
			/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
			 * Your code will look simpler, neater, and more professional!
			 */
			curBal = doAllQueryRetrieve(readCurBalStmt);
		} 
		
		return curBal;
	}
	private static String doAllQueryRetrieve(PreparedStatement readCurBalStmt) throws SQLException, AccountDbFailure {
		StringBuilder curBal = new StringBuilder();
		curBal.append("id\t"+"cusid\t"+"date\t\t"+"amount\n");
        // Get the current balance 
		try (ResultSet results = readCurBalStmt.executeQuery();) {
			while(results.next()){
				curBal.append(results.getInt("id")+"\t");
				curBal.append(results.getString("cusid")+"\t");
				curBal.append(results.getString("date")+"\t");
				curBal.append(results.getDouble("amount")+"\n");
				}
			}
		return curBal.toString();
	}
	private static String productShowPrepareSql(Connection dbConn) throws SQLException, AccountDbFailure {
		String curBal;
    	String readCurBalSql = "SELECT * FROM `orderdb`.`product`";
      
        // Get the current balance 
		try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
			/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
			 * Your code will look simpler, neater, and more professional!
			 */
			curBal = productShowRetrieve(readCurBalStmt);
		} 
		
		return curBal;
	}
	private static String productShowRetrieve(PreparedStatement readCurBalStmt) throws SQLException, AccountDbFailure {
		StringBuilder curBal = new StringBuilder();
		curBal.append("id\t"+"prodnum\t"+"description\t"+"price\t"+"numinstock\n");
        // Get the current balance 
		try (ResultSet results = readCurBalStmt.executeQuery();) {
			while(results.next()){
				curBal.append(results.getInt("id")+"\t");
				curBal.append(results.getString("prodnum")+"\t");
				curBal.append(String.format("%-10s",results.getString("description"))+"\t");
				curBal.append(results.getDouble("price")+"\t");
				curBal.append(results.getInt("numinstock")+"\n");
				}
			}
		return curBal.toString();
	}
	private static String accountShowPrepareSql(Connection dbConn) throws SQLException, AccountDbFailure {
		String curBal;
    	String readCurBalSql = "SELECT * FROM `orderdb`.`account`";
      
        // Get the current balance 
		try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
			/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
			 * Your code will look simpler, neater, and more professional!
			 */
			curBal = accountShowRetrieve(readCurBalStmt);
		} 
		
		return curBal;
	}
	private static String accountShowRetrieve(PreparedStatement readCurBalStmt) throws SQLException, AccountDbFailure {
		StringBuilder curBal = new StringBuilder();
		curBal.append("id\t"+"acctnum\t"+"name\t\t"+"phone\t\t"+"balance\n");
        // Get the current balance 
		try (ResultSet results = readCurBalStmt.executeQuery();) {
			while(results.next()){
				curBal.append(results.getInt("id")+"\t");
				curBal.append(results.getString("acctnum")+"\t");
				curBal.append(results.getString("name")+"\t");
				curBal.append(results.getString("phone")+"\t");
				curBal.append(results.getDouble("balance")+"\n");
				}
			}
		return curBal.toString();
	}
		/* Call this method if we are not currently using a connection (so we need to obtain a connection) */
	    public static double getAcctBalance(int accountId) throws AccountDbFailure, SQLException {
	    	double curBal = 0.0;
	      
	    	try (Connection dbConn = OrderAppDataSource.getConnection()) {
	    		curBal = getAcctBalanceWithConn(accountId, dbConn);
	    	} 
	    	
			return curBal;
	    }
	
		private static void insertOrderQueryPrepareSql(Connection dbConn,order newOrder) throws SQLException, AccountDbFailure {
		String curBal;
		String readCurBalSql = "INSERT INTO `order`(`id`,`cusid`,`date`,`amount`) VALUES (?,?,?,?);";
	  
	    // Get the current balance 
		try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
			/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
			 * Your code will look simpler, neater, and more professional!
			 */
			insertOrderRetrieve(readCurBalStmt,newOrder);
		} 
		

	}
		private static void insertOrderRetrieve(PreparedStatement readCurBalStmt,order newOrder) throws SQLException, AccountDbFailure {
		StringBuilder curBal = new StringBuilder();
		readCurBalStmt.setInt(1, newOrder.getId());
		readCurBalStmt.setInt(2, newOrder.getCusid());
		readCurBalStmt.setDate(3, newOrder.getDate());
		readCurBalStmt.setInt(4, newOrder.getAmount());
		int results = readCurBalStmt.executeUpdate();
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
		public static void dbCalculateSum() throws SQLException, AccountDbFailure {
			double curBal;
	    	double newBalance = 0.0;
	    	int rowsAffected;
	    	Connection dbConn;
	    	Connection dbConn2;
	    	  dbConn = OrderAppDataSource.getConnection();
	          dbConn2 = OrderAppDataSource.getConnection();
	          dbConn.setAutoCommit(false);
	          dbConn2.setAutoCommit(false);
			
//	 			 selectAllStmt.executeQuery();
	          try {
//	  			 selectAllStmt.executeQuery();
//	        	  System.out.println(doAllQueryPrepareSql(dbConn));
	        	  curBal=dbCalculateSumPrepareSql(dbConn);
	        	  System.out.println((int)(curBal*100)/100.0);
//	 			 	System.out.println(doAllQueryPrepareSql(dbConn));
	 		} catch (SQLException ex) {
	 			
	 			throw new AccountDbFailure(AccountDbFailure.STMT_FAILED);
	 		}
	          
			
		}
		private static double dbCalculateSumPrepareSql(Connection dbConn) throws SQLException, AccountDbFailure {
			String readCurBalSql = "select o.amount*p.price as Totalprice from orderdb.product p,orderdb.order o where o.id=p.id ";
			double curBal=0.0;
		    // Get the current balance 
			try (PreparedStatement readCurBalStmt = dbConn.prepareStatement(readCurBalSql)) {
				/* Avoid putting a try-block inside another try block -- it looks messy.   To avoid this, put the try block inside function doAcctBalanceQuery(). 
				 * Your code will look simpler, neater, and more professional!
				 */
				curBal=dbCalculateSumRetrieve(readCurBalStmt);
			} 
			return curBal;
		}
		private static double dbCalculateSumRetrieve(PreparedStatement readCurBalStmt) throws SQLException, AccountDbFailure {
			double curBal=0.0;
		      
	        // Get the current balance 
			try (ResultSet results = readCurBalStmt.executeQuery();) {
				while(results.next()){
					
					curBal+=results.getDouble("Totalprice");
					}
				}
			return curBal;
		}
	
	}
