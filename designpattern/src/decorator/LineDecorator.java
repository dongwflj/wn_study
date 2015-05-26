package decorator;

public class LineDecorator extends Decorator {

	public LineDecorator(Display aDisplay) {
		super(aDisplay);
	}
	@Override
	public String getText() {
		return "|" + mDisplay.getText() + "|";
	}

}
