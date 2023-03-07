package lk.ijse.dep10.app;

import lk.ijse.dep10.app.model.UserDetails;
import lk.ijse.dep10.shared.Header;
import lk.ijse.dep10.shared.Message;
import lk.ijse.dep10.shared.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class AppInitializer {
    private static ArrayList<User> userArrayList = new ArrayList<>();
    private static ArrayList<UserDetails> onlineList = new ArrayList<>();
    private static ArrayList<String> activeList = new ArrayList<>();
    private static File file = new File("/home/gayashan/Documents/DEP/Phase - 1/java-se/network-io/modified-chat-app/server-app/src/main/resources/userList.db");
    private static boolean login = false;
    private static String chat = "";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Reading file*/
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        userArrayList = (ArrayList<User>) ois.readObject();
        ois.close();
        System.out.println(userArrayList.size());
//        System.out.println(userArrayList.get(0).getUsername());
//        System.out.println(userArrayList.get(0).getPassword());
        System.out.println("Initializing Server Socket");
        ServerSocket serverSocket = new ServerSocket(5050);

        while (true) {
            System.out.println("Listening for connection");
            Socket localSocket = serverSocket.accept();
            UserDetails userDetails = new UserDetails(localSocket);
            System.out.println("Connected : " + localSocket.getRemoteSocketAddress());

            new Thread(() -> {
                try {
                    System.out.println("Inside new thread");
                    UserDetails userD2 = userDetails;
                    ObjectOutputStream userOos = userD2.getOos();
                    ObjectInputStream userOis = userD2.getOis();
                    while (true) {
                        System.out.println("Waiting to read message");
                        Message msg = (Message) userOis.readObject();
                        System.out.println("Message received");
                        if (msg.getHeader() == Header.SIGNUP) {
                            FileOutputStream fileFos = new FileOutputStream(file);
                            ObjectOutputStream fileOos = new ObjectOutputStream(fileFos);
                            userArrayList.add((User) msg.getContent());
                            fileOos.writeObject(userArrayList);
                            System.out.println(((User) msg.getContent()).getUsername());
                            System.out.println(((User) msg.getContent()).getPassword());
                            System.out.println("file written");
                            fileOos.close();
                        } else if (msg.getHeader() == Header.LOGIN) {
                            login = false;
                            for (User user : userArrayList) {
                                if (
                                        user.getUsername().equals(((User) msg.getContent()).getUsername()) &&
                                                user.getPassword().equals(((User) msg.getContent()).getPassword())
                                ) {
                                    login = true;
                                    userOos.writeObject(msg);
                                    onlineList.add(userD2);
                                    broadcastLoggedUsers();
                                    sendChatHistory(userD2);
                                }
                            }
                            if (!login) userOos.writeObject(new Message(Header.LOGIN, null));
                        }

                    }


                } catch (Exception e) {
                    System.out.println("Error 1");
                    e.printStackTrace();
                }
            } ).start();
        }


    }

    private static void sendChatHistory(UserDetails userDetails) {

    }

    private static void broadcastLoggedUsers() {

    }

    private static void broadcastChatHistory() {

    }


}
