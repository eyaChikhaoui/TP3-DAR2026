package act2.serveur;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;
import act2.op.Operation;
public class ClientProcess implements Runnable {
    private Socket socketClient;
    public ClientProcess(Socket socketClient) {
        this.socketClient = socketClient;
    }
    @Override
    public void run() {
        try {
            // Creation des flux
            ObjectInputStream ois = new ObjectInputStream(socketClient.getInputStream());
            PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
            // Reception de l'objet Operation
            Operation operation = (Operation) ois.readObject();
            System.out.println("Operation recue : "
                    + operation.getOperande1() + " " + operation.getOperateur() + " " + operation.getOperande2());
            // Calcul du resultat
            double resultat = calculer(operation);
            System.out.println("Resultat calcule : " + resultat);
            // Incrementation du compteur global
            int compteur = ServeurObjet.incrementerCompteur();
            System.out.println("Nombre total d'operations : " + compteur);
            // Envoi du resultat au client
            out.println(resultat);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du traitement du client : " + e.getMessage());
        } finally {
            try {
                socketClient.close();
            } catch (IOException e) {
                System.out.println("Erreur lors de la fermeture du socket.");
            }
        }
    }

    private double calculer(Operation op) {
        double a = op.getOperande1();
        double b = op.getOperande2();
        String operateur = op.getOperateur();
        switch (operateur) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return b != 0 ? a / b : Double.NaN;
            default:
                return Double.NaN;
        }
    }
}
