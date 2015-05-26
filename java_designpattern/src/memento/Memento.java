package memento;

import java.util.Vector;

public class Memento {
	private int mMoney;
	private Vector<String> mFruits;
	public int getMoney() {
		return mMoney;
	}
	public Memento(int aMoney) {
		mMoney = aMoney;
		mFruits = new Vector<String>();
	}
	public void addFruit(String aFruit) {
		mFruits.add(aFruit);
	}
	@SuppressWarnings("unchecked")
	public Vector<String> getFruits() {
		return (Vector<String>)mFruits.clone();
	}
}
