import java.io.IOException;

public class RunServer {

    public static void main(String[] args) throws IOException {

    DataServerSocket socket = new DataServerSocket();

    socket.start();

    }
}
