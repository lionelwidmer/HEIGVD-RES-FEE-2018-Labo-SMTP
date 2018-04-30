package client;

import java.io.IOException;

public interface IMailClient {
    public void connect(String server, int port) throws IOException;
    public void sendMail(String from, String to, String subject, String message) throws IOException;
    public void disconnect() throws IOException;
}
