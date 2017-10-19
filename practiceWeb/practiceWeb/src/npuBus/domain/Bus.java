package npuBus.domain;

import java.util.ArrayList;

public class Bus {
	String busId;
	int capability;
	String drivername;
	String phone;
	static ArrayList<Student> studentList=null ;
	public Bus(String busId,int capability) {
		this.busId = busId;
		this.capability=capability;
	}
	
	public Bus() {
		
	}
	@Override
	public boolean equals(Object obj){
		 if (obj == null||this.getBusId()==null) {
		        return false;
		    }
		    if (!Bus.class.isAssignableFrom(obj.getClass())) {
		        return false;
		    }
		    final Bus other = (Bus) obj;
		    if(!this.getBusId().equals(other.getBusId()))
		    	return false;
		    return true;
		
	}
	public Bus(String busId, int capability, String drivername, String phone) {
		
		this.busId = busId;
		this.capability = capability;
		this.drivername = drivername;
		this.phone = phone;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCapability() {
		return capability;
	}
	public void setCapability(int capability) {
		this.capability = capability;
	}
	
	
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public ArrayList<String> getStudentList() {
		ArrayList<String> StudentList=new ArrayList<String>() ;
		for(Student a:studentList){
			StudentList.add(a.getName());
		}
		return StudentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		Bus.studentList = studentList;
	}
	public void addStudent(Student a){
		if(studentList==null){
			studentList=new ArrayList<Student>();
		}
		studentList.add(a);
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", capability=" + capability + ", drivername=" + drivername + ", phone=" + phone
				+ "]";
	}
}
