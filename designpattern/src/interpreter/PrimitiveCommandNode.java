package interpreter;

public class PrimitiveCommandNode extends Node {
	private String mName;
	@Override
	public void parse(Parser aParser) throws Exception {
		mName = aParser.currentToken();
		aParser.skipToken(mName);
		if (!mName.equals("go") && !mName.equals("left") && !mName.equals("right")) {
			throw new Exception("Primitive command illegal");
		}
	}
	public String toString() {
		return mName;
	}
}
