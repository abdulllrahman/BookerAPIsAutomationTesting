package endpointMethods;

import base.Request;
import com.sun.net.httpserver.Headers;
import io.restassured.response.Response;
import models.BookingPayload;

import static utilities.endpoints.BookingURL;

public class GetBooking {
    static Headers headers;

    //"GetBooking" endpoint - returns whole response

    public static Response GetBookingByIdReturnsWholeResponse(String Id) {

        headers = new Headers();
        headers.add("Accept", "application/json");

        return  Request.SendGetRequestHeader
                (BookingURL + Id, headers);

    }


    //Testing "get all bookingIds" endpoint - Without Filters
    public static BookingPayload GetBookingById(String Id) {
        headers= new Headers();
        headers.add("Accept","application/json");

        io.restassured.response.Response response = Request.SendGetRequestHeader
                (BookingURL+Id,headers);

      return response.as(BookingPayload.class);

}
}
