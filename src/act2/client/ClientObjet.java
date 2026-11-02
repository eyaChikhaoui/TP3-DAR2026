package act2.client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import act2.op.Operation;

public class ClientObjet {

    public static void main(String[] args) {

        try (
                Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connecte au serveur.");
            // Creation des flux
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            oos.flush();
            // Saisie utilisateur
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez le premier nombre : ");
            double a = sc.nextDouble();
            System.out.print("Entrez l'operateur (+, -, *, /) : ");
            String operateur = sc.next();
            System.out.print("Entrez le deuxieme nombre : ");
            double b = sc.nextDouble();
            // Creation et envoi de l'objet
            Operation operation = new Operation(a, operateur, b);
            oos.writeObject(operation);
            oos.flush();
            // Reception du resultat
            String resultat = in.readLine();
            System.out.println("Resultat recu du serveur : " + resultat);

        } catch (IOException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
