package utilities;

public class endpoints {
    public static final String AuthAPI = "auth/";
    public static final String BookingAPI = "booking/";
    public static final String PingAPI = "ping/";
    public static final String PingURL = helpers.LoadEnvironmentURL.getProperty("TestingEnvironmentURL")+ PingAPI;

    public static final String BookingURL = helpers.LoadEnvironmentURL.getProperty("TestingEnvironmentURL")+ BookingAPI;

    public static final String AuthURL = helpers.LoadEnvironmentURL.getProperty("TestingEnvironmentURL")+ AuthAPI;


}
