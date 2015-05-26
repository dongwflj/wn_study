package singleton;

public class Singleton {
	private static Singleton mSingleton = new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		return mSingleton;
	}
}
