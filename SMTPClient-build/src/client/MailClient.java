package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MailClient implements IMailClient{
    // Instance variables
    private Socket socket;
    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;

    // Methods
    public void connect(String server, int port) throws IOException {
        // Iniatialize instance objects
        socket = new Socket(server, port);
        outputStream = new DataOutputStream(socket.getOutputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void disconnect() throws IOException{
        socket.close();
    }

    public void sendMail(String from, String to, String subject, String message) throws IOException{
        // Method variables
        String serverResponse = "";


        // Say hello to the server and ensure we get '250' responses
        outputStream.writeBytes("EHLO " + InetAddress.getLocalHost().getHostName() + System.lineSeparator());
        while ((serverResponse = bufferedReader.readLine()) != null) {
            System.out.println(serverResponse);
            if (serverResponse.startsWith("250 ")) {
                break;
            }
        }

        outputStream.writeBytes("MAIL FROM: " + from + System.lineSeparator());
        while ((serverResponse = bufferedReader.readLine()) != null) {
            System.out.println(serverResponse);
            if (serverResponse.startsWith("250 ")) {
                break;
            }
        }

        outputStream.writeBytes("RCPT TO: " + to + System.lineSeparator());
        while ((serverResponse = bufferedReader.readLine()) != null) {
            System.out.println(serverResponse);
            if (serverResponse.startsWith("250 ")) {
                break;
            }
        }

        outputStream.writeBytes("DATA" + System.lineSeparator() +
                "from: " + from + System.lineSeparator() +
                "to: " + to + System.lineSeparator() +
                "subject: " + subject + System.lineSeparator() + System.lineSeparator() +
                message + System.lineSeparator() +
                "." + System.lineSeparator());
        while ((serverResponse = bufferedReader.readLine()) != null) {
            System.out.println(serverResponse);
            if (serverResponse.startsWith("250 ")) {
                break;
            }
        }
    }

}
