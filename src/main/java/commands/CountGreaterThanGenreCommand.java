package commands;

import collectionClasses.MovieGenre;

import java.io.Serial;

public class CountGreaterThanGenreCommand implements Command{

    @Serial
    private static final long serialVersionUID = -2442949581870811398L;
    private MovieGenre genre;
    public CountGreaterThanGenreCommand(MovieGenre genre){
        this.genre = genre;
    }
}
