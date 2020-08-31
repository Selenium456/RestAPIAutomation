package Utils;



import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.response.Response;

public interface IRestResponse<T> {
	
	 public T getBody(JSONObject response) throws JsonMappingException, JsonProcessingException, Exception;
	 
	
	 
	 public String getContent();
	 
	 public int getStatusCode();
	 
	 public boolean isSuccessful();
	 
	 public String getStatusDescription();
	 
	 public Response getResponse();
	 
	 public Exception getException();


}
