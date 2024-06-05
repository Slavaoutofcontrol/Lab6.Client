package connection;



import collectionClasses.CommandType;
import commands.Command;
import utils.CommandFactory;
import utils.CommandUtils;
import utils.ScriptExecutor;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class {@code Client} отвечает за работу клиента
 */
public class Client {
    /**
     * @see Request
     */
    private final Request request;

    /**
     * Конструктор класса
     * @param address server address
     * @param port server port
     */
    public Client(InetAddress address, int port) {
        try {
            request = new Request(address, port);
            request.setBufferSize(8192 * 8192);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * Метод запускающий клиента
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String[] userInput;
        while (true) {
            System.out.println("Введите команду: ");
            userInput = scanner.nextLine().split(" ");
            if (userInput.length < 1) {
                System.out.println("Введите команду: ");
                continue;
            }
            if (!userInput[0].equals("execute_script")) {
                CommandType commandType = CommandUtils.getCommandType(userInput[0]);
                Command command = CommandFactory.createCommand(commandType, userInput);
                if (command == null) continue;
                try {
                    request.send(CommandSerializer.serialize(command));
                } catch (IOException e) {
                    System.out.println("Невозможно отправить запрос серверу: " + e.getMessage());
                    continue;
                }
                try {
                    String response = request.receive();
                    if (!response.isEmpty()) System.out.println(response);
                } catch (IOException e){
                    System.out.println("Невозможно получить ответ от сервера: " + e.getMessage());
                }
            } else if (userInput.length == 2){
                try {
                    ScriptExecutor scriptExecutor = new ScriptExecutor(new File(userInput[1])).readScript();
                    ArrayList<Command> commands = scriptExecutor.getCommandList();
                    commands.forEach(command -> {
                        try {
                            request.send(CommandSerializer.serialize(command));
                        } catch (IOException e) {
                            System.out.println("Невозможно отправить запрос серверу: " + e.getMessage());
                        }
                        try {
                            String response = request.receive();
                            if (!response.isEmpty()) System.out.println(response);
                        } catch (IOException e){
                            System.out.println("Невозможно получить ответ сервера: " + e.getMessage());
                        }
                    });
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Неверное количество аргументов для команды execute_script");
            }
        }
    }
}