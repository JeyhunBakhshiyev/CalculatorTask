@smoke
Feature: Perform addition, subtraction, multiplication and division operations on two whole numbers

  @addition
  Scenario Outline: Adding two whole numbers
    Given User navigates to "Staging" calculator page
    Then User validates value "0" on display
    Then User clears display clicking C button
    And User clicks "<value1>" button
    Then User validates value "<value1>" on display
    And User clicks "+" button
    And User clicks "<value2>" button
    Then User validates value "<value2>" on display
    And User clicks "=" button
    Then User user sees "<correct result>"

    Examples: 
      | value1 | value2 | correct result |
      |      0 |      1 |              1 |
      |      1 |      5 |              6 |
      |      2 |      7 |              9 |
      |      3 |      2 |              5 |
      |      4 |      9 |             13 |
      |      5 |      3 |              8 |
      |      6 |      8 |             14 |
      |      7 |      4 |             11 |
      |      8 |      0 |              8 |
      |      9 |      6 |             15 |

  @subtraction
  Scenario Outline: Subtracting two whole numbers
    Given User navigates to "Staging" calculator page
    Then User validates value "0" on display
    Then User clears display clicking C button
    And User clicks "<value1>" button
    Then User validates value "<value1>" on display
    And User clicks "-" button
    And User clicks "<value2>" button
    Then User validates value "<value2>" on display
    And User clicks "=" button
    Then User user sees "<correct result>"

    Examples: 
      | value1 | value2 | correct result |
      |      0 |      1 |             -1 |
      |      1 |      5 |             -4 |
      |      2 |      7 |             -5 |
      |      3 |      2 |              1 |
      |      4 |      9 |             -5 |
      |      5 |      3 |              2 |
      |      6 |      8 |             -2 |
      |      7 |      4 |              3 |
      |      8 |      0 |              8 |
      |      9 |      6 |              3 |

  @multiplication
  Scenario Outline: Multiplying two whole numbers
    Given User navigates to "Staging" calculator page
    Then User validates value "0" on display
    Then User clears display clicking C button
    And User clicks "<value1>" button
    Then User validates value "<value1>" on display
    And User clicks "*" button
    And User clicks "<value2>" button
    Then User validates value "<value2>" on display
    And User clicks "=" button
    Then User user sees "<correct result>"

    Examples: 
      | value1 | value2 | correct result |
      |      0 |      1 |              0 |
      |      1 |      5 |              5 |
      |      2 |      7 |             14 |
      |      3 |      2 |              6 |
      |      4 |      9 |             36 |
      |      5 |      3 |             15 |
      |      6 |      8 |             48 |
      |      7 |      4 |             28 |
      |      8 |      0 |              0 |
      |      9 |      6 |             54 |

  @division
  Scenario Outline: Dividing two whole numbers
    Given User navigates to "Staging" calculator page
    Then User validates value "0" on display
    Then User clears display clicking C button
    And User clicks "<value1>" button
    Then User validates value "<value1>" on display
    And User clicks "/" button
    And User clicks "<value2>" button
    Then User validates value "<value2>" on display
    And User clicks "=" button
    Then User user sees "<correct result>"

    Examples: 
      | value1 | value2 | correct result |
      |      0 |      1 |              0 |
      |      1 |      5 |            0.2 |
      |      2 |      7 |    0.285714286 |
      |      3 |      2 |            1.5 |
      |      4 |      9 |    0.444444444 |
      |      5 |      3 |     1.66666667 |
      |      6 |      8 |           0.75 |
      |      7 |      4 |           1.75 |
      |      8 |      0 | Error          |
      |      9 |      6 |            1.5 |

  @boundary
  Scenario Outline: Dividing two whole numbers
    Given User navigates to "Staging" calculator page
    Then User validates value "0" on display
    Then User clears display clicking C button
    And User enters "<value1>" on display
    Then User validates value "<value1>" on display
    And User clicks "*" button
    And User enters "<value2>" on display
    Then User validates value "<value2>" on display
    And User clicks "=" button
    Then User user sees "<correct result>"

    Examples: 
      | value1     | value2    | correct result  |
      |  999999999 | 999999999 | 9.99999998e+17  |
      | -999999999 | 999999999 | -9.99999998e+17 |
