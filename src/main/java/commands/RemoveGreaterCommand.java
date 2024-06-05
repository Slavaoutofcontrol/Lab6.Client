package commands;

import collectionClasses.Movie;

import java.io.Serial;

public class RemoveGreaterCommand implements Command{

    @Serial
    private static final long serialVersionUID = -6679190409592074342L;
    private Movie movie;
    public RemoveGreaterCommand(Movie movie){
        this.movie = movie;
    }
}