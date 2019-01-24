import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientLoader{
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            ServerChat server = (ServerChat) registry.lookup("ServerChat");
            Client client = new ClientImpl();
            String connect = server.connect(client);
            System.out.println(connect);
            Thread.sleep(3000);
            server.disconnect(client);
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error in connection with server: " + e.getMessage());
        }
    }
}
