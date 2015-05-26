package adapter;

public class ConcretAdapter2 implements Adapter {
	private Adaptee mAdaptee;
	ConcretAdapter2(String aString) {
		mAdaptee = new Adaptee(aString);
	}
	@Override
	public void printStrong() {
		mAdaptee.showAsterisk();
	}

	@Override
	public void printWeak() {
		mAdaptee.showParent();
	}
}
