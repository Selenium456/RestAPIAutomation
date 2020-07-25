package Requests;

import java.io.IOException;

import RequestModels.PatientDemoGraphicsModel;
import ResponseModel.PDGResponse;
import Responses.PDGResponses;
import Routes.PDGRoutes;
import Utils.ConfigReader;
import Utils.IRestResponse;
import Utils.RestResponse;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PDGRequests {
	
	private  String BaseURI = null;
	
	public PDGRequests(String baseuri) {
		this.BaseURI = baseuri;
	}
	
	
	
	
	public  IRestResponse<PDGResponses> getDemoGraphics() throws IOException {
		
		
		RestAssured.baseURI = BaseURI;
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.request(Method.GET,PDGRoutes.demographics());
		
		return new RestResponse<PDGResponses>(PDGResponses.class,response);
		
	}
	
public IRestResponse<PDGResponses> postDemoGraphics(String patientId, String namePrefix, String lastName, String firstName, String middleName, String nameSuffix, String gender, String dob, String preferredOfficialLanguage, String preferredSpokenLanguage, String sin) throws IOException {
	
		PatientDemoGraphicsModel pdgModel = new PatientDemoGraphicsModel(patientId,namePrefix,lastName,firstName,middleName,nameSuffix,gender,dob,preferredOfficialLanguage,preferredSpokenLanguage,sin);
		
		
		RestAssured.baseURI = BaseURI;;
		
		RequestSpecification request = RestAssured.given();
		request.contentType("application/json");
		request.body(pdgModel);
		
		Response response = request.request(Method.POST,PDGRoutes.create());
		
		return new RestResponse<PDGResponses>(PDGResponses.class,response);
		
	}
	
	
	

}
