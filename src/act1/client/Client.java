package act1.client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 1234)) {

            System.out.println("Connexion au serveur réussie.");

            // Recevoir le message envoyé par le serveur
            BufferedReader entree = new BufferedReader(new InputStreamReader(socket.getInputStream())
            );

            String message = entree.readLine();

            System.out.println("Message du serveur : " + message);

        } catch (IOException e) {

            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
