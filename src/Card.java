import java.io.Serializable;

public class Card implements Serializable {
    private Rank rank;
    private Suit suit;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("""
                |%s      |
                |   %s   |
                |      %s|
                """, suit.getSymbol(), rank.getRank(), suit.getSymbol());
    }

    public void printCard() {
        System.out.println("|" + suit.getSymbol() + "\t|\t");
        System.out.println("|  " + rank.getRank() + "  \t|\t");
        System.out.println("|    " + suit.getSymbol() + "  |\t");
    }
}