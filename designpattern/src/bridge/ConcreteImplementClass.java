package bridge;

public class ConcreteImplementClass extends ImplementClass {
	private String mString;
	private int mWidth;
	public ConcreteImplementClass(String aString) {
		mString = aString;
		mWidth = aString.length();
	}
	
	@Override
	public void rawOpen() {
		printLine();
	}

	@Override
	public void rawPrint() {
		System.out.println("|" + mString + "|");
	}

	@Override
	public void rawClose() {
		printLine();
	}
	
	private void printLine() {
		System.out.print("+");
		for (int i = 0; i < mWidth; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
}
