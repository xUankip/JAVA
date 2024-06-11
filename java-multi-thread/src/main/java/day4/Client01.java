package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client01 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Connected to localhost");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String message = bufferedReader.readLine();
                System.out.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
