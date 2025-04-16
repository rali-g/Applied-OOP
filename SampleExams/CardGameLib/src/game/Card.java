package game;

public class Card {
    Faces face;
    Suits suit;

    public Card(Faces face, Suits suit) {
        setFace(face);
        setSuit(suit);
    }

    public Faces getFace() {
        return face;
    }

    public void setFace(Faces face) {
        for(int i = 0; i < Faces.values().length; i++){
            if (Faces.values()[i] == face){
                this.face = face;
                return;
            }
        }
        face = Faces.valueOf("Unknown");
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        for(int i = 0; i < Suits.values().length; i++){
            if (Suits.values()[i] == suit){
                this.suit = suit;
                return;
            }
        }
        suit = Suits.valueOf("Unknown");
    }

    @Override
    public String toString() {
        return face.toString() + " of " + suit.toString();
    }
}
