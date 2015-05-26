package composite;

public abstract class Entry {
	public abstract String getName();
	public abstract int getSize();
	public Entry add(Entry aEntry) throws FileTreatException {
		throw new FileTreatException();
	}
	
	public void printList() {
		printList("");
	}
	
	protected abstract void printList(String aPrefix);
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}
