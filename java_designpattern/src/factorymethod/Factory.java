package factorymethod;

public abstract class Factory {
	// Template method used for factory create product
	public final Product create(String aOwner) throws Exception {
		Product product = createProduct(aOwner);
		registerProduct(product);
		return product;
	}
	protected Product createProduct(String aOwner) throws Exception {
		throw new Exception();
	};
	protected abstract void registerProduct(Product aProduct);
}
