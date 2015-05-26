package state;

public class Test {
	public void Run() {
		System.out.println("\nState");
		AbstractSystem sys = new SecuritySystem();
		for (int i = 0; i < 24; i++) {
			sys.setTime(i);
			sys.triggerBySomeOne();
		}
	}
}
