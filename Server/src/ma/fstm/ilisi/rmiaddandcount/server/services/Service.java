package ma.fstm.ilisi.rmiaddandcount.server.services;

import ma.fstm.ilisi.rmiaddandcount.server.exception.NumberOutOfRangeException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Fournit une implémentation de l'interface InterService, offrant des méthodes
 * pour effectuer des opérations telles que l'addition dans une plage et le comptage
 * des occurrences d'un caractère dans une chaîne.
 */
public class Service extends UnicastRemoteObject implements InterService {

    /**
     * Construit un objet Service.
     *
     * @throws RemoteException si l'opération d'exportation échoue
     */
    public Service() throws RemoteException {
        super();
    }

    /**
     * Ajoute tous les nombres de 1 à n inclusivement.
     *
     * @param n la limite supérieure pour l'addition
     * @return la somme de tous les nombres de 1 à n
     * @throws RemoteException si une erreur de communication distante se produit
     * @throws NumberOutOfRangeException si n est hors de la plage [0, 1000]
     */
    @Override
    public int addChif(int n) throws RemoteException, NumberOutOfRangeException {
        if (n < 0 || 1000 < n) {
            throw new NumberOutOfRangeException("Le nombre " + n + " est hors de la plage acceptable [0, 1000].");
        }
        int somme = 0;
        for (int i = 1; i <= n; i++) {
            somme += i;
        }
        return somme;
    }

    /**
     * Compte les occurrences d'un caractère spécifié dans une chaîne.
     *
     * @param c   le caractère à compter
     * @param str la chaîne dans laquelle effectuer la recherche
     * @return le nombre d'occurrences de c dans str
     * @throws RemoteException si une erreur de communication distante se produit
     */
    @Override
    public int counter(char c, String str) throws RemoteException {
        int compteur = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                compteur++;
            }
        }
        return compteur;
    }
}
