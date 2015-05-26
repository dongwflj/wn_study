package chainresponsibility;

public class OddHandler extends Handler {

	public OddHandler(String aName) {
		super(aName);
	}

	@Override
	protected boolean resolve(Trouble aTrouble) {
		if (aTrouble.getNumber() % 2 == 1) {
			return true;
		}
		return false;
	}
}
