package commands;


import collectionClasses.Movie;

import java.io.Serial;


public class AddCommand implements Command{

    @Serial
    private static final long serialVersionUID = 4884185358828753717L;
    private Movie movie;
    public AddCommand(Movie movie) {
        this.movie = movie;
    }
}
