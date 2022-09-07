package endpointMethods;

import base.Request;
import io.restassured.response.Response;
import models.BookingPayload;
import utilities.helpers;

import static utilities.endpoints.BookingURL;
import static utilities.helpers.InvalidBookingId;

public class UpdateBooking {


    public static Response updateBooking(String id,String token) {
        return Request.SendPutRequestWithBodyAndHeaders
                (BookingURL+id, helpers.createBookingRequestPayload(), helpers.UpdateBookingAPIHeaders(token));
    }

    public static Response updateBooking(String id, String token, BookingPayload updatedBooking) {
        return Request.SendPutRequestWithBodyAndHeaders
                (BookingURL+id, updatedBooking, helpers.UpdateBookingAPIHeaders(token));
    }

    public static Response updateBookingWithWrongBookingId(String id, String token) {
        return Request.SendPutRequestWithBodyAndHeaders
                (BookingURL+InvalidBookingId, helpers.createBookingRequestPayload(), helpers.UpdateBookingAPIHeaders(token));
    }



}
