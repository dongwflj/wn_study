package iterator;

public class Test {
	public void Run() {
		System.out.println("\nIterator");
		BookShelf container = new BookShelf(10);
		container.appendBook(new Book("Book1"));
		container.appendBook(new Book("Book2"));
		container.appendBook(new Book("Book3"));
		container.appendBook(new Book("Book4"));
		container.appendBook(new Book("Book5"));
		container.appendBook(new Book("Book6"));
		container.appendBook(new Book("Book7"));
		container.appendBook(new Book("Book8"));
		container.appendBook(new Book("Book9"));
		container.appendBook(new Book("Book10"));
		Iterator iter = container.iterator();
		// while循环和BookShelf无关，可以独立变化
		while (iter.hasNext()) {
			Book book = (Book)iter.next();
			System.out.println(book.getName());
		}
	}
}
