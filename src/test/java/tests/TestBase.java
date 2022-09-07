package tests;

import endpointMethods.CreateAuth;
import endpointMethods.HealthCheck;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class TestBase {

    @Before
    public void healthCheckBeforeTesting() {
        Response response = HealthCheck.ping();
        Assert.assertEquals(SC_CREATED, response.getStatusCode());

    }
    @Before
    public void checkCreateTokenBeforeTesting() {
        Response response = CreateAuth.createAuthRequest();
        Assert.assertEquals(SC_OK, response.getStatusCode());

    }


}
