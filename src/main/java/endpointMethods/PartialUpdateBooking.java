package endpointMethods;

import base.Request;
import io.restassured.response.Response;
import models.BookingPayload;
import utilities.helpers;

import static utilities.endpoints.BookingURL;
import static utilities.helpers.InvalidBookingId;

public class PartialUpdateBooking {


   //"UpdateBooking" endpoint - returns whole response
    public static Response PartialUpdateBooking(String id,String token) {

        return Request.SendPatchRequestWithBodyAndHeaders
                (BookingURL+id, helpers.partialUpdateBookingRequestPayload() , helpers.UpdateBookingAPIHeaders(token));
    }

    public static Response PartialUpdateBooking(String id, String token, BookingPayload parialUpdatedBooking) {

        return Request.SendPatchRequestWithBodyAndHeaders
                (BookingURL+id, parialUpdatedBooking , helpers.UpdateBookingAPIHeaders(token));
    }

    public static Response PartialUpdateBookingInCaseWrongBookingID(String id,String token) {

        return Request.SendPatchRequestWithBodyAndHeaders
                (BookingURL+InvalidBookingId, helpers.partialUpdateBookingRequestPayload() , helpers.UpdateBookingAPIHeaders(token));
    }
}
