package memento;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class Game {
	private int mMoney;
	private Vector<String> mFruits = new Vector<String>();
	private Random mRandom = new Random();
	private static String[] mFruitName = {
		"Apple", "PineApple", "Banana", "Crape"
	};
	
	public Game(int aMoney) {
		mMoney = aMoney;
	}
	
	public int getMoney() {
		return mMoney;
	}
	
	public void play() {
		int result = mRandom.nextInt(6) + 1;
		if (result > 3) {
			mMoney += 100;
			System.out.println("Big number, you win");
		}
		else {
			mMoney -= 100;
			System.out.println("Small number, you lose");
		}
		if (result == 6) {
			String bunus = getFruit();
			mFruits.add(bunus);
			System.out.println("Excellent number, get bunus" + bunus);
		}
	}
	
	private String getFruit() {
		return mFruitName[mRandom.nextInt(mFruitName.length)];
	}
	
	public Memento createMemento() {
		Memento m = new Memento(mMoney);
		Iterator<String> iter = mFruits.iterator();
		while (iter.hasNext()) {
			m.addFruit((String)iter.next());
		}
		return m;
	}
	
	public void restoreMemento(Memento aMemento) {
		mMoney = aMemento.getMoney();
		mFruits = aMemento.getFruits();
	}
	
	public String toString() {
		return "[Money:" + mMoney + " Bunus:" + mFruits + "]";
	}
}
