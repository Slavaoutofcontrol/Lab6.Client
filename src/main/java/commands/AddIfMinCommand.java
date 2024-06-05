package commands;

import collectionClasses.Movie;

import java.io.Serial;

public class AddIfMinCommand implements Command{

    @Serial
    private static final long serialVersionUID = -4252936670992812458L;
    private Movie movie;
    public AddIfMinCommand(Movie movie) {
        this.movie = movie;
    }
}
