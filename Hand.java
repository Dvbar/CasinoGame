package blackjack;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Hand {

    //list from UI
    private ObservableList<Node> cards;
    //
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    private int aces = 0;

    //consructor for Hand
    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    //Hand takes card from deck
    public void takeCard(Card card) {
        cards.add(card);

        if (card.rank == Rank.ACE) {
            aces++;
        }

        if (value.get() + card.value > 21 && aces > 0) {
            value.set(value.get() + card.value - 10);
            aces --;
        }
        else {
            value.set(value.get() + card.value);
        }
    }

    //reset the hand
    public void reset() {
        cards.clear();
        value.set(0);
        aces = 0;
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}



