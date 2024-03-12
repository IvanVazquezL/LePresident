import java.io.Serializable;

public enum Rank implements Serializable {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JOKER("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    private final String rank;
    private final int value;

    Rank(String rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }
}
