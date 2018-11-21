package challenge;

//generic product template containing name, price and discount type
//discount types and handlers provided by PricingRules class type
public class Product {
	protected String name;
	protected double price;
	protected int discount_type;
	protected double discount_arg;
	public String get_name(){
		return name;
	}
	public double get_price(){
		return price;
	}
	public int get_discount_type(){
		return discount_type;
	}
	protected void set_name(String name){
		this.name =name;
	}
	protected void set_price(double price){
		this.price = price;
	}
	protected void set_discount(int id, double arg){
	//typically 0 = no discount	
		this.discount_type = id;
		this.discount_arg = arg;
		
	}
	public Product(String name, double price, int discount_id, double arg){
		set_name(name);
		set_price(price);
		set_discount(discount_id, arg);
		
	}
}
