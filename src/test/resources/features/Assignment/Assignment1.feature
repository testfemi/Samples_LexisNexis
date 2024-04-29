Feature: Validate LexisNexis Risk Solutions Industry Selection


Background:
    Given the user navigates to the "Home Page" page


  @Test001 @all @Regression
  Scenario: Verify elements under "Choose Your Industry" are present and clickable
    When Click the "Choose Your Industry" heading on the Home page
    Then the following industries should be present and clickable:
     |Financial Services|
     |Insurance|
     | Life and Pensions|
     | Corporations and Non-Profits|

  @Test002 @Regression
  Scenario Outline: Validate each subcategory under "Financial Services" is present and clickable
    When Click the "Choose Your Industry" heading on the Home page
    When Click the "Financial Services " Subcategory
    And Click the below "<AfterSubcategory>" Link
    Examples:
      | AfterSubcategory|
      |Financial Crime Compliance|
      |Fraud and Identity Management|
      |Customer Data Management|
      |Credit Risk Assessment|
      |Collections and Recovery|
      |Investigations and Due Diligence|
      |Risk Orchestration|

     @Test003 @Regression
  Scenario Outline: Validate each subcategory under "Financial Services" is present and clickable
    When Click the "Choose Your Industry" heading on the Home page
    When Click the "Insurance" Subcategory
    And Click the below "<AfterSubcategory>" Link

   Examples:
     | AfterSubcategory                 |
     | Fraud and Identity Management     |
     | Home Insurance Solutions          |
     |Motor Insurance Solutions|
     |Commercial Motor Insurance|