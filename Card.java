package blackjack;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends parent {
//qualities of a card, Suit and Rank
    enum Suit {
        SPADES, DIAMONDS, CLUBS, HEARTS
    };
    enum Rank {
        TWO(1), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
        final int value;
        private Rank (int value) {
            this.value = value;
        }
    };

    public final Suit suit;
    public final Rank rank;
    public final int value;

// card constructor takes Suit and Rank
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

//display
    Rectangle rect = new Rectangle (70, 100);
    rect.setArcWidth(20);
    rect.setArcHeight(20);
    rect.setFill(Color.WHITE);

    Text text1 = new Text(rank.displayName());
        text1.setFont(Font.font(18));
        text1.setX(CARD_WIDTH - text1.getLayoutBounds().getWidth() - 10);
        text1.setY(text1.getLayoutBounds().getHeight());

        Text text2 = new Text(text1.getText());
        text2.setFont(Font.font(18));
        text2.setX(10);
        text2.setY(CARD_HEIGHT - 10);

        ImageView view = new ImageView(suit.image);
        view.setRotate(180);
        view.setX(CARD_WIDTH - 32);
        view.setY(CARD_HEIGHT - 32);

        getChildren().addAll(bg, new ImageView(suit.image), view, text1, text2);
    }
};


