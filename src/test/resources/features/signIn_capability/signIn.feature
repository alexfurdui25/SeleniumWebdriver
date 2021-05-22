Feature: Sign In capability tests
  Description: extra info
  # se executa inainte de fiecare test
  Background:
    Given SignIn: I am a user on sign in page
  @smokeTest
  Scenario: Invalid credentials error
    When SignIn: I provide wrong credentials and click Log In button
    Then SingIn: I see invalid credentials error
  @smokeTest
  Scenario Outline: Invalid email error
    When SignIn: I provide email: <email>
    Then SingIn: I see invalid email error
    Examples:
      | email                |
      | invalidEmail@email.c |
      | abc123               |
      | email.gmail.com      |
  @smokeTest
  Scenario: Invalid email error not displayed for correct email address
    When SignIn: I provide email: invalidEmail
    When SignIn: I provide email: validEmail@gmail.com
    Then SingIn: I do not see invalid email error anymore