package builder;

public class Manager {
	private Builder builder;
	public Manager(Builder aBuilder) {
		this.builder = aBuilder;
	}
	// ����Builder�ṩ�������װһ�����ӵĶ���,ʹ�ó���д����
	public Object buildObject() {
		builder.makeTitle("title");
		builder.makeString("String 1");
		builder.makeItems(new String[] {"item1", "item2",});
		builder.makeString("String 2");
		builder.makeItems(new String[] {"item3", "item4"});
		return builder.getResult();
	}
}
