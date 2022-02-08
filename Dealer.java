import java.util.Random;

public class Dealer {
	final static int MAX_PLAYERS=4;
	final static int PILE_SIZE=5;
	final static int PILES=3;
	
	public static void main(String[] args) {
	
		Player[] players = new Player[MAX_PLAYERS];
		for (int i=0;i<MAX_PLAYERS;i++)
			players[i] = new Player(PILES, PILE_SIZE);
		
		Random rnd = new Random();
		int turn=0;
		while(true){
			Player p = players[turn];
			p.throwCard();
			p.addCard(rnd.nextInt(PILES));
			System.out.println("player #" + turn + p.toString());
			if  (isWin(p)) {
				System.out.println("player #" + turn + " won!!!");
				break;
			}
			turn = (turn+1)% MAX_PLAYERS;
		}

	}
	
	private static boolean isWin(Player p) {
		for (int i=0; i<PILES; i++) {
			if (p.getPileSize(i) == 10)
				return true;
		}
		return false;
	}

}
