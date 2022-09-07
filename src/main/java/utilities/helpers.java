package utilities;

import com.github.javafaker.Faker;
import com.sun.net.httpserver.Headers;
import models.BookingPayload;
import models.Bookingdates;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class helpers {

    //to create random booking data using "faker"
    protected static final Faker RandomData = new Faker();

    public static final String InvalidBookingId="3333333333333300000";

    //load a specific environment url from properity file like testing environment url
    public static Properties LoadEnvironmentURL =
            loadEnvURLfromProperties(System.getProperty("user.dir")+"\\Config\\Environment.properties");
    static Headers ValidHeaders;


    public static BookingPayload createBookingRequestPayload() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdfDate.format(new Date());
        return new BookingPayload(
                RandomData.name().firstName(),
                RandomData.name().lastName(),
                RandomData.number().numberBetween(100, 500),
                true,
                new Bookingdates(currentDate,currentDate),
                "None");
    }

    public static BookingPayload partialUpdateBookingRequestPayload() {
        return new BookingPayload(
                RandomData.name().firstName(),
                RandomData.name().lastName(),
                RandomData.number().numberBetween(100, 500));
    }


    public static HashMap<String,String> createFilterByNameQueryParams(String firstName,String lastName) {
       return new HashMap<String, String>() {{
            put("firstname", firstName);
            put("lastname", lastName);
        }};
    }
    public static HashMap<String,String> createFilterByCheckInQueryParams(String checkin) {
        return new HashMap<String, String>() {{
            put("checkin", checkin);
        }};
    }

    public static HashMap<String,String> createFilterByBookingDateQueryParams(String checkin, String checkout) {
        return new HashMap<String, String>() {{
            put("checkin", checkin);
            put("checkout", checkout);
        }};
    }


    public static Headers createBookingAPIHeaders()
    {
        ValidHeaders = new Headers();
        ValidHeaders.add("Accept", "application/json");
        ValidHeaders.add("Content-Type", "application/json");
        return ValidHeaders;
    }


    public static Headers UpdateBookingAPIHeaders(String token)
    {
        ValidHeaders = new Headers();
        ValidHeaders.add("Accept", "application/json");
        ValidHeaders.add("Content-Type","application/json");
        ValidHeaders.add("Cookie", "token="+token);
        return ValidHeaders;
    }

    //Create Headers
    public static Headers createTokenAPIHeaders()
    {
        ValidHeaders = new Headers();
        ValidHeaders.add("Accept", "application/json");
        ValidHeaders.add("Content-Type", "application/json");
        return ValidHeaders;
    }

    private static Properties loadEnvURLfromProperties(String path)
    {
        Properties pro = new Properties();
        // stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }

        return pro;
    }






}

