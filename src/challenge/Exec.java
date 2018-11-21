package challenge;

public class Exec {
	//sample execution of the interface



	public static void main(String[] args) {
		
		UnidaysDiscountChallenge ifc = new UnidaysDiscountChallenge(new SampleDiscounts());
		Product b = new Product("B", 12.00, 1, 20.00);
		Product a = new Product("A", 8.00, 0, 0);
		Product c = new Product("C", 4.00, 2, 10.00);
		Product d = new Product("D", 7.00, 3, 2);
		Product e = new Product("E", 5.00, 3, 3);
		
		Product inBasket[] = {e,d,c,b,a,e,d,c,b,c};
		ifc.addToBasket(inBasket);
		PricingRules total = ifc.calculateTotalPrice();
		System.out.println(total.delivery_price+"\n"+total.product_cost+"\n"+total.total);
	}

}
