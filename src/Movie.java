import java.util.ArrayList;

public class Movie {
    private int year;
    private String title;
    private String genre;
    private String director;
    private ArrayList<Actor> actors;

    public Movie(int year, String title, String genre, String director) {
        this.year = year;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actors = new ArrayList<>();
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }
}
