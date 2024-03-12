import java.util.List;

public class Player {
    private List<Card> deck;
    private String name;
    private Hierarchy hierarchy;
    private Status status;

    Player(String name, List<Card> deck, Hierarchy hierarchy, Status status) {
        this.name = name;
        this.deck = deck;
        this.hierarchy = hierarchy;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
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
