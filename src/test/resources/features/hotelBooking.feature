Feature: Hotel Booking Application

@hotelBooking
  Scenario: Search and Apply Discount
    Given User opens the hotel booking application
    When User searches for hotels in "New York" from "2025-04-30" to "2025-05-05"
    And User selects the first hotel from the search results
    And User applies the coupon code "SUMMER25"
    Then The discount should be applied correctly
    And proceeds to checkout page