package prototype;

public class Test {
	public void Run() {
		System.out.println("\nProtoType");
		Manager manager = new Manager();
		// 原型模式必须要先创建好对象原型并存储，然后依次为基础创建对象
		MessageBox box = new MessageBox('*');
		MessageBox box2 = new MessageBox('-');
		manager.register("asterisk", box);
		manager.register("line", box2);
		Product p1 = manager.create("asterisk");
		Product p2 = manager.create("line");
		p1.use("Product 1");
		p2.use("Product 2");
	}
}
