package bridge;

public class MoreFunctionClass extends FunctionClass {

	public MoreFunctionClass(ImplementClass aImpl) {
		super(aImpl);
	}
	public void doMoreWork(int aTimes) {
		open();
		for (int i = 0; i < aTimes; i++) {
			print();
		}
		close();
	}
}
