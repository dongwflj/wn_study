package decorator;

public class Test {
	public void Run() throws Exception {
		System.out.println("\nDecorator");
		Display string = new StringDisplay("Hello");
		Display decorator = new LineDecorator(string);
		Display fullDecorator = new FullDecorator(decorator);
		fullDecorator.show();
	}
}
