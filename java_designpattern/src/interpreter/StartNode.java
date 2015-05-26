package interpreter;

// <start> :: = start <command list>
public class StartNode extends Node {
	private Node mCommandListNode;
	
	@Override
	public void parse(Parser aParser) throws Exception {
		aParser.skipToken("start");
		mCommandListNode = new CommandListNode();
		mCommandListNode.parse(aParser);
	}
	public String toString() {
		return "[start " + mCommandListNode + "]";
	}
}
