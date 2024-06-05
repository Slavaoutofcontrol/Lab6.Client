package commands;

import collectionClasses.MpaaRating;

import java.io.Serial;

public class CountLessThanMpaaRatingCommand implements Command{

    @Serial
    private static final long serialVersionUID = -246712803353855092L;
    private MpaaRating mpaaRating;
    public CountLessThanMpaaRatingCommand(MpaaRating mpaaRating){
        this.mpaaRating = mpaaRating;
    }
}
