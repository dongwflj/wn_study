package state;

public class SecuritySystem implements AbstractSystem {
	private int mTime;
	private State mState = DayState.getInstance();
	@Override
	public void setTime(int aTime) {
		System.out.println("Current time is:" + aTime);
		mTime = aTime;
	}

	@Override
	public void changeState(int aTime) {
		if (aTime < 9 || aTime >= 17) {
			System.out.println("Change state from " + mState + " to " + NightState.getInstance());
			mState = NightState.getInstance();
		}
		else {
			System.out.println("Change state from " + mState + " to " + DayState.getInstance());
			mState = DayState.getInstance();
		}
	}

	@Override
	public void callSecurityCenter(String aMsg) {
		System.out.println("Security Center ringing:" + aMsg);
	}

	@Override
	public void recordLog(String aMsg) {
		System.out.println("Record:" + aMsg);
	}

	@Override
	public void triggerBySomeOne() {
		// 系统让状态做事，状态发现应该改状态会通知系统，然后由系统来改状态
		mState.doClock(this, mTime);
		mState.doAlarm(this);
		mState.doCall(this);
		mState.doUseSystem(this);
	}

}
