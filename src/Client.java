import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 12345;

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            List<Card> deck = (List<Card>) in.readObject();
            // Now that the deck has been sent, print it on the server side

            Deck.printDeckForCommandLine(deck, true);

            System.out.println("Select cards");
            String selectedCards = scanner.nextLine();
            String[] cardsPosition = selectedCards.split(" ");
            List<Integer> indexList = new ArrayList<>();
            Card cardSelected;
            List<Card> cardsOnTable = new ArrayList<>();
            int cardIndex;

            for (int i = 0; i < cardsPosition.length; i++) {
                // TODO: Check if they have the same ranking else error
                cardIndex = Integer.parseInt(cardsPosition[i]) - 1;
                cardSelected = deck.get(cardIndex);
                cardsOnTable.add(cardSelected);

                indexList.add(cardIndex);
            }

            for (Integer index : indexList) {
                deck.remove(index);

            }

            Deck.printDeckForCommandLine(cardsOnTable, false);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}