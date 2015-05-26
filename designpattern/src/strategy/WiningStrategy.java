package strategy;

import java.util.Random;

public class WiningStrategy implements Strategy {
	private Random mRandom;
	private Hand mPrivHand;
	private boolean mIsWin = false;
	public WiningStrategy(int aSeed) {
		mRandom = new Random(aSeed);
	}
	
	public Hand nextHand() {
		if (!mIsWin) {
			mPrivHand = Hand.getHand(mRandom.nextInt(3));
		}
		return mPrivHand;
	}
	
	public void study(boolean aWin) {
		mIsWin = aWin;
	}
}
