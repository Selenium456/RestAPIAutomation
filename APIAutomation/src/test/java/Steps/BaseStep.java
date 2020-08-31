package Steps;

import java.io.IOException;

import org.json.simple.JSONObject;

import Requests.PDGRequests;
import Utils.ReadJson;
import cucumber.ScenarioContext;
import cucumber.TestContext;
import io.restassured.response.Response;


public class BaseStep {
	
	private PDGRequests pdgRequests;
	private ScenarioContext scenarioContext;
	private ReadJson readJson;
	private JSONObject jsonBody;

	private Response response ;
	
	public BaseStep(TestContext testContext) throws IOException {
		
		pdgRequests = testContext.getPDGRequests();
		scenarioContext = testContext.getScenarioContext();
		readJson = testContext.getReadJson();
		jsonBody = new JSONObject();
		
	}
	
	
	
	public PDGRequests getpdgRequests() {
		return pdgRequests;
	}
	
	 public ScenarioContext getScenarioContext() {
	        return scenarioContext;
	    }
	 
	 public ReadJson getReadJson() {
		 return readJson;
	 }
	 
	 public Response getResponseObject() {
		 return response;
	 }
	 
	 public JSONObject getJsonObject() {
		 return jsonBody;
	 }

}
