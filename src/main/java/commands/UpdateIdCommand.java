package commands;



import collectionClasses.Movie;

import java.io.Serial;

public class UpdateIdCommand implements Command{

    @Serial
    private static final long serialVersionUID = -620855360289409781L;
    private Movie movie;
    /**
     * Constructor of class
     */
    public UpdateIdCommand(Movie movie) {
        this.movie = movie;
    }
}
