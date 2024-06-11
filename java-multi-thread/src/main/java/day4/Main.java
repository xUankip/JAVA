package day4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Socket> connectedClients = new ArrayList<>();

            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server start on port 8888, waiting connection....");
            Socket socket1 = serverSocket.accept();
            connectedClients.add(socket1);
            System.out.println("Client1 connected");

            Socket socket2 = serverSocket.accept();
            connectedClients.add(socket2);
            System.out.println("Client2 connected");

            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Your message here");
                String message = scanner.nextLine();
                if (message.equals("exit")) {
                    break;
                }
                for (Socket client : connectedClients) {
                    PrintWriter printWriter = new PrintWriter(client.getOutputStream());
                    printWriter.println(message);
                    printWriter.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
