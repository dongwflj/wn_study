package interpreter;

public class RepeatCommandNode extends Node {
	private int mNumber;
	private Node mCommandListNode;
	@Override
	public void parse(Parser aParser) throws Exception {
		aParser.skipToken("repeat");
		mNumber = aParser.currentNumber();
		aParser.nextToken();
		mCommandListNode = new CommandListNode();
		mCommandListNode.parse(aParser);
	}
	public String toString() {
		return "[repeat " + mNumber + " " + mCommandListNode + "]";
	}
}
