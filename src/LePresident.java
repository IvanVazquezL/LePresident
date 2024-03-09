import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LePresident {
    private final Scanner scanner = new Scanner(System.in);
    List<Player> players = new ArrayList<>();

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

        for( Player player : players) {
            player.checkDeck();
        }
        //Deck.printDeck(deck);
    }
}
