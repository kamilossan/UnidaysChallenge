package challenge;

//generic product template containing name, price and discount type
//discount types and handlers provided by PricingRules class type
public class Product {
	protected String name;
	protected double price;
	protected int discount_type;
	protected double discount_arg;
	
	public String get_name() {
		return name;
	}

	public void set_name(String name) {
		this.name = name;
	}

	public double get_price() {
		return price;
	}

	public void set_price(double price) {
		this.price = price;
	}

	public int get_discount_type() {
		return discount_type;
	}

	public void set_discount_type(int discount_type) {
		this.discount_type = discount_type;
	}

	public double get_discount_arg() {
		return discount_arg;
	}

	public void set_discount_arg(double discount_arg) {
		this.discount_arg = discount_arg;
	}
	
	public Product(String name, double price, int discount_id, double arg){
		set_name(name);
		set_price(price);
		set_discount_type(discount_id);
		set_discount_arg(arg);
		
	}
}
