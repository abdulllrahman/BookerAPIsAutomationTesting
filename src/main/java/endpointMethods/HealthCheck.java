package endpointMethods;

import io.restassured.response.Response;

import static base.Request.SendGetRequest;
import static utilities.endpoints.PingURL;

public class HealthCheck {

    public static Response ping() {
        return SendGetRequest(PingURL);
    }
}

