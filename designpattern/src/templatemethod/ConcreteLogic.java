package templatemethod;

public class ConcreteLogic extends AbstractLogic {

	@Override
	protected void start() {
		System.out.println("-------------------");
	}

	@Override
	protected void doSomething() {
		System.out.println("|--ConcreteLogic--|");
	}

	@Override
	protected void end() {
		System.out.println("-------------------");
	}
}
