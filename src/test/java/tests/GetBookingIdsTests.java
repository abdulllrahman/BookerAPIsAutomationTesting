package tests;

import models.BookingPayload;
import models.BookingResponsePayload;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetBookingIdsTests extends TestBase {

    //Testing "get all bookingIds" endpoint - Without Filters
    @Test
   public void CheckGetBookingIdsAPIStatusCode200() {
        io.restassured.response.Response response =
                endpointMethods.GetBookingIds.GetAllBookingIdsResponse();
        Assert.assertEquals(response.getStatusCode(), SC_OK);
    }

    //Testing "get all bookingIds" endpoint returns correct data - Filter By Name
    @Test
    public void CheckGetBookingIdsFilterByName() {

        //Get Existing Random BookingId
        BookingResponsePayload[] RandomExistingBookingIds=
                endpointMethods.GetBookingIds.GetAllBookingIds();

        //Get a Random Booking details
        BookingPayload BookingDetails= endpointMethods.GetBooking
                .GetBookingById(RandomExistingBookingIds[0].getBookingid().toString());

        //Check that get booking API returns BookingIds - filter with Name
        BookingResponsePayload[] Ids = endpointMethods.GetBookingIds
                .GetBookingIdsFilterByName(BookingDetails.getFirstname(), BookingDetails.getLastname());

        //Assert that this user has at least one booking ID
        Assert.assertTrue(Ids.length != 0);
    }


    //Testing "get all bookingIds" endpoint Status Code - Filter By checkin
    @Test
    public void CheckGetBookingIdsFilterByCheckIn() {

        //Get Existing Random BookingIds
        BookingResponsePayload[] RandomExistingBookingIds=
                endpointMethods.GetBookingIds.GetAllBookingIds();

        //Get a Random Booking details
        BookingPayload BookingDetails= endpointMethods.GetBooking
                .GetBookingById(RandomExistingBookingIds[0].getBookingid().toString());

        //Check that get booking API returns BookingIds - filter with Booking Check In
        BookingResponsePayload[] BookingIds = endpointMethods.GetBookingIds
                .GetBookingIdsFilterByCheckIn(BookingDetails.getBookingdates().getCheckin());

        //Assert that API returns non-empty data
        assertThat(BookingIds.length, Matchers.greaterThan(0));

    }


    //Testing "get all bookingIds" endpoint Status Code - Filter By booking date
    @Test
    public void CheckGetBookingIdsFilterByBookingDate() {

        //Get Existing Random BookingIds
        BookingResponsePayload[] RandomExistingBookingIds=
                endpointMethods.GetBookingIds.GetAllBookingIds();

        //Get a Random Booking details
        BookingPayload BookingDetails= endpointMethods.GetBooking
                .GetBookingById(RandomExistingBookingIds[0].getBookingid().toString());

        //Check that get booking API returns BookingIds - filter with Booking Date
        BookingResponsePayload[] BookingIds = endpointMethods.GetBookingIds
                .GetBookingIdsFilterByBookingDate(BookingDetails.getBookingdates().getCheckin(),
                        BookingDetails.getBookingdates().getCheckout());

        //Assert that API returns non-empty data
        assertThat(BookingIds.length, Matchers.greaterThan(0));

    }

    //Testing "get all bookingIds" endpoint without filters - check returning Correct Data
    @Test
    public void CheckGetBookingIdsReturnsCorrectData() {

        io.restassured.response.Response response =
                endpointMethods.GetBookingIds.GetAllBookingIdsResponse();

        BookingResponsePayload[] BookingIds=response.as(BookingResponsePayload[].class);

        org.junit.Assert.assertTrue(BookingIds.length>0);

    }



}