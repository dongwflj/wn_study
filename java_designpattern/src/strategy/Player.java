package strategy;

public class Player {
	private String mName;
	private Strategy mStrategy;
	private int mWinCount;
	private int mLoseCount;
	private int mEvenCount;
	
	public Player(String aName, Strategy aStrategy) {
		mName = aName;
		mStrategy = aStrategy;
	}
	
	public Hand nextHand() {
		return mStrategy.nextHand();
	}
	
	public void win() {
		mStrategy.study(true);
		mWinCount++;
	}
	
	public void lose() {
		mStrategy.study(false);
		mLoseCount++;
	}
	
	public void even() {
		mEvenCount++;
	}
	
	public String toString() {
		return "[" + mName + ":Win=" + mWinCount +
				" Lose=" + mLoseCount + " Even=" + mEvenCount +"]";
	}
}
