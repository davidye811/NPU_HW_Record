package npuBus.domain;

public class Application {
	int studentid;
	String busid;
	String carryon;
	String description;
	public Application(int studentid, String busid, String carryon, String description) {
		this.studentid = studentid;
		this.busid = busid;
		this.carryon = carryon;
		this.description = description;
	}
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getBusid() {
		return busid;
	}
	public void setBusid(String busid) {
		this.busid = busid;
	}
	public String getCarryon() {
		return carryon;
	}
	public void setCarryon(String carryon) {
		this.carryon = carryon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Application [studentid=" + studentid + ", busid=" + busid + ", carryon=" + carryon + ", description="
				+ description + "]";
	}
	@Override
	public boolean equals(Object obj){
		 if (obj == null||this.getStudentid()==0) {
		        return false;
		    }
		    if (!Application.class.isAssignableFrom(obj.getClass())) {
		        return false;
		    }
		    final Application other = (Application) obj;
		    if(this.getStudentid()!=(other.getStudentid()))
		    	return false;
		    return true;
		
	}
	
}
