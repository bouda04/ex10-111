import java.util.Arrays;

public class Player {
	int[] cards;
	
	public Player(int piles, int count) {
		this.cards = new int[piles];
		for (int i=0; i< cards.length;i++)
			cards[i] = count;
	}
	
	public int throwCard() {
		int i=0;
		while (cards[i]==0)
			i++;
		int minColor=i;
		for (; i<cards.length;i++) {
			if (cards[i] > 0 && cards[i]<cards[minColor])
				minColor = i;
		}
		cards[minColor]--;
		return minColor;
	}
	
	public void addCard(int color) {
		this.cards[color]++;
	}
	
	public int getPileSize(int color) {
		return cards[color];
	}
	
	public String toString() {
		return Arrays.toString(cards);
	}
}
