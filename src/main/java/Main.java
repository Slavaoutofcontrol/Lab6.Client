import connection.Client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;

public class Main {
    private static final InetAddress serverAddress;

    static {
        try {
            serverAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private static final int serverPort = 23548;

    public static void main(String[] args) {
        Client client = new Client(serverAddress, serverPort);
        try {
            System.out.println("Чтобы узнать какие команды доступны воспользуйтесь командой help");
            client.run();
        } catch (NoSuchElementException e) {
            System.out.println("Упс! \n Что-то пошло не так.До встречи!");
        }
    }
}