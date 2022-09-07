package endpointMethods;

import base.Request;
import io.restassured.response.Response;
import utilities.helpers;

import static utilities.endpoints.BookingURL;

public class DeleteBooking {

    //"DeleteBooking" endpoint - returns whole response
    public static Response DeleteBuookingReturnsWholeResponse(String id,String token) {
        return Request.SendDeleteRequestWithBodyAndHeaders
                (BookingURL+id, helpers.createBookingRequestPayload(), helpers.UpdateBookingAPIHeaders(token));
    }


}
