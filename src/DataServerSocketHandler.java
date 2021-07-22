import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.Socket;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DataServerSocketHandler implements Runnable{

    private Socket socket;

    private InputStream inputStream;
    private OutputStream outputStream;
    private Gson gson;

    private DummyObject dummy;

    public DataServerSocketHandler(Socket socket) {
        this.socket = socket;
        gson = new Gson();
        dummy = new DummyObject();

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        byte[] inputFromTier2 = new byte[1024*1024];

        try {

            int arrLength = inputStream.read(inputFromTier2, 0, inputFromTier2.length);
            String arrString = new String(inputFromTier2, 0, arrLength);
            Request request = gson.fromJson(arrString, Request.class);

            switch (request.getEnumRequest())
            {
                case GetFromTier3:
                {
                    //This is where you wold talk to a specific DAO for data
                    dummy.setName("Chris");
                    dummy.setAge(26);
                    dummy.setSalary(6500.00);

                    String jsonString = new Gson().toJson(dummy);
                    byte[] array = jsonString.getBytes();
                    outputStream.write(array,0,array.length);
                    break;
                }

                case SendToTier3:
                {
                    JsonReader reader = new JsonReader(new StringReader(request.getDummyObject().toString()));
                    reader.setLenient(true);

                    DummyObject dummy = request.getDummyObject();
                    //dummyDAO.createDummy(dummy); <-- Something like this to call a function in the DAO

                    System.out.println("Name: " + dummy.getName() + ", Age: " + dummy.getAge() + ", Salary: " + dummy.getSalary());
                    break;
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
