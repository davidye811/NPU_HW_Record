package npuBusService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ApplicationDb;
import db.Busdb;
import exceptions.AccountDbFailure;
import npuBus.domain.Application;
import npuBus.domain.Bus;

public class updateDbService {
	//------------------------------------------------------------------------------------------------
	//BusService
	public static Bus getBus(String busid) {
		double initialBal, finalBal;
		
		try {
			return Busdb.getBusWithBusid(busid);
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
		return new Bus();
			
		
	}
	public static void updateBus(Bus bus) {
		try {
			Busdb.updateBusWithBus(bus);
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
			
		
	}
	public static void insertBus(Bus bus) {
		try {
			Busdb.insertBusWithBus(bus);
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
			
		
	}
	//------------------------------------------------------------------------------------------------
	//ApplicationService
	public static Application getApplication(int studentid) {
		double initialBal, finalBal;
		
		try {
			return ApplicationDb.getApplicationWithApplicationid(studentid);
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
		return new Application();
			
		
	}
	public static void updateApplication(Application apl) {
		try {
			ApplicationDb.updateApplicationWithApplication(apl);
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
			
		
	}
	public static void insertApplication(Application apl) {
		try {
			ApplicationDb.insertApplicationWithApplication(apl);
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
			
		
	}
	public static List<String> getAllBus() {
		try {
			return Busdb.getAllBus();
		} catch (AccountDbFailure ex) {
			System.out.println("Failure with Database operation: "
					+ ex.getReasonStr());
		} catch (SQLException ex) {
			System.out.println("Database operation failure: " + ex);
		}
		return new ArrayList<String>();
	}
	
}
