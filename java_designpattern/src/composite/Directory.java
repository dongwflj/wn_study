package composite;

import java.util.Vector;
import java.util.Iterator;

public class Directory extends Entry {
	private String mName;
	private Vector<Entry> mDirectory = new Vector<Entry>();
	
	public Directory(String aName) {
		mName = aName;
	}
	@Override
	public String getName() {
		return mName;
	}

	@Override
	public int getSize() {
		int size = 0;
		Iterator<Entry> iter = mDirectory.iterator();
		while(iter.hasNext()) {
			Entry entry = (Entry)iter.next();
			size += entry.getSize();
		}
		return size;
	}

	@Override
	protected void printList(String aPrefix) {
		System.out.println(aPrefix + "/" + this);
		Iterator<Entry> iter = mDirectory.iterator();
		while (iter.hasNext()) {
			Entry entry = (Entry)iter.next();
			entry.printList(aPrefix + "/" + mName);
		}
	}
	
	public Entry add(Entry aEntry) {
		mDirectory.add(aEntry);
		return this;
	}
}
