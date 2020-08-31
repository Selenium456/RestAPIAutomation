package Steps;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import ResponseModel.PDGResponse;
import Utils.IRestResponse;
import cucumber.Context;
import cucumber.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Assert;

public class PatientDemographicsSteps extends BaseStep {

	public PatientDemographicsSteps(TestContext testContext) throws IOException {
		super(testContext);

	}

	public IRestResponse<PDGResponse> pdgResponse;

	/*
	 * @Before public void BeforeScenario() {
	 * Reporter.assignAuthor("Kiran Ayyagari"); }
	 */

	/*
	 * @Given("^I generate token for Authorization$") public void
	 * i_generate_token_for_Authorization() throws Throwable { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * PendingException(); }
	 */

	@Given("^User sends Get Request for PatientDemoGraphics$")
	public void user_sends_Get_request() throws Throwable {
		pdgResponse = getpdgRequests().getDemoGraphics();

	}

	@When("^User extracts the responsebody from response$")
	public void user_gets_the_responsebody() throws Throwable {

		String response = pdgResponse.getResponse().prettyPrint();

		System.out.println(response);

		getScenarioContext().setContext(Context.RESPONSE, response);

	}

	@Then("^Verify the statuscode is '(\\d+)'$")
	public void verify_the_statuscode_is_OK(int expectedStatusCode) throws Throwable {

		int actualStatusCode = pdgResponse.getStatusCode();

		Assert.assertEquals(expectedStatusCode, actualStatusCode);

	}

	@Given("^User sends Post Request for PatientDemoGraphics$")
	public void userSendsPostRequest() throws Throwable {
		JSONObject jsonobject = getJsonObject();
		jsonobject = getReadJson().readFile("Post", "PatientDemographics");
		pdgResponse = getpdgRequests().postDemoGraphics(jsonobject);
	}

	@When("^User extracts the responseheader$")
	public void userExtractsTheResponseheader() throws Throwable {

		Headers responseHeader = pdgResponse.getResponse().getHeaders();

		getScenarioContext().setContext(Context.RESPONSEHEADER, responseHeader);
	}

	@And("^Verify the \"([^\"]*)\" in response header is \"([^\"]*)\"$")
	public void verifyTheInResponseHeaderIs(String contenttype, String expectedheadervalue) throws Throwable {

		Headers responseheaders = (Headers) getScenarioContext().getContext(Context.RESPONSEHEADER);

		String actualheaderValue = responseheaders.getValue(contenttype);

		Assert.assertEquals(expectedheadervalue, actualheaderValue);

	}

	@When("^User extracts the responsebody$")
	public void userExtractsTheResponsebody() throws Throwable {
		String actualResponse = pdgResponse.getContent();
		
		getScenarioContext().setContext("actualresponse", actualResponse);
		
		
		
	}

	@Given("^User sends PUT Request for PatientDemoGraphics$")
	public void userSendsPUTRequestForPatientDemoGraphics() throws Throwable {
		JSONObject jsonObject = getJsonObject();
		jsonObject = getReadJson().readFile("PUT", "PatientDemographics");
		pdgResponse = getpdgRequests().UpdateDemoGraphics(jsonObject);
		getScenarioContext().setContext(Context.REQUESTBODY, jsonObject);

	}

	@Then("^Verify the SIN number is updated$")
	public void verifyTheSINNumberIsUpdated() throws Throwable {
		JSONObject jsonObject = getJsonObject();
		jsonObject = (JSONObject) getScenarioContext().getContext(Context.REQUESTBODY);

		String expectedSIN = getReadJson().getItem(jsonObject, "sin");

		String actualResponsebody = getScenarioContext().getContext("actualresponse").toString();

		JSONObject actualSINJsonObject = (JSONObject) JSONValue.parse(actualResponsebody);

		JSONObject responseSINObject = getReadJson().getItem("response", actualSINJsonObject);

		String actualSin = pdgResponse.getBody(responseSINObject).getSin();

		Assert.assertEquals(expectedSIN, actualSin);

	}

	@Given("^User sends GetAll GenderRequest for PatientDemoGraphics$")
	public void userSendsGetAllGenderRequestForPatientDemoGraphics() throws Throwable {

		pdgResponse = getpdgRequests().getAllGender();

	}

	@Then("^Verify all Gender Types are present in responsebody$")
	public void verifyAllGenderTypesArePresentInResponsebody(DataTable table) throws Throwable {

		String expectedGenderData = getScenarioContext().getContext("GenderResponse").toString();

		boolean flag = false;

		List<Map<String, String>> genderData = table.asMaps(String.class, String.class);

		for (int i = 0; i < genderData.size(); i++) {

			if (expectedGenderData.contains(genderData.get(i).get("Gender"))
					&& expectedGenderData.contains(genderData.get(i).get("Genderdesc"))) {
				flag = true;
			}

			Assert.assertEquals(true, flag);
		}

	}

	@Given("^User sends Get Request to get patientdemographics by id$")
	public void userSendsGetRequestToGetPatientdemographicsById() throws Throwable {

		JSONObject jsonObject = getJsonObject();

		jsonObject = getReadJson().readFile("PUT", "PatientDemographics");

		String patientID = getReadJson().getItem(jsonObject, "patientId");

		pdgResponse = getpdgRequests().getPatientDemographicsByid(patientID);

		getScenarioContext().setContext("patientID", patientID);

	}

	@When("^User extracts the responsebody for requestedPatientID$")
	public void userExtractsTheResponsebodyForRequestedPatientID() throws Throwable {
		String expectedpatientID = (String) getScenarioContext().getContext("patientID");

		String actualResponsebody = pdgResponse.getContent();

		JSONObject actualPatientJsonObject = (JSONObject) JSONValue.parse(actualResponsebody);

		JSONObject responsePatientObject = getReadJson().getItem("response", actualPatientJsonObject);

		String actualPatientId = pdgResponse.getBody(responsePatientObject).getPatientId();

		Assert.assertEquals(expectedpatientID, actualPatientId);
	}

	@Given("^User sends getAllNamePrefix for PatientDemoGraphics$")
	public void userSendsGetAllNamePrefixForPatientDemoGraphics() throws Throwable {

		pdgResponse = getpdgRequests().getAllNamePrefix();

	}

	@When("^User extracts the namePrefix responsebody$")
	public void userExtractsTheNamePrefixResponsebody() throws Throwable {
		String namePrefixResponse = pdgResponse.getContent();

		getScenarioContext().setContext("NamePrefix", namePrefixResponse);
	}

	@Then("^Verify below Name prefix are present in responsebody$")
	public void verifyBelowNamePrefixArePresentInResponsebody(DataTable table) throws Throwable {

		String expectedGenderData = getScenarioContext().getContext("NamePrefix").toString();

		boolean flag = false;

		List<Map<String, String>> namePrefix = table.asMaps(String.class, String.class);

		for (int i = 0; i < namePrefix.size(); i++) {

			if (expectedGenderData.contains(namePrefix.get(i).get("namePrefixCode"))
					&& expectedGenderData.contains(namePrefix.get(i).get("namePrefixDesc"))) {
				flag = true;
			}

			Assert.assertEquals(true, flag);
		}

	}

	@Given("^User sends getAllNamesuffix for PatientDemoGraphics$")
	public void userSendsGetAllNameSuffixForPatientDemoGraphics() throws Throwable {

		pdgResponse = getpdgRequests().getAllNameSuffix();
	}

	@When("^User extracts the namesuffix responsebody$")
	public void userExtractsTheNameSuffixResponsebody() throws Throwable {
		String nameSuffixResponse = pdgResponse.getContent();

		getScenarioContext().setContext("NameSuffix", nameSuffixResponse);
	}

	@Then("^Verify below Name suffix are present in responsebody$")
	public void verifyBelowNameSuffixArePresentInResponsebody(DataTable table) throws Throwable {
		String expectedNameSuffixData = getScenarioContext().getContext("NameSuffix").toString();

		boolean flag = false;

		List<Map<String, String>> nameSufix = table.asMaps(String.class, String.class);

		for (int i = 0; i < nameSufix.size(); i++) {

			if (expectedNameSuffixData.contains(nameSufix.get(i).get("namesuffixCode"))
					&& expectedNameSuffixData.contains(nameSufix.get(i).get("namesuffixDesc"))) {
				flag = true;
			}

			Assert.assertEquals(true, flag);
		}
	}

	@Given("^User sends getAllOfficialLanguage request$")
	public void userSendsGetAllOfficialLanguageRequest() throws Throwable {

		pdgResponse = getpdgRequests().getAllOfficialLanguage();
	}

	@When("^User extracts the OfficialLanguage responsebody$")
	public void userExtractsTheOfficialLanguageResponsebody() throws Throwable {

		String officialLanguageResponse = pdgResponse.getContent();

		getScenarioContext().setContext("officialLanguage", officialLanguageResponse);

	}

	@Then("^Verify below Official Language are present in responsebody$")
	public void verifyBelowOfficialLanguageArePresentInResponsebody(DataTable table) throws Throwable {

		String expectedOfficialLanguage = getScenarioContext().getContext("officialLanguage").toString();

		boolean flag = false;

		List<Map<String, String>> officiallanguage = table.asMaps(String.class, String.class);

		for (int i = 0; i < officiallanguage.size(); i++) {

			if (expectedOfficialLanguage.contains(officiallanguage.get(i).get("officialLanguageCode"))
					&& expectedOfficialLanguage.contains(officiallanguage.get(i).get("officialLanguageDesc"))) {
				flag = true;
			}

			Assert.assertEquals(true, flag);
		}

	}

	@Given("^User sends getAllPatientDemographicsList request$")
	public void userSendsGetAllPatientDemographicsListRequest() throws Throwable {
		pdgResponse =  getpdgRequests().getAllPatientDemographicslist();
	}

	@When("^User extracts the getAllPatientDemographicsList responsebody$")
	public void userExtractsTheGetAllPatientDemographicsListResponsebody() throws Throwable {
		
		String patientdemographicslist = pdgResponse.getContent();
		Map<String, Object> demographicsMap = new HashMap<String,Object>();
		demographicsMap = getReadJson().readArrayJsonResponse(patientdemographicslist);
		
		String namePrefix = demographicsMap.get("namePrefix").toString();
		String nameSuffix = demographicsMap.get("nameSuffix").toString();
		String gender = demographicsMap.get("gender").toString();
		String officialLanguage = demographicsMap.get("officialLanguage").toString();
		
		getScenarioContext().setContext("NameSuffix", nameSuffix);
		getScenarioContext().setContext("officialLanguage", officialLanguage);
		getScenarioContext().setContext("NamePrefix", namePrefix);
		getScenarioContext().setContext("GenderResponse", gender);
		
	}

	@When("^User extracts the Gender responsebody$")
	public void userExtractsTheGenderResponsebody() throws Throwable {
		String genderResponse = pdgResponse.getContent();

		getScenarioContext().setContext("GenderResponse", genderResponse);
	}

	@Given("^User sends Delete Request for PatientDemoGraphics$")
	public void userSendsDeleteRequestForPatientDemoGraphics() throws Throwable {
		JSONObject jsonObject = getJsonObject();

		jsonObject = getReadJson().readFile("PUT", "PatientDemographics");

		String patientID = getReadJson().getItem(jsonObject, "patientId");
		pdgResponse =  getpdgRequests().DeletePatientDemoGraphics(patientID);
	}

	@And("^the response is null$")
	public void theResonseIsNull() throws Throwable {
		
		boolean flag = false;
		
		String actualResponse = getScenarioContext().getContext("actualresponse").toString();
		
		System.out.println("The actual delete reponse is "+actualResponse);
		try {
		if(getReadJson().readString(actualResponse, "response")==null) {
			flag = true;
		}
		
		Assert.assertTrue(flag);
		}
		catch(Exception E) {
			
		}
	}

}
