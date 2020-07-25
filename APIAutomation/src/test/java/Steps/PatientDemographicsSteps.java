package Steps;

import java.util.List;

import Requests.PDGRequests;
import ResponseModel.PDGResponse;
import Responses.PDGResponses;
import Routes.PDGRoutes;
import Utils.IRestResponse;
import Utils.RestResponse;
import cucumber.Context;
import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PatientDemographicsSteps extends BaseStep{
	
	public PatientDemographicsSteps(TestContext testContext) {
		super(testContext);
		
	}
	
	public IRestResponse<PDGResponses> pdgResponse;
	
	public PDGResponse reponseobject;
	
	public Response response = null;
	@Given("^I generate token for Authorization$")
	public void i_generate_token_for_Authorization() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^User sends Get Request for PatientDemoGraphics$")
	public void user_sends_Get_request() throws Throwable {
		pdgResponse = getpdgRequests().getDemoGraphics();
		
		getScenarioContext().setContext(Context.PDGRESPONSE, pdgResponse);
	}

	@When("^User extracts the responsebody from response$")
	public void user_gets_the_responsebody() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		
		IRestResponse<PDGResponses> respobj =  (IRestResponse<PDGResponses>) getScenarioContext().getContext(Context.PDGRESPONSE);
		
		System.out.println(respobj.getBody().pdgResponses.get(0));
		
	}

	@SuppressWarnings("deprecation")
	@Then("^Verify the statuscode is '(\\d+)'$")
	public void verify_the_statuscode_is_OK(int expectedStatusCode) throws Throwable {
	    
		int actualStatusCode = pdgResponse.getStatusCode();
		
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
		
		
	}

	@Given("^User sends Post request$")
	public void userSendsPostRequest() throws Throwable {
		
		pdgResponse = getpdgRequests().postDemoGraphics("1222345", "MR", "saik", "kirank", "Vy", "A", "M", "1993-06-13T18:30:00.000Z", "English", "English", "123442433");	
		
	}

	@When("^User extracts the response body from response$")
	public void userExtractsTheResponseBodyFromResponse() throws Throwable {
		
		
		
		System.out.println("The response body for get request is  "+pdgResponse.getBody());
	}

	@When("^User extracts the firstname from response$")
	public void userExtractsTheFirstnameFromResponse() throws Throwable {
		System.out.println("The firstname is  "+pdgResponse.getBody());
	}


}