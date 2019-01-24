import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerChatImpl implements ServerChat{

    List<Client> clientsConnected;

    public ServerChatImpl() {
        this.clientsConnected = new ArrayList<Client>();
    }

    public String connect(Client c) throws RemoteException {
        clientsConnected.add(c);
        System.out.println("New client connected");
        return "Client connected";
    }

    public void send(String message) throws RemoteException {
        for(int i=0;i<clientsConnected.size();i++){
            Client client = clientsConnected.get(i);
            client.show(message);
        }
    }

    public void disconnect(Client c) throws RemoteException {
        clientsConnected.remove(c);
        System.out.println("New client disconnected");
    }
}
