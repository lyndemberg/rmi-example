import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerLoader {
    public static void main(String[] args) {
        try {
            ServerChat server = new ServerChatImpl();
            ServerChat stub = (ServerChat) UnicastRemoteObject.exportObject(server,0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ServerChat",stub);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in server: " + e.getMessage());
        }
    }
}
