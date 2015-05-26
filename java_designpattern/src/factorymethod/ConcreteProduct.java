package factorymethod;

public class ConcreteProduct extends Product {
	private String mOwner;
	ConcreteProduct(String aOwner) {
		mOwner = aOwner;
	}
	@Override
	public void use() {
		System.out.println("This is product of:" + mOwner);
	}
}