package game;

import java.util.Random;

public class EuchreGame {
    Card[] cards; // масив от всички карти в тестето от карти
    Card[] hand; // текущо изтеглена ръка от 5 карти
    String TRUMP; // константа на всяка отделна игра
    Random random; // генератор на случайни числа
    int dealCard; // брой карти изтеглени текущо от cards

    public static final String[] faces = {
            "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"
    };

    public static final String[] suits = {
            "CLUBS", "DIAMONDS", "HEARTS", "SPADES"
    };

    public EuchreGame() {
        this.cards = new Card[24];
        int ind = 0;
        for (int i = 0; i < faces.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                this.cards[ind++] = new Card(Faces.valueOf(faces[i]), Suits.valueOf(suits[j]));
            }
        }
        this.random = new Random();
        int curr = random.nextInt(suits.length);
        TRUMP = suits[curr];

        this.dealCard = 0;
        this.hand = new Card[5];
    }

    public void shuffleCards() {
        for (int i = 0; i < 24; i++) {
            int index = random.nextInt(24);
            Card temp = this.cards[index];
            this.cards[index] = this.cards[i];
            this.cards[i] = temp;
        }
        this.dealCard = 0;
    }

    public String printCards() {
        String result = "";
        int count = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) {
                result += hand[i].toString();
                count++;

                if (i < hand.length - 1 && hand[i + 1] != null) {
                    result += ", ";
                }

                if (count % 3 == 0) {
                    result += "\n";
                }
            }
        }
        result += "\n";
        result += "\nKoз: " + TRUMP;
        return result;
    }

    public boolean dealHand() {
        if (this.dealCard >= cards.length) {
            return false;
        }

        int remainingCards = cards.length - this.dealCard;
        int count = Math.min(remainingCards, this.hand.length);

        hand = new Card[count];
        for (int i = 0; i < count; i++) {
            hand[i] = this.cards[this.dealCard++];
        }
        return true;
    }

    public int countHandStrength() {
        int sum = 0;
        for (int i = 0; i < this.hand.length; i++) {
            Card current = hand[i];
            String face = current.getFace().toString();
            String suit = current.getSuit().toString();

            for (int j = 0; j < faces.length; j++) {
                if (face.equals(faces[j])) {
                    int value = j;

                    if (suit.equals(TRUMP)) {
                        value *= 2;
                    }
                    sum += value;
                    break;
                }
            }
        }
        return sum;
    }

    public boolean hasKingAndQueenTrump(){
        for (int i = 0; i < this.hand.length; i++) {
            Card current = hand[i];
            String face = current.getFace().toString();
            String suit = current.getSuit().toString();

            if (suit.equals(TRUMP) && face.equals(faces[3]) || suit.equals(TRUMP) && face.equals(faces[4])) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTwoTrumps (){
        int count = 0;
        for (int i = 0; i < this.hand.length; i++) {
            Card current = hand[i];
            String face = current.getFace().toString();
            String suit = current.getSuit().toString();

            if (suit.equals(TRUMP)) {
                count++;
            }
        }
        return count == 2;
    }
}
