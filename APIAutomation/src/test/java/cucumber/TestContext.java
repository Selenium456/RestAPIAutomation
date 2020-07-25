package cucumber;

import java.io.IOException;

import Requests.PDGRequests;
import Utils.ConfigReader;

public class TestContext {

	private PDGRequests pdgRequests;
	 private ScenarioContext scenarioContext;
	public ConfigReader configread = null;

	public TestContext() throws IOException {
		configread = new ConfigReader();
		configread.LoadConfigFile();
		pdgRequests = new PDGRequests(configread.getURI());
		scenarioContext = new ScenarioContext();
	}

	public PDGRequests getPDGRequests() {
		return pdgRequests;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
