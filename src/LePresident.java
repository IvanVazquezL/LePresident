import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LePresident {
    private final Scanner scanner = new Scanner(System.in);
    private List<Player> players = new ArrayList<>();
    private List<Card> cardsOnTable = new ArrayList<>();
    private final int numberOfPlayers = 5;
    private Player yourPlayer;

    LePresident() {}

    public void startGame() {
        Deck deck = new Deck(numberOfPlayers);

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(deck.getDeckForPlayer()));
        }

        yourPlayer = players.get(0);

        System.out.println("Your deck");
        yourPlayer.checkDeck();

        System.out.println("""
                1) Sort deck by ranking
                2) Sort deck by suit and ranking
                """);


        yourPlayer.setDeck(Deck.sortByRanking(yourPlayer.getDeck()));
        yourPlayer.checkDeck();

        //yourPlayer.setDeck(Deck.sortBySuitAndRanking(yourPlayer.getDeck()));
        //yourPlayer.checkDeck();
        System.out.println("Select cards");
        String selectedCards = scanner.nextLine();
        String[] cardsPosition = selectedCards.split(" ");
        List<Integer> indexList = new ArrayList<>();
        Card cardSelected;
        int cardIndex;


        for (int i = 0; i < cardsPosition.length; i++) {
            // TODO: Check if they have the same ranking else error
            cardIndex = Integer.parseInt(cardsPosition[i]) - 1;
            cardSelected = yourPlayer.getDeck().get(cardIndex);
            cardsOnTable.add(cardSelected);

            indexList.add(cardIndex);
        }

        for (Integer index : indexList) {
            yourPlayer.getDeck().remove(index);

        }

        Deck.printDeck(cardsOnTable, false);

        players.get(1).checkDeck();
    }
}
