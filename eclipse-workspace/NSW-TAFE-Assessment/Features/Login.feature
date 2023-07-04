Feature: Course Search and Filter

#  As a user I want to search for a course and apply a delivery filter So that I can find the desired course with the preferred delivery option

  @Test
  Scenario Outline: Search for a course and apply delivery filter
    Given I am on the TAFE NSW home page "<pageURL>"
    When I search for a course "<course>"
    And I click on the search button
    Then I should see the course "<course>" in the search results
    When I apply the delivery filter "<filter>"
    Then I should see the delivery filter "<filter>" applied to the course
		    
	Examples:
		 | pageURL  									 | course									 | filter		 |
		 | https://www.tafensw.edu.au/ | Advanced Barista Skills | On campus |
		 
		 
