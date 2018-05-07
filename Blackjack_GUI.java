import javax.swing.*;
/*public class gui_ttt {
	public static void main(String[]args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar MenuBar = new JMenuBar();
		MenuBar.setOpaque(true);
		MenuBar.setBackground(new Color(154, 165, 127));
		MenuBar.setPreferedSize(new Dimension(200, 20));

		JLabel Label = new JLabel();
		Label.setOpaque(true);
		Label.setBackground(new Color(248, 213, 131));
		Label.setPreferredSize(new Dimension(200, 180));

		frame.setJMenuBar(MenuBar);
		frame.getContentPane().add(Label, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

		Jbutton b = new JButton("click");
		b.setBounds();
	}
}
*/

package ??
import java fx.scene.Parent;
//
////
///
//
//
//

public class Card extends Parent {

	enum Suit {
		SPADES, DIAMONDS, CLUBS, HEARTS
	};
	enum Rank {
		TWO = 1, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6, SEVEN = 7, EIGHT = 8, NINE = 9, TEN = 10, JACK = 10, QUEEN = 10, KING = 10, ACE = 11;
		final int value;
		private Rank (int value) {
			this.value - value;
		}
	};

