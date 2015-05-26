package memento;

public class Test {
	public void Run() throws Exception {
		System.out.println("\nMemento");
		Game game = new Game(100);
		Memento m = game.createMemento();
		for (int i = 0; i < 100; i++) {
			game.play();
			System.out.println(game);
			
			if (game.getMoney() > m.getMoney()) {
				System.out.println("Win, Save your money");
				m = game.createMemento();
			}
			else if (game.getMoney() < 100) {
				System.out.println("Your money is less than 100, restore");
				game.restoreMemento(m);
			}
		}
		System.out.println(game);
	}
}
