package adapter;

public class ConcretAdapter extends Adaptee implements Adapter {
	public ConcretAdapter(String aString) {
		super(aString);
	}
	@Override
	public void printStrong() {
		showAsterisk();
	}

	@Override
	public void printWeak() {
		showParent();
	}
}
