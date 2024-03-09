import java.util.List;

public class Player {
    List<Card> deck;

    Player(List<Card> deck) {
        this.deck = deck;
    }

    public void checkDeck() {
        Deck.printDeck(deck);
    }


}
