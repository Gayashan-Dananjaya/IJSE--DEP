package lk.ijse.dep10.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppInitializer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5050);

        System.out.println("Server started at port 5050");

        while (true) {
            Socket localSocket = serverSocket.accept();


            new Thread(() -> {
                try {
                    System.out.println(localSocket.getRemoteSocketAddress());
                    InputStream is = localSocket.getInputStream();

                    while (true) {
                        byte[] buffer = new byte[1024];
                        int read = is.read(buffer);
                        if (read == -1) break;
                        System.out.println(new String(buffer, 0 , read));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } ).start();
        }

    }
}
