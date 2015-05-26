package bridge;

// 一件事情的具体实现独立成为一套类体系，这样只有具体的实现发生变化才涉及到重写
public abstract class ImplementClass {
	public abstract void rawOpen();
	public abstract void rawPrint();
	public abstract void rawClose();
}
