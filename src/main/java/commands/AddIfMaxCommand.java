package commands;

import collectionClasses.Movie;

import java.io.Serial;

public class AddIfMaxCommand implements Command{

    @Serial
    private static final long serialVersionUID = -11081439549547967L;
    private Movie movie;
    public AddIfMaxCommand(Movie movie) {
        this.movie = movie;
    }
}
