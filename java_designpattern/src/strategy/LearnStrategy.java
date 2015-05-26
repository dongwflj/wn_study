package strategy;

public class LearnStrategy implements Strategy {
	private int mPrevHandValue = 0;
	private int mCurrentHandValue = 0;
	private int[][] mHistory = {
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0},
	};

	public LearnStrategy(int aSeeds) {
		
	}
	
	@Override
	public Hand nextHand() {
		mCurrentHandValue = findMax(mHistory[mPrevHandValue]);	
		return Hand.getHand(mCurrentHandValue);
	}

	private int findMax(int[] aRate) {
		int max = 0;
		for (int i = 1; i < 3; i++) {
			if (aRate[max] < aRate[i]) {
				max = i;
			}
		}
		return max;
	}
	
	@Override
	public void study(boolean aWin) {
		if (aWin) {
			mHistory[mPrevHandValue][mCurrentHandValue]++;
		}
		else {
			mHistory[mPrevHandValue][(mCurrentHandValue + 1) % 3]++;
			mHistory[mPrevHandValue][(mCurrentHandValue + 2) % 3]++;
		}
	}

}
