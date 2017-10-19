package npuBus.domain;

public class Student {
	String name;
	String gender;
	String Carryon;
	String Description;
	public Student(String name, String carryon, String description) {
		super();
		this.name = name;
		Carryon = carryon;
		Description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarryon() {
		return Carryon;
	}
	public void setCarryon(String carryon) {
		Carryon = carryon;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
