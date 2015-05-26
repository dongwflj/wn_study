package strategy;

public class Hand {
	private static final int STONE = 0;
	private static final int JIANDAO = 1;
	private static final int BU = 2;
	
	private int mHandValue;
	
	private static final String[] mName = {
		"Stone", "JianDao", "Bu"
	};
	
	private static final Hand[] mHand = {
		new Hand(STONE),
		new Hand(JIANDAO),
		new Hand(BU)
	};
	
	public Hand(int aValue) {
		this.mHandValue = aValue;
	}
	
	public static Hand getHand(int aValue) {
		return mHand[aValue];
	}
	
	public boolean isStrongerThan(Hand aHand) {
		return fight(aHand) == 1;
	}
	
	private int fight(Hand aHand) {
		if (this == aHand) {
			return 0;
		}
		else if ((this.mHandValue + 1) % 3 == aHand.mHandValue) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public String toString() {
		return mName[mHandValue];
	}
}
