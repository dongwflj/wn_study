package iterator;

public class BookShelfIterator implements Iterator {
	private BookShelf mBookShelf;
	private int mIndex;
	
	public BookShelfIterator(BookShelf aBookShelf) {
		this.mBookShelf = aBookShelf;
		this.mIndex = 0;
	}
	@Override
	public boolean hasNext() {
		if (mIndex < mBookShelf.getLength()) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		Book book = mBookShelf.getBookAt(mIndex);
		mIndex++;
		return book;
	}

}
