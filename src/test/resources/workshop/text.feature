Feature: TaxiFare

  Scenario: 普通行程
    Given 上车时间 "08:00" ，行驶 "2" 公里
    When 下车付费
    Then 需要付费 "14" 元

  Scenario: 普通行程
    Given 上车时间 "08:00" ，行驶 "4.0" 公里
    When 下车付费
    Then 需要付费 "16.5" 元

  Scenario Outline: 普通行程
    Given 上车时间 <time> ，行驶 <distance> 公里
    When 下车付费
    Then 需要付费 "14" 元
  Examples:
    | time  | distance|
    |"08:00"| 3.1     |
    |"09:00"| 4       |