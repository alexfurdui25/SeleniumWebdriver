Feature: SignUp feature
  @smokeTest
  Scenario: verify first name error
    Given SignIn: I am a user on sign in page
    When SignIn: I click sign up link
    When SignUp: I click personal and continue
    When SignUp: I provide first name: andy123
    Then SingUp: I see invalid first name error