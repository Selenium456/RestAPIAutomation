package RequestModels;

public class PatientDemoGraphicsModel {
	
	public String patientId;
	public String namePrefix;
	public String lastName;
	public String firstName;
	public String middleName;
	public String nameSuffix;
	public String gender;
	public String dob;
	public String preferredOfficialLanguage;
	public String preferredSpokenLanguage;
	public String sin;
	public String createdby;
	
	
	public PatientDemoGraphicsModel(String patientId, String namePrefix, String lastName, String firstName, String middleName, String nameSuffix, String gender, String dob, String preferredOfficialLanguage, String preferredSpokenLanguage, String sin,String createdBy) {
		
		this.patientId = patientId;
		this.namePrefix = namePrefix;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.nameSuffix = nameSuffix;
		this.gender = gender;
		this.dob = dob;
		this.preferredOfficialLanguage = preferredOfficialLanguage;
		this.preferredSpokenLanguage = preferredSpokenLanguage;
		this.sin = sin;
		this.createdby = createdBy;
		
		}

}
