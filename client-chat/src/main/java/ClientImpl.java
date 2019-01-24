import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements Client {

    public ClientImpl() throws RemoteException {
    }

    public void show(String message) throws RemoteException {
        System.out.println(message);
    }
}
