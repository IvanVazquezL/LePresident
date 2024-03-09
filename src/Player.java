import java.util.List;

public class Player {
    private List<Card> deck;

    Player(List<Card> deck) {
        this.deck = deck;
    }

    public void checkDeck() {
        Deck.printDeck(deck);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
