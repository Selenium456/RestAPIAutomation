package Requests;

import java.io.IOException;

import org.json.simple.JSONObject;

import RequestModels.PatientDemoGraphicsModel;
import ResponseModel.PDGResponse;

import Routes.PDGRoutes;
import Utils.ConfigReader;
import Utils.IRestResponse;
import Utils.RestResponse;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PDGRequests {

	private String BaseURI = null;

	public PDGRoutes pdgRoutes;

	public PDGRequests(String baseuri) {
		this.BaseURI = baseuri;
		pdgRoutes = new PDGRoutes();
	}

	public IRestResponse<PDGResponse> getDemoGraphics() throws IOException {

		RestAssured.baseURI = BaseURI;

		RequestSpecification request = RestAssured.given();

		Response response = request.request(Method.GET, pdgRoutes.demographics());

		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

	public IRestResponse<PDGResponse> postDemoGraphics(String patientId, String namePrefix, String lastName,
			String firstName, String middleName, String nameSuffix, String gender, String dob,
			String preferredOfficialLanguage, String preferredSpokenLanguage, String sin, String createdBy)
			throws IOException {

		PatientDemoGraphicsModel pdgModel = new PatientDemoGraphicsModel(patientId, namePrefix, lastName, firstName,
				middleName, nameSuffix, gender, dob, preferredOfficialLanguage, preferredSpokenLanguage, sin,
				createdBy);
		RestAssured.baseURI = BaseURI;
		;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.body(pdgModel);

		Response response = request.request(Method.POST, pdgRoutes.create());

		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

	public IRestResponse<PDGResponse> postDemoGraphics(JSONObject jsonobject) throws IOException {

		// PatientDemoGraphicsModel pdgModel = new
		// PatientDemoGraphicsModel(patientId,namePrefix,lastName,firstName,middleName,nameSuffix,gender,dob,preferredOfficialLanguage,preferredSpokenLanguage,sin,createdBy);
		RestAssured.baseURI = BaseURI;
		;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.body(jsonobject);
		Response response = request.request(Method.POST, pdgRoutes.create());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

	public IRestResponse<PDGResponse> UpdateDemoGraphics(JSONObject jsonobject) throws IOException {

		// PatientDemoGraphicsModel pdgModel = new
		// PatientDemoGraphicsModel(patientId,namePrefix,lastName,firstName,middleName,nameSuffix,gender,dob,preferredOfficialLanguage,preferredSpokenLanguage,sin,createdBy);
		RestAssured.baseURI = BaseURI;
		;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.body(jsonobject);
		Response response = request.request(Method.PUT, pdgRoutes.update());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

	public IRestResponse<PDGResponse> getAllGender() throws IOException {

		// PatientDemoGraphicsModel pdgModel = new
		// PatientDemoGraphicsModel(patientId,namePrefix,lastName,firstName,middleName,nameSuffix,gender,dob,preferredOfficialLanguage,preferredSpokenLanguage,sin,createdBy);
		RestAssured.baseURI = BaseURI;
		;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		Response response = request.request(Method.GET, pdgRoutes.getGender());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

	public IRestResponse<PDGResponse> getAllNamePrefix() throws IOException {

		// PatientDemoGraphicsModel pdgModel = new
		// PatientDemoGraphicsModel(patientId,namePrefix,lastName,firstName,middleName,nameSuffix,gender,dob,preferredOfficialLanguage,preferredSpokenLanguage,sin,createdBy);
		RestAssured.baseURI = BaseURI;
		;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		Response response = request.request(Method.GET, pdgRoutes.getNamePrefix());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

	public IRestResponse<PDGResponse> getAllNameSuffix() throws IOException {

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		Response response = request.request(Method.GET, pdgRoutes.getNameSuffux());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}
	
	public IRestResponse<PDGResponse> getAllOfficialLanguage() throws IOException {

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		Response response = request.request(Method.GET, pdgRoutes.getOfficialLanguage());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}
	
	public IRestResponse<PDGResponse> getAllPatientDemographicslist() throws IOException {

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		Response response = request.request(Method.GET, pdgRoutes.getPatientDemographicsList());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}
	
	public IRestResponse<PDGResponse> DeletePatientDemoGraphics(String patientId) throws IOException {

		RestAssured.baseURI = BaseURI;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.queryParam("patientId", patientId);
		Response response = request.request(Method.DELETE, pdgRoutes.delete());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

	public IRestResponse<PDGResponse> getPatientDemographicsByid(String patientId) throws IOException {

		// PatientDemoGraphicsModel pdgModel = new
		// PatientDemoGraphicsModel(patientId,namePrefix,lastName,firstName,middleName,nameSuffix,gender,dob,preferredOfficialLanguage,preferredSpokenLanguage,sin,createdBy);
		RestAssured.baseURI = BaseURI;
		;
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.queryParam("patientId", patientId);
		Response response = request.request(Method.GET, pdgRoutes.getPDGID());
		return new RestResponse<PDGResponse>(PDGResponse.class, response);

	}

}
