package act2.serveur;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurObjet {
    private static final int PORT = 1234;
    private static int compteurGlobal = 0;

    // Methode synchronisee pour incrementer le compteur
    public static synchronized int incrementerCompteur() {
        compteurGlobal++;
        return compteurGlobal;
    }
    public static void main(String[] args) {
        int numeroClient = 0;
        try (
                ServerSocket serveurSocket = new ServerSocket(PORT)) {
            System.out.println("Serveur demarre...");
            System.out.println("En attente des connexions sur le port " + PORT);
            while (true) {
                Socket socketClient = serveurSocket.accept();
                numeroClient++;
                System.out.println("Client n°" + numeroClient + " connecte depuis : " + socketClient.getRemoteSocketAddress());
                Thread thread = new Thread(new ClientProcess(socketClient)
                );
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Erreur du serveur : " + e.getMessage());
        }
    }
}
