package state;

// ��ʾ�ڸ�״̬���ܹ���������
public interface State {
	public abstract void doClock(AbstractSystem aSys, int aTime);
	public abstract void doUseSystem(AbstractSystem aSys);
	public abstract void doAlarm(AbstractSystem aSys);
	public abstract void doCall(AbstractSystem aSys);
}
