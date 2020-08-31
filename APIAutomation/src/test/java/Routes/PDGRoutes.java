package Routes;

public class PDGRoutes {
	
	private  final String demographics = "/demographics";
	
	private  final String update = "/update";
	
	private  final String create = "/create";
	
	private  final String getPDGId = "/getDemographicsByPatientId";
	
	private  final String delete = "/delete";
	
	private  final String gender = "/gender"; 
	
	private  final String namePrefix = "/namePrefix"; 
	
	private  final String nameSuffix = "/nameSuffix";
	
	private final String officialLanguage = "/officialLanguage";
	
	private final String patientDemographicsList = "/patientDemographicsList";
	
	public  String demographics() {
		return demographics;
	}

	public  String update() {
		return demographics+update;
	}
	
	public  String create() {
		return demographics+create;
	}
	
	public  String getPDGID() {
		return demographics+getPDGId;
	}
	
	public  String delete() {
		return demographics+delete;
	}
	
	public  String getGender() {
		return demographics+gender;
	}
	
	public  String getNamePrefix() {
		return demographics+namePrefix;
	}
	
	public  String getNameSuffux() {
		return demographics+nameSuffix;
	}
	
	public String getOfficialLanguage() {
		return demographics+officialLanguage;
	}
	
	public String getPatientDemographicsList() {
		return demographics+patientDemographicsList;
	}
}
