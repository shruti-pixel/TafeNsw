Feature: Course Search and Filter
  As a user
  I want to search for a course and apply a delivery filter
  So that I can find the desired course with the preferred delivery option

  Scenario: Search for a course and apply delivery filter
    Given I am on the TAFE NSW home page "https://www.tafensw.edu.au/"
    When I search for a course "Advanced Barista Skills"
    And I click on the search button
    Then I should see the course "Advanced Barista Skills" in the search results
    When I apply the delivery filter "On Campus"
    Then I should see the delivery filter "On Campus" applied to the course
