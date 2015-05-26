package adapter;

public class Adaptee {
	private String mString;
	public Adaptee(String aString) {
		this.mString = aString;
	}
	public void showParent() {
		System.out.println("(" + mString + ")");
	}
	public void showAsterisk() {
		System.out.println("*" + mString + "*");
	}
}
