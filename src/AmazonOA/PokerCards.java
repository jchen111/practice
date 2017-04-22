package AmazonOA;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb on 1/22/17.
 */
public class PokerCards {
    class Card {
        // codes for the 4 suits
        public final static int SPADES = 0;
        public final static int HEARTS = 1;
        public final static int DIAMONDS = 2;
        public final static int CLUBS = 3;

        public final static int ACE = 1;
        public final static int JACK = 11;
        public final static int QUEEN = 12;
        public final static int KING = 13;

        private int value;
        private int suit;

        public Card(int v, int s) {
            this.value = v;
            this.suit = s;
        }

        public int getValue() {
            return value;
        }

        public int getSuit() {
            return suit;
        }
    }

    class Deck {
        private List<Card> cards;

        public Deck() {
            cards = new ArrayList<Card>();
            for(int suit = 0; suit < Card.CLUBS; suit++){
                for(int value = 1; value < Card.KING; value++){
                    cards.add(new Card(value,suit));
                }
            }
        }

        public void shuffle() {
            List<Card> shuffledCards = new ArrayList<Card>();
            while(!cards.isEmpty()){
                shuffledCards.add(cards.remove((int)Math.floor(Math.random()*cards.size())));
            }
            cards = shuffledCards;
        }
    }
}
