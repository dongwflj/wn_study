package builder;

public class Test {
	public void Run() {
		System.out.println("\nBuilder");
		Manager manager = new Manager(new HtmlBuilder());
		String name = (String)manager.buildObject();
		System.out.println("Éú³É" + name);
	}
}
