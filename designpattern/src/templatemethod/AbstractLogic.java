package templatemethod;

public abstract class AbstractLogic {
	protected abstract void start();
	protected abstract void doSomething();
	protected abstract void end();
	// Template Method, define the abstract logic
	public final void logic() {
		start();
		for (int i = 0; i < 3; i++) {
			doSomething();
		}
		end();
	}
}
