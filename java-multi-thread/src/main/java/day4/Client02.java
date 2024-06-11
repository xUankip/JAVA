package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client02 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.22.185.186", 8888);
            System.out.println("Client1 connected to localhost:8888");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                String message = reader.readLine();
                System.out.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
