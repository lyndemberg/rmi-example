import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerChat extends Remote {
    String connect(Client c) throws RemoteException;
    void send(String message) throws RemoteException;
    void disconnect(Client c) throws RemoteException;
}
