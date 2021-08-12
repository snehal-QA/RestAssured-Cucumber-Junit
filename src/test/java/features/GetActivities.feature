Feature: Verifies if employee/employee(s) details are retreived sucessfully

  #Scenario: Admin can get details of all employees
    #Given admin uses GetEmployees endpoint
    #When admin retreives employee details
    #Then status code 200 is returned

  Scenario Outline: Admin can get details for queried employee
    Given admin uses GetSingleEmployee <id> endpoint
    When admin retreives single employee details
    Then status code 200 is returned
    Examples:
    |id|
    |25|
    |30|