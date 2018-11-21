package challenge;

import java.util.List;

//Class template for discount/pricing handler. Used by main class to possibly implement different discount classes.
//
abstract class PricingRules {
	double delivery_price=0, product_cost=0, total=0;
//abstract discount handling function - implement discount types by defining this function in extending classes
	abstract double get_discounted_price(Product product, int count);
	
//generic default calculate functions. Overload to implement get_discounted_price() in extending classes
	void calculate_products(List<Product> products){
		product_cost = 0;
		for(Product x : products){
			product_cost+=x.price;
		}
	};
	void calculate_total(List<Product> products){
		calculate_products(products);
		total = delivery_price+product_cost;
	};


	//overload for custom delivery cost conditions
	void set_delivery_price(double price, double free_delivery) {
		if (product_cost == 0 || product_cost > free_delivery) {

			delivery_price = 0;

		} else {
			delivery_price = price;
		}
	}

}
