package factorymethod;

import java.util.Vector;

public class ConcreteFactory extends Factory {
	@SuppressWarnings("rawtypes")
	private Vector mOwners = new Vector();
	
	@Override
	protected Product createProduct(String aOwner) {
		Product product = new ConcreteProduct(aOwner);
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void registerProduct(Product aProduct) {
		mOwners.add(aProduct);
	}
}