package builder;

public class Manager {
	private Builder builder;
	public Manager(Builder aBuilder) {
		this.builder = aBuilder;
	}
	// 根据Builder提供的零件组装一个复杂的对象,使用抽象写程序
	public Object buildObject() {
		builder.makeTitle("title");
		builder.makeString("String 1");
		builder.makeItems(new String[] {"item1", "item2",});
		builder.makeString("String 2");
		builder.makeItems(new String[] {"item3", "item4"});
		return builder.getResult();
	}
}
