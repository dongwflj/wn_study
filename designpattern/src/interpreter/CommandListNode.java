package interpreter;

import java.util.Vector;

public class CommandListNode extends Node {
	private Vector<CommandNode> mCommandList = new Vector<CommandNode>();
	@Override
	public void parse(Parser aParser) throws Exception {
		while (true) {
			if (aParser.currentToken() == null) {
				throw new Exception("No toke for command list");
			}
			else if (aParser.currentToken().equals("end")) {
				aParser.skipToken("end");
				break;
			}
			else {
				CommandNode node = new CommandNode();
				node.parse(aParser);
				mCommandList.add(node);
			}
		}
	}
	public String toString() {
		return "" + mCommandList;
	}
}
