package factorymethod;

public class Test {
	public void Run() throws Exception {
		System.out.println("\nFactoryMethod");
		Factory factory = new ConcreteFactory();
		Product product = factory.create("Owner1");
		product.use();
		Product product2 = factory.create("Owner2");
		product2.use();
	}
}
