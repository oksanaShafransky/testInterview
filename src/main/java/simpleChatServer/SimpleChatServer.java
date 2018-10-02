package simpleChatServer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleChatServer {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream streamIn = null;

    public SimpleChatServer(int port) {
        try {
            System.out.println("Binding to port " + port + ", please wait  ...");
            server = new ServerSocket(port);
            System.out.println("Server started: " + server);
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted: " + socket);
            open();
            boolean done = false;
            while (!done) {
                try {
                    String line = streamIn.readUTF();
                    System.out.println(line);
                    done = line.equals(".bye");
                } catch (IOException ioe) {
                    done = true;
                }
            }
            close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void main(String args[]) {
        SimpleChatServer server = null;
        if (args.length != 1)
            System.out.println("Usage: java ChatServer port");
        else
            server = new SimpleChatServer(Integer.parseInt(args[0]));
    }

    public void open() throws IOException {
        streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    public void close() throws IOException {
        if (socket != null) socket.close();
        if (streamIn != null) streamIn.close();
    }
}

