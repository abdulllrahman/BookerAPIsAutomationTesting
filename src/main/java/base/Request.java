package base;
import com.sun.net.httpserver.Headers;
import io.restassured.response.Response;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Request {


    public static Response SendGetRequest(String URL) {
      return given().get(URL);


    }


    public static io.restassured.response.Response SendGetRequestWithParameters(String URL, HashMap<String, String> params) {
       return given().queryParams(params).get(URL);
    }


    public static io.restassured.response.Response SendGetRequestHeader(String URL, Headers headers) {
        return given().headers(headers).get(URL);

    }


    public static Response SendPostRequestWithBodyAndHeaders(String URL, Object Body, Headers headers) {
         return given().headers(headers).body(Body).when().post(URL);

    }


    public static Response SendPutRequestWithBodyAndHeaders(String URL, Object Body, Headers headers) {
        return given().headers(headers).body(Body).when().put(URL);

    }

    public static Response SendPatchRequestWithBodyAndHeaders(String URL, Object Body, Headers headers) {
        return given().headers(headers).body(Body).when().patch(URL);

    }

    public static Response SendDeleteRequestWithBodyAndHeaders(String URL, Object Body, Headers headers) {
        return given().headers(headers).body(Body).when().delete(URL);

    }

}
