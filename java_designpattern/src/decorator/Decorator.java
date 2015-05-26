package decorator;

public abstract class Decorator extends Display {
	protected Display mDisplay;

	public Decorator(Display aDisplay) {
		mDisplay = aDisplay;
	}
}
