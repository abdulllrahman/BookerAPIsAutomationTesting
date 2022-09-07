package tests;

import models.BookingResponsePayload;
import org.junit.Assert;
import org.junit.Test;
import static org.apache.http.HttpStatus.SC_CREATED;


public class DeleteBookingTests extends TestBase{

    String token=endpointMethods.CreateAuth.GetToken();

    //Verify Create Booking Status Code
    @Test
    public void CheckDeleteBookingAPIStatusCode201() {

        //Get Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //Create Booking
        io.restassured.response.Response response=endpointMethods.DeleteBooking
                .DeleteBuookingReturnsWholeResponse
                        (RandomExistingBookingIds[0].getBookingid().toString(), token);

        //Verify Status Code
        Assert.assertEquals(response.getStatusCode(), SC_CREATED);


    }

}
