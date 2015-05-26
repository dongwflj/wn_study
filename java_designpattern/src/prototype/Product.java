package prototype;

public abstract class Product implements Cloneable {
	public abstract void use(String aString);
	public abstract Product createClone();
}
