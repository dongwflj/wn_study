package prototype;

public class MessageBox extends Product {
	private char mDecoChar;
	
	public MessageBox(char aDecoChar) {
		mDecoChar = aDecoChar;
	}
	@Override
	public void use(String aString) {
		int len = aString.length();
		for (int i = 0; i < len + 4; i++) {
			System.out.print(mDecoChar);
		}
		System.out.println("");
		System.out.println(mDecoChar + " " + aString + " " + mDecoChar);
		System.out.println("");
		for (int i = 0; i < len + 4; i++) {
			System.out.print(mDecoChar);
		}
		System.out.println("");
	}

	// 使用clone创建对象
	@Override
	public Product createClone() {
		Product product = null;
		try {
			product = (Product)clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return product;
	}

}
