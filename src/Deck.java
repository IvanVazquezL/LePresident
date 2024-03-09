import java.util.*;

public class Deck {
    private List<Card> deck = new ArrayList<>();;
    private final int numberOfCards = 52;
    private final List<Suit> suits = List.of(Suit.values());
    private final List<Rank> ranks = List.of(Rank.values());
    private int numberOfPlayers;

    Deck(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;

        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    public List<Card> getDeckForPlayer() {
        Random random = new Random();
        List<Card> deckForPlayer = new ArrayList<>();
        int cardsForPlayer = Math.round(numberOfCards / numberOfPlayers);
        int randomIndex;

        for(int i = 0; i < cardsForPlayer; i++) {
            randomIndex = random.nextInt(deck.size());
            deckForPlayer.add(deck.get(randomIndex));
            deck.remove(randomIndex);
        }

        return deckForPlayer;
    }

    public static void printDeck(List<Card> deck) {
        // Define the number of rows in each card (assuming each card has 3 rows)
        int numRows = 4;
        int numberOfCard = 1;

        // Iterate over each row
        for (int i = 0; i < numRows; i++) {
            // Iterate over each card in the list
            for (Card card : deck) {
                // Print the corresponding row of each card
                switch (i) {
                    case 0:
                        System.out.print("|" + card.getSuit().getSymbol() + "\t\t|\t");
                        break;
                    case 1:
                        System.out.print("|  " + card.getRank().getRank() + "  \t|\t");
                        break;
                    case 2:
                        System.out.print("|    " + card.getSuit().getSymbol() + "  |\t");
                        break;
                    case 3:
                        System.out.print("    " + numberOfCard + "   \t");
                        numberOfCard++;
                        break;
                }
            }
            // Move to the next line after printing all cards in a row
            System.out.println();
        }
    }

    public static List<Card> sortByRanking(List<Card> deck) {
        Collections.sort(deck, Comparator.comparingInt(card -> card.getRank().getValue()));
        return deck;
    }

    public static List<Card> sortBySuitAndRanking(List<Card> deck) {
        // Sort the cards by suit and then rank
        Collections.sort(deck, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                int suitComparison = card1.getSuit().compareTo(card2.getSuit());
                if (suitComparison != 0) {
                    return suitComparison;
                }
                // If suits are equal, compare by rank
                return card1.getRank().compareTo(card2.getRank());
            }
        });

        return deck;
    }
}
