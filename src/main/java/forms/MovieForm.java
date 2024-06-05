package forms;

import collectionClasses.*;
import console.*;
import utils.ExecuteFileManager;
import utils.ReadManager;

/**
 * Class {@code MovieForm} для создания фильма
 * @see forms.Form
 * @see Movie
 */

public class MovieForm extends Form<Movie> {
    private final ReaderWriter console;
    private final UserInput scanner;
    public MovieForm(ReaderWriter console) {
        this.console = (Console.isFileMode())
                ? new BlankConsole()
                : console;
        this.scanner = (Console.isFileMode())
                ? new ExecuteFileManager()
                : new ConsoleInput();
    }
    @Override
    public Movie build() {
        ReadManager readManager = new ReadManager(console);
        return new Movie(
                readManager.readName(),
                readCoordinates(),
                readManager.readOscarCount(),
                readMovieGenre(),
                readMpaaRating(),
                readDirector()
        );
    }
    private Coordinates readCoordinates() {
        return new CoordinatesForm(console).build();
    }
    private MovieGenre readMovieGenre() {
        return new MovieGenreForm(console).build();
    }
    private MpaaRating readMpaaRating() {
        return new MpaaRatingForm(console).build();
    }
    private Person readDirector() {
        return new PersonForm(console).build();
    }

}