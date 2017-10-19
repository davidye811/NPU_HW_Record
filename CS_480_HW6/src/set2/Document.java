package set2;

public class Document {
	int licenseNumber;
	boolean dateOfExpiration;
	public Document() {
		this.licenseNumber=0;
		this.dateOfExpiration=true;
	}
	public Document(int licenseNumber, boolean dateOfExpiration) {
		this();
		this.licenseNumber = licenseNumber;
		this.dateOfExpiration = dateOfExpiration;
	}
	
	public int getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(int licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public boolean isDateOfExpiration() {
		return dateOfExpiration;
	}
	public void setDateOfExpiration(boolean dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}
	@Override
	public String toString() {
		return "Document [licenseNumber=" + licenseNumber + ", dateOfExpiration=" + dateOfExpiration + "]";
	}
	
}
