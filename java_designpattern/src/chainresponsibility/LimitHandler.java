package chainresponsibility;

public class LimitHandler extends Handler {
	private int mLimit;
	
	public LimitHandler(String aName, int aLimit) {
		super(aName);
		mLimit = aLimit;
	}

	@Override
	protected boolean resolve(Trouble aTrouble) {
		if (aTrouble.getNumber() < mLimit) {
			return true;
		}
		return false;
	}
}
