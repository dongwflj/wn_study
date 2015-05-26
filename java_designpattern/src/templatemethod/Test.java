package templatemethod;

public class Test {
	public void Run() {
		System.out.println("\nTemplateMethod");
		AbstractLogic logic = new ConcreteLogic();
		logic.logic();
		AbstractLogic logic2 = new ConcreteLogic2();
		logic2.logic();
	}
}
