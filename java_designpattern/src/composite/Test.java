package composite;

public class Test {
	public void Run() throws Exception {
		System.out.println("\nComposite");
		Directory root = new Directory("root");
		Directory subdir = new Directory("subdir");
		File file = new File("file1", 100);
		root.add(subdir);
		root.add(file);
		subdir.add(file);
		root.printList();
	}
}
