import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;
        final int NUM_PLAYERS = 5;
        Deck deck = new Deck(NUM_PLAYERS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");

            for (int i = 0; i < NUM_PLAYERS; i++) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                Player player = new Player(deck.getDeckForPlayer());
                sendDeckToClient(clientSocket, player);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendDeckToClient(Socket clientSocket, Player player) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(player.getDeck());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
