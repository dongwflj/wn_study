package builder;

// 定义要生成一个复杂对象的零件
public abstract class Builder {
	public abstract void makeTitle(String aTitle);
	public abstract void makeString(String aString);
	public abstract void makeItems(String[] aItems);
	public abstract Object getResult();
}
