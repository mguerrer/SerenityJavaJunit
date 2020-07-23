Feature: Allow users to login to quang cao coc coc website

  @Login
  Scenario Outline: Login successfully with email and password
    Given Navigate to quang cao coc coc login site
    When Login with '<email>' and '<password>'
    Then Should navigate to home page site
    Examples:
      |email|password|
      |ledinhcuong99@gmail.com|Test11011990|

  @pending
  Scenario Outline: Login failed with invalid email
    Given Navigate to quang cao coc coc login site
    When Login with '<email>' and '<password>'
    Then Should prompt with '<errormessage>'
    Examples:
      |email|password|errormessage|
      |ledinhcuong99@gmail.com|aaa|abc@example.com|