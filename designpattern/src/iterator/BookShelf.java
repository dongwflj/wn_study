package iterator;

public class BookShelf implements Aggregate {
	private Book[] mBooks;
	private int mLast = 0;
	public BookShelf(int aMaxSize) {
		this.mBooks = new Book[aMaxSize];
	}
	public Book getBookAt(int aIndex) {
		return mBooks[aIndex];
	}
	public void appendBook(Book aBook) {
		this.mBooks[mLast] = aBook;
		mLast++;
	}
	public int getLength() {
		return mLast;
	}
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}
