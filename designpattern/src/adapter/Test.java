package adapter;

public class Test {
	public void Run() {
		System.out.println("\nAdapter");
		Adapter adapter = new ConcretAdapter("ClassAdapter");
		adapter.printStrong();
		adapter.printWeak();
		Adapter adapter2 = new ConcretAdapter2("ObjectAdapter");
		adapter2.printStrong();
		adapter2.printWeak();
	}
}
