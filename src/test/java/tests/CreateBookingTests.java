package tests;

import models.BookingPayload;
import models.BookingResponsePayload;
import org.junit.Assert;
import org.junit.Test;
import utilities.helpers;
import static org.apache.http.HttpStatus.SC_OK;


public class CreateBookingTests extends TestBase {

    //Verify Create Booking Status Code

    @Test
    public void CheckCreateBookingAPIStatusCode200() {

        //Create Booking
        io.restassured.response.Response response=endpointMethods.
                CreateBooking.CreateBooking();

        //Verify Status Code
        Assert.assertEquals(SC_OK,response.getStatusCode());

    }


    //Verify Create Booking Endpoint returns correct data
    @Test
    public void CheckCreateBookingResponseData() {

        //Create Booking Details
        BookingPayload createdRandomBookingPayload = helpers.createBookingRequestPayload();

        //Post the created booking using the Create Booking endpoint
           BookingResponsePayload ReturnedBooking =endpointMethods.
                CreateBooking.CreateBooking(createdRandomBookingPayload);

        //Verify that the Create Booking endpoint returns the correct data
        Assert.assertEquals(createdRandomBookingPayload.getFirstname()
                ,ReturnedBooking.getBooking().getFirstname());

        Assert.assertEquals(createdRandomBookingPayload.getLastname()
                ,ReturnedBooking.getBooking().getLastname());

        Assert.assertEquals(createdRandomBookingPayload.getDepositpaid()
                ,ReturnedBooking.getBooking().getDepositpaid());

        Assert.assertEquals(createdRandomBookingPayload.getBookingdates().getCheckin()
                ,ReturnedBooking.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(createdRandomBookingPayload.getBookingdates().getCheckout()
                ,ReturnedBooking.getBooking().getBookingdates().getCheckout());

        Assert.assertEquals(createdRandomBookingPayload.getAdditionalneeds()
                ,ReturnedBooking.getBooking().getAdditionalneeds());

        Assert.assertEquals(createdRandomBookingPayload.getTotalprice()
                ,ReturnedBooking.getBooking().getTotalprice());
    }
}
