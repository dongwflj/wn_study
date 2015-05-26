package composite;

public class File extends Entry {
	private String mName;
	private int mSize;
	
	public File(String aName, int aSize) {
		mName = aName;
		mSize = aSize;
	}
	
	@Override
	public String getName() {
		return mName;
	}

	@Override
	public int getSize() {
		return mSize;
	}

	@Override
	protected void printList(String aPrefix) {
		System.out.println(aPrefix + "/" + this);
	}

}
