package act1.serveur;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Serveur {
    private static final int PORT = 1234;
    public static void main(String[] args) {
        int numeroClient = 0;

        try (ServerSocket serveurSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur démarré...");
            System.out.println("En attente des connexions sur le port " + PORT);

            while (true) {
                // Attendre et accepter une connexion cliente
                Socket socketClient = serveurSocket.accept();
                // Attribuer un numéro au client
                numeroClient++;
                int numero = numeroClient;
                // Afficher les informations du client
                System.out.println("Client n°" + numero + " connecté depuis : " + socketClient.getRemoteSocketAddress());
                // Créer un thread pour traiter ce client
                Thread thread = new Thread(new ClientProcess(socketClient, numero));
                // Démarrer le thread
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Erreur du serveur : " + e.getMessage());
        }
    }
}
