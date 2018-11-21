package challenge;

import java.util.LinkedList;
import java.util.List;

//Sample implementation of PricingRules template. Processes discounts as specified within challenge excercise.
//This class can be further extended and still used as argument for main class, in case new discount types were implemented.
//Use "super" to call existing price calculator in the overload to handle existing discounts.
public class SampleDiscounts extends PricingRules {

	// handler for "get x for..." discount
	public double bundle_price(int count, double price, int in_basket, double single_price) {
		int overdraft = in_basket%count;
		double result = (in_basket - overdraft)/count * price;
		result+=overdraft*single_price;
		return result;
	};

	// handler for "get x in the price of y" discount. Every x'th item is going
	// to be free, where x is interval.
	public double free_add(int interval, int in_basket, double price) {
		
		double result = (in_basket-(int)(in_basket/interval))*price;
		return result;
	};

	// count products of the same type in basket
	int count_product(List<Product> products, String name) {
		int count = 0;
		for (Product x : products) {
			if (x.name == name)
				count++;
		}
		return count;
	};

	// count total product cost with discount. call super for non-discounted
	// total.
	void calculate_products(List<Product> products) {
		List<String> counted = new LinkedList<String>();
		for (Product x : products) {
			if (counted.contains(x.name)) {
				continue;
			} else {
				super.product_cost += get_discounted_price(x, count_product(products, x.name));
				counted.add(x.name);
			}
		}
	};

	void calculate_total(List<Product> products){
		calculate_products(products);
		super.set_delivery_price(7, 50);
		super.total = super.product_cost+super.delivery_price;
	};

	public SampleDiscounts() {
		// TODO Auto-generated constructor stub
	}

	@Override
	double get_discounted_price(Product product, int count) {
		switch (product.discount_type) {
		case 1:
			//2 for <discount_arg> as price
			return bundle_price(2, product.discount_arg, count, product.price);
		case 2:
			//3 for <discount_arg> as price
			return bundle_price(3, product.discount_arg, count, product.price);
		case 3:
			//buy x get <discount_arg>'th free
			return free_add((int)product.discount_arg, count, product.price);
		case 0:
			//default, no discount
			return product.price * count;

		}
		//in case product was defined with invalid discount id
		throw new java.lang.Error("Error processing discount: bad discount type at product " + product.name);
	}

}
