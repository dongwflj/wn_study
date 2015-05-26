package strategy;

public class Test {
	public void Run() {
		System.out.println("\nStrategy");
		int start = (int)System.currentTimeMillis();
		Player winPlayer = new Player("winPlayer", new WiningStrategy(start));
		Player learnPlayer = new Player("learnPlayer", new LearnStrategy(start));
		for (int i = 0; i < 100; i++) {
			Hand hand1 = winPlayer.nextHand();
			Hand hand2 = learnPlayer.nextHand();
			System.out.println("winPlayer:" + hand1.toString() + " vs " +
								"learnPlayer:" + hand2.toString());
			if (hand1.isStrongerThan(hand2)) {
				winPlayer.win();
				learnPlayer.lose();
				System.out.println("winPlayer win");
			}
			else if(hand2.isStrongerThan(hand1)) {
				learnPlayer.win();
				winPlayer.lose();
				System.out.println("learnPlayer win");
			}
			else {
				winPlayer.even();
				learnPlayer.even();
				System.out.println("even");
			}
		}
		System.out.println(winPlayer);
		System.out.println(learnPlayer);
	}
}
