package Utils;



import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class RestResponse<T> implements IRestResponse<T> {
	private T data;
	
	 private Response response;
	 private Exception e;
	 public ObjectMapper objectmapper;
	
	 public RestResponse(Class<T> t, Response response) {
		 this.response = response;
		 try{
		 this.data = t.newInstance();
		 objectmapper = new ObjectMapper();
		 }catch (Exception e){
		 throw new RuntimeException("There should be a default constructor in the Response POJO");
		 }
		 }

	
	@SuppressWarnings("unchecked")
	@Override
	public T getBody(JSONObject object) throws Exception, JsonProcessingException {
		
		String response = object.toJSONString();
		
		return  (T) objectmapper.readValue(response, data.getClass());

	}
	


	@Override
	public String getContent() {
		return response.getBody().asString();
	}

	@Override
	public int getStatusCode() {
		return response.getStatusCode();
	}

	@Override
	public boolean isSuccessful() {
		int code = response.getStatusCode();
		 if( code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205) return true;
		 return false;
	}

	@Override
	public String getStatusDescription() {
		return response.getStatusLine();
	}

	@Override
	public Response getResponse() {
		return response;
	}

	@Override
	public Exception getException() {
		return e;
	}

	

	

	

}
