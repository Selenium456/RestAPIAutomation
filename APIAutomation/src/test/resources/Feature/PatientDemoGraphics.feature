Feature: Tests for PatientDemographics API
  Description: Te purpose of this tests is to cover 
  all CRUD operations of PatientDemographics API with different Dataset

  #Background: User Generate token for authorization
  #Given  I generate token for Authorization
  
  Scenario: Get PatientDemoGraphics Records for All patients
    Given User sends Get Request for PatientDemoGraphics
    When User extracts the responsebody from response
    Then Verify the statuscode is '200'

  
