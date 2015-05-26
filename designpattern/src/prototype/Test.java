package prototype;

public class Test {
	public void Run() {
		System.out.println("\nProtoType");
		Manager manager = new Manager();
		// ԭ��ģʽ����Ҫ�ȴ����ö���ԭ�Ͳ��洢��Ȼ������Ϊ������������
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
