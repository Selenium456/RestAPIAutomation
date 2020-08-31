package ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PDGResponse {
	
	private String patientId;
	private String namePrefix;
	private String lastName;
	private String firstName;
	private String middleName;
	private String nameSuffix;
	private String gender;
	private String dob;
	private String preferredOfficialLanguage;
	private String preferredSpokenLanguage;
	private String sin;
	
	
	


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getNamePrefix() {
		return namePrefix;
	}


	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getNameSuffix() {
		return nameSuffix;
	}


	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getPreferredOfficialLanguage() {
		return preferredOfficialLanguage;
	}


	public void setPreferredOfficialLanguage(String preferredOfficialLanguage) {
		this.preferredOfficialLanguage = preferredOfficialLanguage;
	}


	public String getPreferredSpokenLanguage() {
		return preferredSpokenLanguage;
	}


	public void setPreferredSpokenLanguage(String preferredSpokenLanguage) {
		this.preferredSpokenLanguage = preferredSpokenLanguage;
	}


	public String getSin() {
		return sin;
	}


	public void setSin(String sin) {
		this.sin = sin;
	}
	
	
	
	
	
}
