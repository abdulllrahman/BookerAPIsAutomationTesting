package tests;

import models.BookingPayload;
import models.BookingResponsePayload;
import org.junit.Assert;
import org.junit.Test;
import utilities.helpers;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_OK;

public class PartialUpdateBookingTests extends TestBase {

    String token=endpointMethods.CreateAuth.GetToken();

    //Verify Create Booking Status Code
    @Test
    public void CheckPartialUpdateBookingAPIStatusCode200() {

        //Get Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //partial update Booking
        io.restassured.response.Response response=endpointMethods.PartialUpdateBooking
                .PartialUpdateBooking(RandomExistingBookingIds[0].getBookingid().toString(),
                        token);

        //Verify Status Code
        Assert.assertEquals(SC_OK,response.getStatusCode());


    }

    //Verify partial update Booking Endpoint returns correct data
    @Test
    public void CheckPartialUpdateBookingReturnsCorreectData() {

        //get updated booking data
        BookingPayload RandomBookingPayload = helpers.partialUpdateBookingRequestPayload();

        //Get Random Booking Id
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //partial update Booking
        io.restassured.response.Response response=endpointMethods.PartialUpdateBooking
                .PartialUpdateBooking(RandomExistingBookingIds[0].getBookingid().toString(),
                        token,RandomBookingPayload);

        BookingPayload ReturnedBooking=response.as(BookingPayload.class);


        //Verify partial upadate endpoint correctly updated the intended fields
        Assert.assertEquals(RandomBookingPayload.getFirstname()
                ,ReturnedBooking.getFirstname());

        Assert.assertEquals(RandomBookingPayload.getLastname()
                ,ReturnedBooking.getLastname());

        Assert.assertEquals(RandomBookingPayload.getTotalprice()
                ,ReturnedBooking.getTotalprice());

    }

    //Check partial upadte booking returns in case a wrong booking id is sent
    @Test
    public void CheckPartialUpdateBookingAPIInCaseWrongBookingID() {

        //Get Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=endpointMethods.GetBookingIds.GetAllBookingIds();

        //partial update Booking
        io.restassured.response.Response response=endpointMethods.PartialUpdateBooking
                .PartialUpdateBookingInCaseWrongBookingID(RandomExistingBookingIds[0].getBookingid().toString(),
                        token);

        //Verify Status Code
        Assert.assertEquals(SC_METHOD_NOT_ALLOWED,response.getStatusCode());

    }
}
