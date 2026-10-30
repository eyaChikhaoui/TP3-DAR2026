package act1.serveur;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
public class ClientProcess implements Runnable {
    private Socket socketClient;
    private int numeroClient;
    public ClientProcess(Socket socketClient, int numeroClient) {
        this.socketClient = socketClient;
        this.numeroClient = numeroClient;
    }
    @Override
    public void run() {
        try {
            // Créer un flux de sortie vers le client
            PrintWriter sortie = new PrintWriter(socketClient.getOutputStream(), true);
            // Envoyer le numéro d'ordre au client
            sortie.println("Vous êtes le client n°" + numeroClient);

            System.out.println("Message envoyé au client n°" + numeroClient);
        } catch (IOException e) {
            System.out.println("Erreur avec le client n°" + numeroClient + " : " + e.getMessage());
        } finally {
            try {
                socketClient.close();
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture de la connexion.");
            }
        }
    }
}
