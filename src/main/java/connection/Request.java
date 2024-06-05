package connection;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


/**
 *  Class {@code Request} отвечает за запрос клиента на сервер
 */
public class Request implements Serializable {

    @Serial
    private static final long serialVersionUID = 4813659552196915802L;
    /**
     * Датаграмма-сокет, посылающий запрос
     */
    private static DatagramSocket socket;
    /**
     * Адрес сервера
     */
    private final InetAddress address;
    /**
     * Порт сервера
     */
    private final int port;
    /**
     * Время на запрос
     */
    private final static int socketTimeout = 4000;

    /**
     * Конструктор класса
     * @param address server address
     * @param port server port
     * @throws SocketException, если возникает ошибка доступа к сокету
     */
    public Request(InetAddress address, int port) throws SocketException {
        socket = new DatagramSocket();
        socket.setSoTimeout(socketTimeout);
        this.address = address;
        this.port = port;
    }

    public int getPort(){
        return socket.getLocalPort();
    }

    public void setBufferSize(int size) throws SocketException {
        socket.setReceiveBufferSize(size);
        socket.setSendBufferSize(size);
    }

    /**
     * Метод отправки запроса
     * @param bytes request
     * @throws IOException , если есть ошибка отправления
     */
    public void send(byte[] bytes) throws IOException {
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, this.address, port);
        socket.send(datagramPacket);
        System.out.print("");
    }

    /**
     * Метод получения запроса
     * @return String response
     * @throws IOException, если есть ошибка получения
     */
    public String receive() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        outputStream.write(packet.getData(), 0, packet.getLength());
        String data = outputStream.toString();
        outputStream.close();
        return data;
    }
}
