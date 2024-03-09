public enum Suit {
    CLUBS("\u001B[32m\u2663\u001B[0m"),
    DIAMONDS("\u001B[34m\u2666\u001B[0m"),
    HEARTS("\u001B[31m\u2665\u001B[0m"),
    SPADES("\u001B[33m\u2660\u001B[0m");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
