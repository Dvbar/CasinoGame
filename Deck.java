package blackjack;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Deck {
    private Card[] cards = new Card[52];

    public Deck() {
        refill();
    }
//refills deck with all ranks from all suits
    public final void refill() {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()){
                cards[i++] = new Card(suit, rank);
            }
        }
    }
//pulls random card from deck and returns it
    public Card drawCard() {
        Card card = null;
        while (card == null) {
            int index = (int)(Math.random()*cards.length);
            card = cards[index];
            cards[index] = null;
        }
        return card;
    }
}


