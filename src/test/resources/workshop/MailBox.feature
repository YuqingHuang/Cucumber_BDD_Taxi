Feature: Mailbox

  Scenario: Check Inbox
    Given I have received an email from "Jerry"
    When I sign in
    Then I should see one email from "Jerry" in my inbox
