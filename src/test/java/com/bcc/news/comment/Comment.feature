Feature: Comment
  As an audience member of http://www.bbc.co.uk/news
  I want to comment a news article
  So I can express my opinion on material

  Scenario: Leave comment
    Given I am audience member
    And I navigate to: 'http://www.bbc.co.uk/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0#comments'