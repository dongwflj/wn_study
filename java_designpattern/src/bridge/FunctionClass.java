package bridge;

// ���ʵ��û�䣬ֻ�ǻ���ʵ�ֵĹ������˱仯�����ڹ��ܲ������չ������Ҫ�Ķ�ʵ�ֲ��
public class FunctionClass {
	// ʵ�����νӿ�,����ʵ�ֲ�����չ
	private ImplementClass mImpl;
	public FunctionClass(ImplementClass aImpl) {
		this.mImpl = aImpl;
	}
	public void open() {
		mImpl.rawOpen();
	}
	public void print() {
		mImpl.rawPrint();
	}
	public void close() {
		mImpl.rawClose();
	}
	public final void doRealWork() {
		open();
		print();
		close();
	}
}
