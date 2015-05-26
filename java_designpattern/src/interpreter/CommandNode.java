package interpreter;

public class CommandNode extends Node {
	private Node mNode;
	@Override
	public void parse(Parser aParser) throws Exception {
		if (aParser.currentToken().equals("repeat")) {
			mNode = new RepeatCommandNode();
			mNode.parse(aParser);
		}
		else {
			mNode = new PrimitiveCommandNode();
			mNode.parse(aParser);
		}
	}
	public String toString() {
		return mNode.toString();
	}
}
