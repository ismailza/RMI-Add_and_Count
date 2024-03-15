package ma.fstm.ilisi.rmiaddandcount.client;

import ma.fstm.ilisi.rmiaddandcount.server.services.InterService;
import ma.fstm.ilisi.rmiaddandcount.server.exception.NumberOutOfRangeException;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Remplacer "CV" par "service" pour correspondre à l'URL de publication du serveur
            InterService service = (InterService) Naming.lookup("rmi://localhost:6666/service");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Client RMI démarré. Que souhaitez-vous faire ?");
            System.out.println("1. Ajouter des chiffres");
            System.out.println("2. Compter les caractères dans une chaîne");
            System.out.print("Votre choix (1/2): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Ajouter des chiffres
                    System.out.print("Entrez un nombre entre 0 et 1000: ");
                    int n = scanner.nextInt();
                    try {
                        int sum = service.addChif(n);
                        System.out.println("La somme des chiffres jusqu'à " + n + " est: " + sum);
                    } catch (NumberOutOfRangeException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2: // Compter les caractères
                    System.out.print("Entrez une chaîne: ");
                    scanner.nextLine(); // Consommer la ligne restante
                    String str = scanner.nextLine();
                    System.out.print("Entrez le caractère à compter: ");
                    char c = scanner.next().charAt(0);
                    int count = service.counter(c, str);
                    System.out.println("Le caractère '" + c + "' apparaît " + count + " fois dans la chaîne.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.err.println("Erreur lors de la connexion au service RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
