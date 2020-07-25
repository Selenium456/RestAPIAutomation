package Utils;

import java.util.List;

import io.restassured.response.Response;

public interface IRestResponse<T> {
	
	 public T getBody();
	 
	
	 
	 public String getContent();
	 
	 public int getStatusCode();
	 
	 public boolean isSuccessful();
	 
	 public String getStatusDescription();
	 
	 public Response getResponse();
	 
	 public Exception getException();


}
