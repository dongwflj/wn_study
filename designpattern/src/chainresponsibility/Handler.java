package chainresponsibility;

public abstract class Handler {
	private String mName;
	private Handler mNext;
	public Handler(String aName) {
		mName = aName;
	}
	public Handler setNext(Handler aHandler) {
		mNext = aHandler;
		return mNext;
	}

	public final void handle(Trouble aTrouble) {
		if (resolve(aTrouble)) {
			done(aTrouble);
		}
		else if (mNext != null) {
			mNext.handle(aTrouble);
		}
		else {
			fail(aTrouble);
		}
	}
	
	protected abstract boolean resolve(Trouble aTrouble);
	
	protected void done(Trouble aTrouble) {
		System.out.println(aTrouble + " is resolved by " + this);
	}
	
	protected void fail(Trouble aTrouble) {
		System.out.println(aTrouble + " can't be resolved.");
	}
	
	public String toString() {
		return "[" + mName + "]";
	}
}
