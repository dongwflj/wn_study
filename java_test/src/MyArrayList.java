import java.util.LinkedList;
import java.util.List;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULTSIZE = 100;
	private int m_Size;
	private AnyType[] m_Items;
	
	public MyArrayList() {
		clear();
	}
	
	public void clear() {
		m_Size = 0;
		ensureSize(DEFAULTSIZE);
	}
	
	public AnyType get(int index) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return m_Items[index];
	}
	
	public AnyType set(int index, AnyType newValue) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType old = m_Items[index];
		m_Items[index] = newValue;
		return old;
	}
	
	public boolean append(AnyType newValue) {
		insert(size(), newValue);
		return true;
	}
	
	public AnyType insert(int index, AnyType newValue) {
		if (m_Items.length >= size()) {
			ensureSize(size() * 2 + 1);
		}
		for (int i=size(); i>index; i--) {
			m_Items[i] = m_Items[i-1];
		}
		m_Items[index] = newValue;
		m_Size++;
		return newValue;
	}
	
	@SuppressWarnings("unchecked")
	private void ensureSize(int size) {
		if (size < m_Size) {
			return;
		}
		AnyType[] old = m_Items;
		m_Items = (AnyType[]) new Object[size];
		for (int i=0; i<m_Size; i++) {
			m_Items[i] = old[i];
		}
	}
	
	public int size() {
		return m_Size;
	}
	
	public AnyType remove(int idx) {
		AnyType removed = m_Items[idx];
		for (int i=idx; i<size()-1; i++) {
			m_Items[i] = m_Items[i+1];
		}
		m_Size--;
		return removed;
	}
	
	public java.util.Iterator<AnyType> iterator() {
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements java.util.Iterator<AnyType> {
		private int current;

		@Override
		public boolean hasNext() {
			return current < size();
		}
		
		@Override
		public AnyType next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			return m_Items[current++];
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(--current);
		}
	}
}
