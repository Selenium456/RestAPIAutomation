package Steps;

import Requests.PDGRequests;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class BaseStep {
	
	private PDGRequests pdgRequests;
	private ScenarioContext scenarioContext;
	
	public BaseStep(TestContext testContext) {
		
		pdgRequests = testContext.getPDGRequests();
		scenarioContext = testContext.getScenarioContext();
	}
	
	public PDGRequests getpdgRequests() {
		return pdgRequests;
	}
	
	 public ScenarioContext getScenarioContext() {
	        return scenarioContext;
	    }

}