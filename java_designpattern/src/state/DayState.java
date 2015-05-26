package state;

public class DayState implements State {
	private static DayState mInstance = new DayState();
	private DayState() {
	}
	
	public static State getInstance() {
		return mInstance;
	}
	
	@Override
	public void doClock(AbstractSystem aSys, int aTime) {
		// Do some time related task
		aSys.changeState(aTime);
	}

	@Override
	public void doUseSystem(AbstractSystem aSys) {
		aSys.recordLog("Use sys in day, ok");
	}

	@Override
	public void doAlarm(AbstractSystem aSys) {
		aSys.callSecurityCenter("Ringing in day");
	}

	@Override
	public void doCall(AbstractSystem aSys) {
		aSys.callSecurityCenter("Call in day");
	}
	
	public String toString() {
		return "Day";
	}
}
