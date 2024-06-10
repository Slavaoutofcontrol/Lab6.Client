package collectionClasses;

/**
 * Class {@code MusicBandCreator} need to create music band
 *
 */
public class MovieCreator {
    /**
     * Method creates music band from array of string arguments
     * @param fields array of arguments for music band
     * @return Music band or null
     */
    public static Movie createMovie(String[] fields){
        try{
            String name = fields[0];
            Integer x = Integer.parseInt(fields[1]);
            float y = Float.parseFloat(fields[2]);
            int oscarCount = Integer.parseInt(fields[3]);
            MovieGenre genre = MovieGenre.valueOf(fields[4].toUpperCase());
            MpaaRating mpaarating = MpaaRating.valueOf(fields[5].toUpperCase());
            String directorsname = fields[6];
            Double weight = Double.parseDouble(fields[7]);
            Colour haircolour = Colour.valueOf(fields[8].toUpperCase());
            Country nationality = Country.valueOf(fields[9].toUpperCase());
            return new Movie(name, new Coordinates(x, y), oscarCount, genre, mpaarating, new Person(directorsname, weight, haircolour, nationality));
        } catch (Exception e){
            return null;
        }
    }
}
