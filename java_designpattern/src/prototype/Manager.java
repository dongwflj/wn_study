package prototype;

import java.util.Hashtable;

public class Manager {
	private Hashtable<String, Product> mTable = new Hashtable<String, Product>();
	public void register(String aName, Product aProto) {
		mTable.put(aName, aProto);
	}
	public Product create(String aName) {
		Product p = mTable.get(aName);
		return p.createClone();
	}
}
