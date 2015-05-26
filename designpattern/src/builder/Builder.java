package builder;

// ����Ҫ����һ�����Ӷ�������
public abstract class Builder {
	public abstract void makeTitle(String aTitle);
	public abstract void makeString(String aString);
	public abstract void makeItems(String[] aItems);
	public abstract Object getResult();
}
