package tests;

import models.BookingPayload;
import models.BookingResponsePayload;
import org.junit.Assert;
import org.junit.Test;
import utilities.helpers;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_OK;

public class UpdateBookingTests extends TestBase {

    String token=endpointMethods.CreateAuth.GetToken();


    //Verify Create Booking Status Code
    @Test
    public void CheckUpdateBookingAPIStatusCode200() {

        //Get Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //Update Booking
        io.restassured.response.Response response=endpointMethods.UpdateBooking
                .updateBooking(RandomExistingBookingIds[0].getBookingid().toString(),
                        token);

        //Verify Status Code
        Assert.assertEquals(SC_OK,response.getStatusCode());


    }

    //Verify Update Booking Endpoint Response Data
    @Test
    public void CheckUpdateBookingReturnsCorrectData() {

        //get updated booking data
        BookingPayload createdRandomBookingPayload = helpers.createBookingRequestPayload();

        //Get Random Booking Id
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //Update Booking
        io.restassured.response.Response response=endpointMethods.UpdateBooking
                .updateBooking(RandomExistingBookingIds[0].getBookingid().toString(),
                        token,createdRandomBookingPayload);

        BookingPayload ReturnedBooking=response.as(BookingPayload.class);


        //Verify Response Data
        Assert.assertEquals(createdRandomBookingPayload.getFirstname()
                ,ReturnedBooking.getFirstname());

        Assert.assertEquals(createdRandomBookingPayload.getLastname()
                ,ReturnedBooking.getLastname());

        Assert.assertEquals(createdRandomBookingPayload.getDepositpaid()
                ,ReturnedBooking.getDepositpaid());

        Assert.assertEquals(createdRandomBookingPayload.getBookingdates().getCheckin()
                ,ReturnedBooking.getBookingdates().getCheckin());
        Assert.assertEquals(createdRandomBookingPayload.getBookingdates().getCheckout()
                ,ReturnedBooking.getBookingdates().getCheckout());

        Assert.assertEquals(createdRandomBookingPayload.getAdditionalneeds()
                ,ReturnedBooking.getAdditionalneeds());

        Assert.assertEquals(createdRandomBookingPayload.getTotalprice()
                ,ReturnedBooking.getTotalprice());

    }

    @Test
    public void CheckUpdateBookingAPIWithWrongBookingId() {

        //Get Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //Create Booking
        io.restassured.response.Response response=endpointMethods.UpdateBooking
                .updateBookingWithWrongBookingId(RandomExistingBookingIds[0].getBookingid().toString(),
                        token);

        //Verify Status Code
        Assert.assertEquals(SC_METHOD_NOT_ALLOWED,response.getStatusCode());


    }
}
