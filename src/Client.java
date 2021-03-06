import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Simple calculator client");

        try {
            System.out.println("Waiting for connection...");
            InetAddress localAddress = InetAddress.getLocalHost();

            try (Socket clientSocket = new Socket(localAddress, 6000);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                         clientSocket.getInputStream()))){
                System.out.println("Connected to server");
                Scanner scanner = new Scanner(System.in);
                while (true){
                    System.out.print("Enter the equation in the form: ");
                    System.out.println("'operand operator operand' eg. 2 + 2");
                    System.out.println("Ensure there is a space between the operator and operands to avoid errors");
                    String inputLine = scanner.nextLine();
                    if ("quit".equalsIgnoreCase(inputLine)){
                        break;
                    }
                    out.println(inputLine);
                    String response = bufferedReader.readLine();
                    System.out.println("Server response: Answer = "+ response);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
