package npuBusService;

import java.util.ArrayList;
import java.util.List;

import exceptions.StudentIdnotFoundFailure;
import npuBus.domain.Bus;
import npuBus.domain.Student;


public class busService {
//	public static void main(String[] argv){
//		Bus testcase = new Bus("BMW22", 55, "Tom Azir", "123-322-1234");
//		insertOrUpadateBus(testcase);
//		System.out.println(getBus("BMW22"));
//		testcase.setBusId("QWE11");
//		insertOrUpadateBus(testcase);
//		System.out.println(getBus("BMW22"));
//		System.out.println(getBusList());
//	}
	public static ArrayList<String> getBusStudent(String busid) {
		Bus bus;
		
		bus = getBus(busid);
		if (bus != null) {
			return bus.getStudentList();
		}
		
        return null;
	}
	public static void insertOrUpadateBus(Bus bus) {
		Bus curBus=getBus(bus.getBusId());
		if(curBus.equals(bus)){
			updateDbService.updateBus(bus);
		}else{
			updateDbService.insertBus(bus);
		}
		
	}
	private static Bus getBus(String busid) {
		Bus selectedBus=new Bus();
		selectedBus = updateDbService.getBus(busid);
		return selectedBus;
	}
	
	
//	private static void initBusList() {
//		Bus bus;
//		busList = new ArrayList<Bus>();
//		
//	}
	public static void addStudentToBus(String busid, Student student) throws StudentIdnotFoundFailure {
		
			Bus bus;
		
		bus = getBus(busid);
		bus.addStudent(student);
		
	}
	public static List<String> getBusList(){
		List<String> buslist= new ArrayList<String>();
		buslist=updateDbService.getAllBus();
		return buslist;
	}
	
	
//	public static ArrayList<Bus> getCourseList() {
//		if (busList == null) {
//			initBusList();
//		}
//		
//		return busList;
//	}

}
