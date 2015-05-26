package chainresponsibility;

public class Trouble {
	private int mNumber;
	public Trouble(int aNumber) {
		mNumber = aNumber;
	}
	public int getNumber() {
		return mNumber;
	}
	public String toString() {
		return "[Trouble " + mNumber + "]";
	}
}
