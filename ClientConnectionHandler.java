import java.io.*;
import java.net.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class ClientConnectionHandler implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public ClientConnectionHandler(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            output.close();
            input.close();

            long time = System.currentTimeMillis();
            System.out.println("\nRequest Approximate Duration: " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
