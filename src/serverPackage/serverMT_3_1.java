package serverPackage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverMT_3_1 {


    public static void main(String[] args) {

        int numero = 0; // numéro d'ordre de connexion
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Le serveur attend la connexion d'un client…");
            while (true) {
                Socket socket = serverSocket.accept(); // bloque jusqu'au prochain client
                numero++;
                // b) IP + numéro d'ordre du client
                System.out.println("Client n°" + numero + " connecté, adresse : "  + socket.getRemoteSocketAddress());
                // un thread dédié (ClientProcess) par client, qui reçoit sa socket et son numéro
                ClientProcess_3_1 client=new ClientProcess_3_1(socket,numero);
                client.start();  // le démarrer
            }
        } catch (IOException e) {
            System.out.println("Erreur côté serveur : " + e.getMessage());
        }

    }
}