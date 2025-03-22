package fig07_09_11;// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.

import java.util.Random;

public class DeckOfCards {
    private Card[] deck; // array of Card objects
    private int currentCard; // index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
    private Random randomNumbers; // random number generator
    private final String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private final String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};

    // constructor fills deck of Cards
    public DeckOfCards() {

        deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
        randomNumbers = new Random(); // create random number generator

        // populate deck with Card objects
        for (int count = 0; count < deck.length; count++)
            deck[count] =
                    new Card(faces[count % 13], suits[count / 13]);
    } // end DeckOfCards constructor

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // after shuffling, dealing should start at deck[ 0 ] again
        currentCard = 0; // reinitialize currentCard

        // for each Card, pick another random Card and swap them
        for (int first = 0; first < deck.length; first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        } // end for
    } // end method shuffle

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length)
            return deck[currentCard++]; // return current Card in array
        else
            return null; // return null to indicate that all Cards were dealt
    }// end method dealCard

    public int getHandRank(Card[] hand) {
        if(hasFourOfAKind(hand)){
            return 1;
        }
        if(hasFullHouse(hand)){
            return 2;
        }
        if(hasFlush(hand)){
            return 3;
        }
        if(hasStraight(hand)){
            return 4;
        }
        if(hasThreeOfAKind(hand)){
            return 5;
        }
        if(hasTwoPairs(hand)){
            return 6;
        }
        if(hasPair(hand)){
            return 7;
        }
        return 8;
    }

    public String getHandRankLabel(int rank){
        String[] rankLabels = {
                "Four of a kind", "Full house", "Flush", "Straight", "ThreeOfAKind",
                "Two pairs", "One pair", "none"
        };
        return rankLabels[rank - 1];
    }

    //a)
    private boolean hasPair(Card[] hand) {
        int[] counters = totalHand(hand);

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 2) {
                return true;
            }
        }
        return false;
    }

    //b)
    private boolean hasTwoPairs(Card[] hand) {
        int[] counters = totalHand(hand);
        int pairs = 0;

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 2) {
                pairs++;
            }
            if (pairs == 2) {
                return true;
            }
        }
        return false;
    }

    //c)
    private boolean hasThreeOfAKind(Card[] hand) {
        int[] counters = totalHand(hand);

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 3) {
                return true;
            }
        }
        return false;
    }

    //d)
    private boolean hasFourOfAKind(Card[] hand) {
        int[] counters = totalHand(hand);

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 4) {
                return true;
            }
        }
        return false;
    }

    //e)
    private boolean hasFlush(Card[] hand) {
        String suit = hand[0].getSuit();

        for (int i = 1; i < hand.length; i++) {
            if (!suit.equals(hand[i].getSuit())) {
                return false;
            }
        }
        return true;
    }

    //f)
    //[1, 0, 0, ... 1, 1, 1, 1]
    //[1, 1, 1, 1, 1, 0 ...]
    private boolean hasStraight(Card[] hand) {
        int[] counters = totalHand(hand);
        int consecutive = 0;

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 1) {
                consecutive++;
            }else{
                consecutive = 0;
            }
        }
        if (consecutive == 5) {
            return true;
        }
        return consecutive == 4 && counters[0] == 1;
    }

    //g)
    private boolean hasFullHouse(Card[] hand) {
        return hasPair(hand) && hasThreeOfAKind(hand);
    }

    private int[] totalHand(Card[] hand) { //array of face counters
        int[] counters = new int[13];
        for (int i = 0; i < hand.length; i++) {
            String face = hand[i].getFace();
            for (int j = 0; j < faces.length; j++) {
                if (face.equals(faces[j])) {
                    counters[j]++;
                }
            }
        }
        return counters;
    }
} // end class DeckOfCards


