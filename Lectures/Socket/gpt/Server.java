import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000); // Server listens on port 5000
            System.out.println("Server is waiting for a client...");
            Socket socket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected!");

            // Read data from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // Send response to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, Client!");

            // Close connections
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
