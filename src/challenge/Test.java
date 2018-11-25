package challenge;

public class Test extends SampleDiscounts {

	public Test() {
		// TODO Auto-generated constructor stub
			Product a = new Product("a",1,4,1);
		System.out.println(get_discounted_price(a, 10));}

	
	protected void handle_scope_out(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();

	}
	public double get_discounted_price(Product product, int count){
		return 10+super.get_discounted_price(product, count);
	}

}
