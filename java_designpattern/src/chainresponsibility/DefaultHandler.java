package chainresponsibility;

public class DefaultHandler extends Handler {

	public DefaultHandler(String aName) {
		super(aName);
	}

	@Override
	protected boolean resolve(Trouble aTrouble) {
		return false;
	}

}
