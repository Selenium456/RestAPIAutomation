package cucumber;

import java.io.IOException;

import Requests.PDGRequests;
import Utils.ConfigReader;
import Utils.ReadJson;

public class TestContext {

	private PDGRequests pdgRequests;
	private ScenarioContext scenarioContext;
	private ReadJson readJson;

	public ConfigReader configread = null;

	public TestContext() throws IOException {

		scenarioContext = new ScenarioContext();
		configread = new ConfigReader();
		configread.LoadConfigFile();
		pdgRequests = new PDGRequests(configread.getURI());
		readJson = new ReadJson(configread.getJsonPath());

	}

	public PDGRequests getPDGRequests() throws IOException {
		
		return pdgRequests;
	}

	public ReadJson getReadJson() {

		return readJson;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
