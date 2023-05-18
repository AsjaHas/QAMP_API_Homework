Smoke Test 

Smoke testing is a type of software testing that is performed to check if the basic functionalities of a software application are working properly.

Restfool Booker is a booking app that allows users to book appointments and it holds all bookings in the system. The main functionality of the Restful Booker site would be the functionality to book appointments (CreateBooking), and functionality to check if the booking was really created (GetBooking/GetBookingIds). 


CreateBooking

The booking is created by providing: first name, last name, total price, true/false if the deposit was paid, and dates for check-in and check-out. Response "200 OK" should be received after creating the request. A booking ID will be given in the response and it can be used to search for a specific booking by ID.


GetBooking

Functionality that will search through existing bookings and find if the booking with the specified ID exists. It will return all information connected to that booking (first name, last name, total price, true/false if the deposit was paid, and dates for check-in and check-out). Response "200 OK" should be received after creating the request.


GetBookingIds

Functionality that will search through existing bookings and find if the booking with the specified parameters exists (first name/ last name etc.). It will return booking ID that can be used to get booking info (GetBooking). Response "200 OK" should be received after creating the request.
