import java.util.List;

public class Player {
    private List<Card> deck;

    Player(List<Card> deck) {
        this.deck = deck;
    }

    public void checkDeck() {
        Deck.printDeck(deck, true);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

    public String getPositions(int numberOfCards, int value) {
        // TODO:
        return "1 3";
    }
}
