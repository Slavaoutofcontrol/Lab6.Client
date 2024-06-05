package commands;


import java.io.Serial;

public class RemoveByIdCommand implements Command{

    @Serial
    private static final long serialVersionUID = 904823743523031940L;
    private long id;
    public RemoveByIdCommand(long id) {
        this.id = id;
    }
}
