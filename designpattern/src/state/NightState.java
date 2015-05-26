package state;

public class NightState implements State {
	private static NightState mInstance = new NightState();
	private NightState() {
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
		aSys.callSecurityCenter("Alarm, use system in night");
	}

	@Override
	public void doAlarm(AbstractSystem aSys) {
		aSys.callSecurityCenter("Ringing in night");
	}

	@Override
	public void doCall(AbstractSystem aSys) {
		aSys.callSecurityCenter("Call in night");
	}
	
	public String toString() {
		return "Night";
	}
}
