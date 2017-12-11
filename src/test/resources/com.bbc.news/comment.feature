Feature: Comment on the news article
  As an audience member of http://www.bbc.co.uk/news
  I want to comment a news article
  So I can express my opinion on a material

  Background:
    Given I navigate to: 'http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0#comments'

  Scenario: Leave valid comment
    When I login as audience member with email 'tdc48252@xoixa.com' and password '_v1v2v3v4v5_'
    And I post some comment
    Then message 'Thanks, your comment has been posted.' appears
    And comment appears in comments list with author 'You'

  Scenario: Register account link
    When I click Register link in comments section
    Then I redirected to 'Register with the BBC' page