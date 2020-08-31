Feature: PatientDemographics API
  Description: The purpose of this tests is to cover 
  all CRUD operations of PatientDemographics API with different Dataset

  #Background: User Generate token for authorization
  #Given  I generate token for Authorization
  Scenario: Verify Response Header and response code for GetPatientDemographics
    Given User sends Get Request for PatientDemoGraphics
    When User extracts the responseheader
    Then Verify the statuscode is '200'
    And Verify the "Content-Type" in response header is "application/json;charset=UTF-8"

  Scenario: Verify Post Request for Patient Demographics
    Given User sends Post Request for PatientDemoGraphics
    When User extracts the responsebody
    Then Verify the statuscode is '201'
    
  Scenario: Verify PUT Request for Patient Demographics
    Given User sends PUT Request for PatientDemoGraphics
    When User extracts the responsebody
    Then Verify the SIN number is updated
    And Verify the statuscode is '200'
    
   

  Scenario: Verify Get All Gender Request
    Given User sends GetAll GenderRequest for PatientDemoGraphics
    When User extracts the Gender responsebody
    Then Verify all Gender Types are present in responsebody
      | Gender |  | Genderdesc |
      | M      |  | Male       |
      | F      |  | Female     |
      | O      |  | Other      |
      | U      |  | Unknown    |
    And Verify the statuscode is '200'

  Scenario: Verify GetPatientDemographicsById endpoint
    Given User sends Get Request to get patientdemographics by id
    When User extracts the responsebody for requestedPatientID
    Then Verify the statuscode is '200'

  Scenario: Verify all name prefix are extracted from getAllNamePrefix request
    Given User sends getAllNamePrefix for PatientDemoGraphics
    When User extracts the namePrefix responsebody
    Then Verify below Name prefix are present in responsebody
      | namePrefixCode |  | namePrefixDesc |
      | Dr             |  | Doctor         |
      | Bro            |  | Brother        |
      | Mr             |  | Mister         |
      | Ms             |  | Ms             |
    And Verify the statuscode is '200'

  Scenario: Verify all name suffix are extracted from getAllNamePrefix request
    Given User sends getAllNamesuffix for PatientDemoGraphics
    When User extracts the namesuffix responsebody
    Then Verify below Name suffix are present in responsebody
      | namesuffixCode |  | namesuffixDesc |
      | Jr             |  | Junior         |
      | Sr             |  | Senior         |
    And Verify the statuscode is '200'

  Scenario: Verify all Official Language details through getAllOfficialLanguage
    Given User sends getAllOfficialLanguage request
    When User extracts the OfficialLanguage responsebody
    Then Verify below Official Language are present in responsebody
      | officialLanguageCode |  | officialLanguageDesc |
      | ENG                  |  | English              |
      | FRE                  |  | French               |
    And Verify the statuscode is '200'
    
   Scenario: Verify all PatientDemographicsList through getAllPatientDemographicsList
    Given User sends getAllPatientDemographicsList request
    When User extracts the getAllPatientDemographicsList responsebody
    Then Verify below Name prefix are present in responsebody
      | namePrefixCode |  | namePrefixDesc |
      | Dr             |  | Doctor         |
      | Bro            |  | Brother        |
      | Mr             |  | Mister         |
      | Ms             |  | Ms             |
    And Verify below Name suffix are present in responsebody
      | namesuffixCode |  | namesuffixDesc |
      | Jr             |  | Junior         |
      | Sr             |  | Senior         |
    And Verify below Official Language are present in responsebody
      | officialLanguageCode |  | officialLanguageDesc |
      | ENG                  |  | English              |
      | FRE                  |  | French               |
    And Verify all Gender Types are present in responsebody
      | Gender |  | Genderdesc |
      | M      |  | Male       |
      | F      |  | Female     |
      | O      |  | Other      |
      | U      |  | Unknown    |
    And Verify the statuscode is '200'
    
  Scenario: Verify Delete Request for Patient Demographics
    Given User sends Delete Request for PatientDemoGraphics
    When User extracts the responsebody
    Then Verify the statuscode is '200'
    And the response is null
