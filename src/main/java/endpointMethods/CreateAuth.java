package endpointMethods;

import base.Request;
import io.restassured.response.Response;
import models.AuthRequest;
import models.AuthResponse;
import utilities.endpoints;
import utilities.helpers;

public class CreateAuth {

    static AuthRequest createAuthPayload() {
        return new AuthRequest("admin","password123");
    }

    //"Auth" endpoint - returns token
    public static String GetToken() {

        Response response= Request.SendPostRequestWithBodyAndHeaders
                (endpoints.AuthURL,createAuthPayload(), helpers.createTokenAPIHeaders());
           AuthResponse token = response.as(AuthResponse.class);
           return token.getToken();

    }

    public static Response createAuthRequest() {

     return Request.SendPostRequestWithBodyAndHeaders
                (endpoints.AuthURL,createAuthPayload(), helpers.createTokenAPIHeaders());



    }




}
