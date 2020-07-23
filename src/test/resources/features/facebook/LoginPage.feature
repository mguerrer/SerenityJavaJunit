Feature: Allow users to login facebook site

  @Login
  Scenario Outline: User login successfully with correct
    Given Navigate to facebook login page
    When Login facebook with '<phone>' and '<password>'
    Then Should navigate to facebook homepage
    Examples:
      |phone|password|
      |0838069260|cuong1990|