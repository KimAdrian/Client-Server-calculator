import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) {
        System.out.println("Simple calculator server");

        try (ServerSocket serverSocket = new ServerSocket(6000)){
            System.out.println("Waiting for connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");

            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)){
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    //Use StringTokenizer to break the equation into operand and operation
                    StringTokenizer stringTokenizer = new StringTokenizer(inputLine);
                    float operandOne = Float.parseFloat(stringTokenizer.nextToken());
                    String operation = stringTokenizer.nextToken();
                    float operandTwo = Float.parseFloat(stringTokenizer.nextToken());
                    float result = 0;
                    //Perform required operation
                    switch (operation) {
                        case "+":
                            result = operandOne + operandTwo;
                            break;
                        case "-":
                            result = operandOne - operandTwo;
                            break;
                        case "*":
                            result = operandOne * operandTwo;
                            break;
                        case "/":
                            result = operandOne / operandTwo;
                            break;
                    }
                    System.out.println("Server: Answer = "+ result);
                    out.println(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
