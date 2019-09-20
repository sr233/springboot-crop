package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8888);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("socket client");
        printWriter.close();
        socket.close();

    }

}
