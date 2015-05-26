package bridge;

// 如果实现没变，只是基于实现的功能有了变化，则在功能层次上扩展，不需要改动实现层次
public class FunctionClass {
	// 实现类层次接口,根据实现不断扩展
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
