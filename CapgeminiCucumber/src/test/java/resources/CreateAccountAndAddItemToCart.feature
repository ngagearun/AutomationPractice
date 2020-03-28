Feature: Create Account Search And Add Item To Cart

Scenario: User can register,add item to cart and item remains in cart after relogging in

Given the user navigates to the homepage
When the user clicks on the signin link from the homepage
And the user enters details to create a new account
Then a new account is created for the user and the user is logged into account
When the user searches for the most expensive item
And the user adds the item to the cart
And the user logs out of the account and logs back in
Then the item is still present in the cart
