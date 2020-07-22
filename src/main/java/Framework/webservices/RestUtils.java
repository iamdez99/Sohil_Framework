package Framework.webservices;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestUtils extends CommonMethods {
	private final static Logger log = LoggerFactory.getLogger(RestUtils.class);
	/**
	 * @author Diego Juarez
	 * @param map<String, Object>
	 * @return JSONObject
	 * 
	 * Use this to create JSONObject for Request Body
	 * 
	 */
	
	public static  JSONObject createJSONObject(Map <String, String> map) {
		JSONObject object = new JSONObject(map);
		log.info("JSON Object ::: " + object.toString());
		return object;
	}
	
	/**
	 * @author Diego Juarez
	 * @param map<String, Object>
	 * @return JSONObject
	 * 
	 * Use this to create JSONObject for Request Body
	 * 
	 */
	public static JSONArray createJSONArray (List<Map<String,String>> list) {
		JSONArray object = new JSONArray(list);
		log.info("JSON Array ::: " + object.toString());
		return object;
	}
	
	/**
	 * This Method is To Create request with a header
	 * @author Diego Juarez
	 * @param String contentType 
	 * @param Map<String, String> header 
	 * @return RequestSpecBuilder
	 * 
	 */
	public static RequestSpecBuilder createRequest (ContentType contentType) {
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder(); 
		requestBuilder.setContentType(contentType);
		return requestBuilder; 
		
	}
	
	/**
	 * This Method is To Create request with a header
	 * @author Diego Juarez
	 * @param String contentType 
	 * @param Map<String, String> header 
	 * @return RequestSpecBuilder
	 * 
	 */
	public static RequestSpecBuilder createRequest (ContentType contentType, Map<String, String> header) {
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder(); 
		requestBuilder.setContentType(contentType);
		if (!header.isEmpty()) 
			requestBuilder.addHeaders(header);
		else 
			throw new RuntimeException("Header is Empty Execution Fail");
		return requestBuilder; 
		
	}

	/**
	 * This Method is to create request with a header and parameter
	 * @author Diego Juarez
	 * @param String contentType 
	 * @param Map<String, String> header 
	 * @param Map<String, String> parameter 
	 * @return RequestSpecBuilder
	 * 
	 */
	
	public static RequestSpecBuilder createRequestWithParameter (String contentType,Map<String, String> header, Map<String,String> parameter) {
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder(); 
		requestBuilder.setContentType(contentType);
		//adding Parameters
		if (!parameter.isEmpty()) 
			for (String key: parameter.keySet()) {
				requestBuilder.addQueryParam(key, parameter.get(key));
			}
		else 
			throw new RuntimeException("Header is Empty Execution Fail");
		//Adding header
		if (!header.isEmpty()) 
			requestBuilder.addHeaders(header);
		else 
			throw new RuntimeException("Header is Empty Execution Fail");
		return requestBuilder; 
		
	}
	
	
	/**
	 * This Method to send a get request to any endPoint
	 * 
	 * @author Diego Juarez
	 * @param RequestSpecBuilder request
	 * @param String endPoint
	 * @return Response
	 */
	
	public static Response sendGetRequest(RequestSpecBuilder request, String endPoint) {
		Response response = null; 
		log.info("Send get request ::: " + endPoint );
		log.info("Request Body ::: " + request.log(LogDetail.BODY));
		log.info("Request Headers ::: " + request.log(LogDetail.HEADERS));
		if (request != null && !endPoint.isEmpty()) {
			request.setBaseUri(endPoint);
			log.info("Request URI ::: " + request.log(LogDetail.URI));
			response = given().spec(request.build()).relaxedHTTPSValidation().when().get();
		}
		log.info("Get request send" );
		log.info("Response ::: " + response.asString());
		return response; 
	}
	
	
	/**
	 * This Method to send a post request to any endPoint
	 * 
	 * @author Diego Juarez
	 * @param RequestSpecBuilder request
	 * @param String endPoint
	 * @return Response
	 */
	
	public static Response sendPostRequest(RequestSpecBuilder request, String endPoint) {
		Response response = null; 
		log.info("Request Body ::: " + request.log(LogDetail.BODY));
		log.info("Request Headers ::: " + request.log(LogDetail.HEADERS));
		//System.out.println(request.log(LogDetail.BODY));
		log.info("Send post request ::: " + endPoint );
		if (request != null && !endPoint.isEmpty()) {
			request.setBaseUri(endPoint);
			log.info("Request URI ::: " + request.log(LogDetail.URI));
			response = given().spec(request.build()).relaxedHTTPSValidation().when().post();
		}
		
		log.info("Post request send" );
		log.info("Response ::: " + response.asString());
		return response; 
	}
	
	

}
