package tests;

import models.BookingPayload;
import models.BookingResponsePayload;
import org.junit.Assert;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;

public class GetBookingTests extends TestBase {

    //Testing "Get Booking" endpoint - Status Code
    @Test
    public void CheckGetBookingAPIStatusCode200() {

        //Get Existing Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //Get Booking
        io.restassured.response.Response response= endpointMethods.GetBooking
                        .GetBookingByIdReturnsWholeResponse(RandomExistingBookingIds[0].getBookingid().toString());

        //Verify Status Code
        Assert.assertEquals(SC_OK,response.getStatusCode());

    }


    //Testing "Get Booking" endpoint - Response Data
    @Test
    public void CheckGetBookingAPIResponseData() {

        //Get Existing Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=
                endpointMethods.GetBookingIds.GetAllBookingIds();

        //Get Booking
        BookingPayload BookingDetails= endpointMethods.GetBooking
                .GetBookingById(RandomExistingBookingIds[0].getBookingid().toString());

        //verify that GetBooking returns not empty object
        Assert.assertNotNull(BookingDetails);
    }
}
