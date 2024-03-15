package ma.fstm.ilisi.rmiaddandcount.server.services;

import ma.fstm.ilisi.rmiaddandcount.server.exception.NumberOutOfRangeException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface InterService extends Remote {

    int addChif(int n) throws RemoteException, NumberOutOfRangeException;
    int counter(char c, String str) throws RemoteException;

}
