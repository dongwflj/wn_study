package bridge;

public class Test {
	public void Run() {
		System.out.println("\nBridge");
		ImplementClass impl = new ConcreteImplementClass("Heello");
		FunctionClass func = new FunctionClass(impl);
		func.doRealWork();
		MoreFunctionClass moreFunc = new MoreFunctionClass(impl);
		moreFunc.doRealWork();
		moreFunc.doMoreWork(4);
	}
}
