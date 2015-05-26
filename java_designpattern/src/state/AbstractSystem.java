package state;

public interface AbstractSystem {
	public abstract void setTime(int aTime);
	public abstract void changeState(int aTime);
	public abstract void callSecurityCenter(String aMsg);
	public abstract void recordLog(String aMsg);
	public abstract void triggerBySomeOne();
}
