package decorator;

public class FullDecorator extends Decorator {

	public FullDecorator(Display aDisplay) {
		super(aDisplay);
	}
	
	@Override
	public String getText() {
		String full = "-----------------------\n" + 
					mDisplay.getText() + "\n---------------------------"; 
		return full;
	}
}
