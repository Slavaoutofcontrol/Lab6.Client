package commands;


import java.io.Serial;
import java.util.ArrayList;


public class ExecuteScriptCommand implements Command {

    @Serial
    private static final long serialVersionUID = -7431356007880416793L;
    private ArrayList<Command> commands;

    public ExecuteScriptCommand(ArrayList<Command> commands) {
        this.commands = commands;
    }

}