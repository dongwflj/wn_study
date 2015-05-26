package interpreter;

public class Test {
	public void Run() throws Exception {
		System.out.println("\nInterpreter");
		String buf = "start go repeat 10 left go right end go right end";
		StartNode node = new StartNode();
		node.parse(new Parser(buf));
		System.out.println(node);
	}
}
