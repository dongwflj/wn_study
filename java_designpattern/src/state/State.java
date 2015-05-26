package state;

// 表示在该状态下能够做的事情
public interface State {
	public abstract void doClock(AbstractSystem aSys, int aTime);
	public abstract void doUseSystem(AbstractSystem aSys);
	public abstract void doAlarm(AbstractSystem aSys);
	public abstract void doCall(AbstractSystem aSys);
}
