# UnidaysChallenge
Discount processing system

Rather simple discount processing framework to calculate total price of product in basket including delivery, with the option of expanding the program to customize discounts, delivery price change conditions or product pricings. 
General usage description:
Exec.jar file launches Exec.java, which is just a sample implementation of the interface. It instantiates the framework to calculate the basket equal to the last test case given in challenge specification. 
General syntax is as follows:
-UnidaysDiscountChallenge.java: The main framework. Instantiate it with class of type PricingRules. As per specification, contains methods addToBasket() and calculate_total(), that behave exactly as specified. 
-PricingRules.java: Abstract class serving as a template for discounts processing. I opted for abstract class since, unlike interface, it allows creating non-static field variables. As such, calculate_total() can simply return value of type PricingRules to access all requested values: total price, product price and delivery price. By default, PricingRules class will assume delivery price to be 0 and doesn't implement any discount processing - so empty class extending PricingRules, when passed as argument to UnidaysDiscountChallenge, will simply add prices of products inside client basket.
-Product.java: basic implementation of products inside client basket. It only contains field values price, name, discount_id and discount_arg, including a constructor and approporiate mutators+accessors. Two separate variables are used to process discounts in order to generalize discount types - so for example discount "get 3 for the price of 2" and "get 2 for the price of 1" are going to be processed by the same method, giving the framework flexibility and possible extendability.
-SampleDiscounts.java: Actual discount processing class. Extends PricingRules so it can be passed as argument when instantiating UnidaysDiscountChallenge. This implements discounts as specified in the challenge. Will terminate process with an error directing at product name in case of invalid discount type. I've tried to write this class in a manner such that this class could also be further extended - just in case if someone wanted to simply add few more functionalities they could avoid creating another PricingRules instance from scratch. Therefore, get_discounted_price() itself does not return an error, but a value of -1 instead. Error is thrown in calculate_products() which can be overloaded. This way a child class, when adding new discount types, can just use super.get_discounted_price() and only conduct additional actions in case it catches negative return value.

I used Java due to it's relative simplicity in implementing class templates(abstract classes/interfaces) that proved useful in this scenario and due to possibility of utilizing this solution on an actual web server (eg. Apache+JSP).

~Kamil Spirydowicz
