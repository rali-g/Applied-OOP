package fig07_09_11;// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.

public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order

      Card[] rightHand = new Card[5];
      Card[] leftHand = new Card[5];
      System.out.printf("%-20s%-20s%n", "Left hand:", "Right hand:");
      for(int i = 0; i<leftHand.length; i++){
         rightHand[i] = myDeckOfCards.dealCard();
         leftHand[i] = myDeckOfCards.dealCard();

         System.out.printf("%-20s%-20s%n", leftHand[i], rightHand[i]);
      }

      System.out.println("\nHand values:");
      int rightHandRank = myDeckOfCards.getHandRank(rightHand);
      int leftHandRank = myDeckOfCards.getHandRank(leftHand);
      String rightHandRankLabel = myDeckOfCards.getHandRankLabel(rightHandRank);
      String leftHandRankLabel = myDeckOfCards.getHandRankLabel(leftHandRank);

      System.out.printf("%-20s%-20s%n", leftHandRankLabel, rightHandRankLabel);

      String winninHand = rightHandRank < leftHandRank ? "right" : "left";
      if(rightHandRank == leftHandRank){
         System.out.println("Result: both hands are equal.");
      }  else{
         System.out.printf("Result: %s hand is better.", winninHand);
      }
      
      // print all 52 Cards in the order in which they are dealt
//      for ( int i = 0; i < 13; i++ )
//      {
//         // deal and print 4 Cards
//         System.out.printf( "%-20s%-20s%-20s%-20s\n", 
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),  
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
//      } // end for
   } // end main
} // end class DeckOfCardsTest

