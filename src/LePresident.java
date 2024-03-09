import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LePresident {
    private final Scanner scanner = new Scanner(System.in);
    private List<Player> players = new ArrayList<>();
    private Player yourPlayer;

    LePresident() {}

    public void startGame() {
        System.out.print("Number of players: ");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        List<Card> deckForPlayer;

        Deck deck = new Deck(numberOfPlayers);


        for (int i = 0; i < numberOfPlayers; i++) {
            deckForPlayer = deck.getDeckForPlayer();
            players.add(new Player(deckForPlayer));
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

        yourPlayer.setDeck(Deck.sortBySuitAndRanking(yourPlayer.getDeck()));
        yourPlayer.checkDeck();
    }
}
