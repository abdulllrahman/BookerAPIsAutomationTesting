package endpointMethods;

import base.Request;
import models.BookingResponsePayload;
import utilities.helpers;

import static utilities.endpoints.BookingURL;

public class GetBookingIds {

    public static io.restassured.response.Response GetAllBookingIdsResponse() {
        return Request.SendGetRequest(BookingURL);

    }

    public static BookingResponsePayload[] GetAllBookingIds() {

        io.restassured.response.Response response = Request.SendGetRequest(BookingURL);
        return response.as(BookingResponsePayload[].class);
    }


    public static BookingResponsePayload[] GetBookingIdsFilterByName(String firstName, String lastName) {

        io.restassured.response.Response response =
                Request.SendGetRequestWithParameters(BookingURL, helpers.createFilterByNameQueryParams(firstName,lastName));
        return response.as(BookingResponsePayload[].class);
    }

    public static BookingResponsePayload[] GetBookingIdsFilterByCheckIn(String checkin) {

        io.restassured.response.Response response = Request
                .SendGetRequestWithParameters(BookingURL, helpers.createFilterByCheckInQueryParams(checkin));
        return response.as(BookingResponsePayload[].class);
    }

    public static BookingResponsePayload[] GetBookingIdsFilterByBookingDate(String checkin, String checkout) {

        io.restassured.response.Response response = Request
                .SendGetRequestWithParameters(BookingURL, helpers.createFilterByBookingDateQueryParams(checkin,checkout));
        return response.as(BookingResponsePayload[].class);
    }
}
