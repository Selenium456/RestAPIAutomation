package Routes;

public class PDGRoutes {
	
	private static final String demographics = "/demographics";
	
	private static final String update = "/update";
	
	private static final String create = "/create";
	
	private static final String getPDGId = "/getByPatientDemographicsId";
	
	private static final String delete = "/delete";
	
	public static String demographics() {
		return demographics;
	}

	public static String update() {
		return demographics+update;
	}
	
	public static String create() {
		return demographics+create;
	}
	
	public static String getPDGID() {
		return demographics+getPDGId;
	}
	
	public static String delete() {
		return demographics+delete;
	}
}
