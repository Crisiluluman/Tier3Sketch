import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServerSocket {


    public void start() throws IOException
    {
        System.out.println("Server started");
        ServerSocket serverSocket = new ServerSocket(1236);

        while (true)
        {
            Socket socket = serverSocket.accept();
            DataServerSocketHandler handler = new DataServerSocketHandler(socket);

            Thread thread = new Thread(handler);
            thread.setDaemon(true);
            thread.start();
        }
    }

}
