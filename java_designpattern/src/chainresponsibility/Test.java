package chainresponsibility;

public class Test {
	public void Run() throws Exception {
		System.out.println("\nChainResponsibility");
		Handler limitHandler = new LimitHandler("Limit", 5);
		Handler oddHandler = new OddHandler("Odd");
		Handler defalut = new DefaultHandler("Default");
		limitHandler.setNext(oddHandler).setNext(defalut);
		for (int i = 0; i < 100; i++) {
			Trouble trouble = new Trouble(i);
			limitHandler.handle(trouble);
		}
	}
}
