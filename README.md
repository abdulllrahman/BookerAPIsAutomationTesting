# Booker APIs Automation Testing

## Overview
[booker API Automation Testing Project](https://restful-booker.herokuapp.com/) is built to automate API tests  a Hotel Booking Endpoints 


## Languages and Frameworks

The project uses the following:

- *[Java 11](https://openjdk.org/projects/jdk/11/)* as the programming language.
- *[REST Assured](https://rest-assured.io/)* as the REST API test automation framework.
- *[Jackson](https://www.baeldung.com/jackson/)* to parse json.
- *[JUnit 4](https://junit.org/junit5/)* as the testing framework.
- *[Datafaker](https://www.datafaker.net/)* as the fake data generation library.
- *[Maven](https://maven.apache.org/)* as the Java build tool.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.

## Project Structure

**Config Folder:**

***Environment.properties:*** property file which includes a specific environment url.

**src/main/java Folder:**

**1. base package:**

- ***Request Class***: This class can be considered as placeholder for endpoint requests, includes common methods for endpoint requests

**2. endpointMethods package:**

 This package includes all methods related to endpoints ... The classes under this package as below:
 - ***CreateAuth Class***: Includes methods which help in validating creating a valid token
 - ***CreateBooking Class***: Includes methods which help in validating creating a booking
 - ***GetBooking Class***: Includes methods which help in validating Getting a booking/Filter bookings
 - ***GetBookingIds Class***: Includes methods which help in validating Getting booking Ids
 - ***DeleteBooking Class***: Includes methods which help in validating deleteing a booking
 - ***UpdateBooking Class***: Includes methods which help in validating updating a booking
 - ***PartialUpadateBooking Class***: Includes methods help in validating partial updating a booking

**3. models package:**

 This package includes a pojo represenation of the json which included in the enpoint request/response ... The classes under this package as below:
 - ***AuthRequest Class***: a representation of "create token" endpoint response body
 - ***AuthResponse Class***: a representation of "create token" endpoint request body
 - ***BookingDate Class***: a representation of "Booking Date" json object
 - ***BookingPayload Class***: a representation of booking json object
 - ***BookingResponsePayload Class***: a representation of the whole response body

 **4. utilities package:**
 
 This package includes helper classes which make life more easier, organized and maintainable ... The classes under this package as below:
 - ***endpoints Class***: includes all the booking endpoints 
 - ***helper Class***: includes some common helper methods that make code more usable and maintainable
 
**src/test/java Folder:**

**1. tests package:**
 
 This package includes classes which contains the tests ... The classes under this package as below:
 - ***CreateBookingTests Class***: Includes all test methods which validate "create booking" endpoint
 - ***UpdateBookingTests Class***: Includes all test methods which validate "update booking" endpoint
 - ***PartialUpdateBookingTests Class***: Includes all test methods which validate "partial update booking" endpoint
 - ***GetBookingIdsTests Class***: Includes all test methods which validate "get booking Ids" endpoint
 - ***GetBookingTests Class***: Includes all test methods which validate "get booking" endpoint
 - ***DeleteBookingTests Class***: Includes all test methods which validate "Delete Bookings" endpoint

**POM.xml file**


