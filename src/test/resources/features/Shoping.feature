Feature: Shopping
  @Shopping
  Scenario Outline: Add product to wishlist
    Given the user is on the Fortnums and Mason homepage
    And the user select the EU country switcher <country> and <currency>
    And the user select the product category
    When the user select a product <data-sku>
    And clicks on the 'Add to wishlist' Button
    Then the item should be added to the wishlist
    Examples:
      | country        | currency | data-sku |
      | United Kingdom | € EUR    | 2040007  |
