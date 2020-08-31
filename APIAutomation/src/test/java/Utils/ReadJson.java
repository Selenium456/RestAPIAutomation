package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ReadJson {

	public FileReader filereader;

	public ObjectMapper mapper;

	public Map<String, Object> requestTypeMap;

	public Map<String, Object> requestNameMap;
	
	public List<Map<String, Object>> responseMapList;

	public Map<String, Object> responseObject;

	public String jsonpath;

	public ReadJson(String Jsonpath) throws IOException {

		this.jsonpath = Jsonpath;
		mapper = new ObjectMapper();

	}

	@SuppressWarnings("unchecked")
	public JSONObject readFile(String requestType, String requestName) throws IOException {

		try {
			requestTypeMap = mapper.readValue(new File(jsonpath), new TypeReference<Map<String, Object>>() {
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		requestNameMap = (Map<String, Object>) requestTypeMap.get(requestType);
		Gson gson = new Gson();
		String jsonString = gson.toJson(requestNameMap.get(requestName), LinkedHashMap.class);

		JSONObject jsonobject = (JSONObject) JSONValue.parse(jsonString);

		return jsonobject;
	}
	
	public String readString(String reponse, String requestName) throws IOException {

		try {
			requestTypeMap = mapper.readValue(reponse, new TypeReference<Map<String, Object>>() {
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		String requiredResponse = requestTypeMap.get(requestName).toString();
		

		return requiredResponse;
	}

	public String getItem(JSONObject json, String Key) {

		return (String) json.get(Key).toString();

	}
	
	public JSONObject getItem( String Key,JSONObject json) {

		return (JSONObject) json.get(Key);

	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> readArrayJsonResponse(String reponse ) throws IOException {

		try {
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			responseMapList = mapper.readValue(reponse, new TypeReference<List<Map<String, Object>>>() {
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		responseObject = (Map<String, Object>) responseMapList.get(0);
		
		
			
		

		return responseObject;
	}
	
		

}
