import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LePresident {
    private final Scanner scanner = new Scanner(System.in);
    private List<Player> players = new ArrayList<>();
    private List<Card> cardsOnTable = new ArrayList<>();
    private final int numberOfPlayers = 5;
    private Stack<Hierarchy> hierarchies = new Stack<>();

    LePresident() {
        hierarchies.add(Hierarchy.ASSHOLE);
        hierarchies.add(Hierarchy.VICEASSHOLE);
        hierarchies.add(Hierarchy.CITIZEN);
        hierarchies.add(Hierarchy.VICEPRESIDENT);
        hierarchies.add(Hierarchy.PRESIDENT);
    }

    public void startGame() {
        Deck deck = new Deck(numberOfPlayers);

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(
                new Player(
                    String.valueOf(i + 1),
                    deck.getDeckForPlayer(),
                    Hierarchy.CITIZEN,
                    Status.PLAYING
                )
            );
        }

        int turnOfPlayer = 0;

        do {
                Player player = players.get(turnOfPlayer);
                if (player.getStatus() == Status.PASS) {
                    System.out.println("Player " + player.getName() + "passed!");
                    turnOfPlayer = turnOfPlayer == 4 ? 0 : turnOfPlayer + 1;
                    continue;
                }

                if (player.getStatus() == Status.FINISHED) {
                    turnOfPlayer = turnOfPlayer == 4 ? 0 : turnOfPlayer + 1;
                    continue;
                }

                Boolean winRoundByPass = true;

                for (Player playerTemp : players) {
                    if (!playerTemp.getName().equals(player.getName())) {
                        if (playerTemp.getStatus() != Status.PASS) {
                            winRoundByPass = false; // If any player hasn't passed, set to false
                            break; // No need to continue checking, we found a player who hasn't passed
                        }
                    }
                }

                if (winRoundByPass) {
                    System.out.println("Player " + player.getName() + " won the round!");

                    // set to false the pass status
                    for (Player playerTemp : players) {
                        playerTemp.setStatus(Status.PLAYING);
                    }
                    continue;
                }

                System.out.println("Player " + player.getName() + " turn");
                System.out.println("Your deck");
                player.checkDeck();

                System.out.println("Select cards");

                String selectedCards = scanner.nextLine();
                if (selectedCards.toLowerCase().equals("pass")) {
                    Deck.printDeck(cardsOnTable, false);
                    turnOfPlayer = turnOfPlayer == 4 ? 0 : turnOfPlayer + 1;
                    player.setStatus(Status.PASS);
                    continue;
                }
                cardsOnTable.clear();
                String[] cardsPosition = selectedCards.split(" ");
                Card cardSelected;
                int cardIndex;
                List<Card> tempDeck = player.getDeck();


                for (int j = 0; j < cardsPosition.length; j++) {
                    // TODO: Check if they have the same ranking else error
                    cardIndex = Integer.parseInt(cardsPosition[j]) - 1;
                    cardSelected = tempDeck.get(cardIndex);
                    cardsOnTable.add(cardSelected);
                }

                for (Card cardToRemove : cardsOnTable) {
                    tempDeck.remove(cardToRemove);
                }

                // set deck without used cards
                player.setDeck(tempDeck);

                Deck.printDeck(cardsOnTable, false);

                if (player.getDeck().isEmpty()) {
                    Hierarchy hierarchy = hierarchies.pop();
                    System.out.println("Player " + player.getName() + " is the " + hierarchy.getHierarchy());
                    player.setHierarchy(hierarchy);
                    player.setStatus(Status.FINISHED);
                }

                Boolean winRound = true;

                for (Card cardOnTable : cardsOnTable) {
                    if (cardOnTable.getRank() != Rank.ACE) {
                        winRound = false;
                    }
                }

                if (winRound) {
                    System.out.println("Player " + player.getName() + " won the round!");

                    for (Player playerTemp : players) {
                        playerTemp.setStatus(Status.PLAYING);
                    }
                    continue;
                }

            turnOfPlayer = turnOfPlayer == 4 ? 0 : turnOfPlayer + 1;
        } while(true);
    }
}
