package endpointMethods;

import base.Request;
import io.restassured.response.Response;
import models.BookingPayload;
import models.BookingResponsePayload;
import utilities.helpers;

import static utilities.endpoints.BookingURL;

public class CreateBooking {

    //"CreateBooking" endpoint - returns whole response
    public static Response CreateBooking() {

        return Request.SendPostRequestWithBodyAndHeaders
                (BookingURL, helpers.createBookingRequestPayload(), helpers.createBookingAPIHeaders());
    }


    //"CreateBooking" endpoint - returns response data
    public static BookingResponsePayload CreateBooking(BookingPayload NewlyCreatedBooking) {

        Response response= Request.SendPostRequestWithBodyAndHeaders
                (BookingURL, NewlyCreatedBooking, helpers.createBookingAPIHeaders());
        return response.as(BookingResponsePayload.class);

    }


}
