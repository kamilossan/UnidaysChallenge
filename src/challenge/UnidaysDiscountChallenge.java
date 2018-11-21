package challenge;

import java.util.LinkedList;
import java.util.List;

public class UnidaysDiscountChallenge {
	//field, pricing rules instantiated as discount handler
	private List<Product> basket = new LinkedList<Product>();
	protected PricingRules pricing;
	
	
	//public constructor
	public UnidaysDiscountChallenge(PricingRules x){
		this.pricing = x;
	};
	
	
	public void addToBasket(Product product){
		basket.add(product);
	};
	public void addToBasket(Product products[]){
		for(Product x: products){
			addToBasket(x);
		}
	}
	
	//returns pricing rules class for the sake of fulfilling the excercise's specification of returning all subvalues.
	//Since variables are within PricingRules child class, this is a simple solution that allows further data modification.
	public PricingRules calculateTotalPrice(){
		pricing.calculate_total(this.basket);
		return pricing;
	}



}
