package ma.fstm.ilisi.rmiaddandcount.server;

import ma.fstm.ilisi.rmiaddandcount.server.services.Service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;

public class Server {
    // Définir le port d'écoute de l'annuaire RMI
    private static final int RMI_PORT = 6666;

    public static void main(String[] args) {
        try {
            // Démarrer l'annuaire RMI sur le port spécifié
            LocateRegistry.createRegistry(RMI_PORT);
            System.out.println("Annuaire RMI démarré sur le port " + RMI_PORT);
            // Créer l'objet distant
            Service service = new Service();
            // Construire l'URL de publication
            String bindLocation = String.format("rmi://localhost:%d/service", RMI_PORT);
            // Publier la référence de l'objet dans l'annuaire RMI
            Naming.rebind(bindLocation, service);
            System.out.println("Service RMI publié avec succès à l'adresse " + bindLocation);
        } catch (RemoteException e) {
            System.err.println("Erreur lors de la création de l'objet distant ou du démarrage de l'annuaire RMI: " + e.getMessage());
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.err.println("L'URL fournie pour publier l'objet distant est mal formée: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
