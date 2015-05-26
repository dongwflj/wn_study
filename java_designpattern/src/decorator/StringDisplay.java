package decorator;

public class StringDisplay extends Display {
	private String mText;
	public StringDisplay(String aText) {
		mText = aText;
	}
	
 	@Override
	public String getText() {
		return mText;
	}

}
