package back.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "database_sequence")
public class Film {
    @MongoId
    private String _id;
    @Indexed(unique = true)
    private String name;
    private float overall_rating = 0;


    private int release_year;
    private String content_rating;

    List<Integer> ratings;

    // Repertoire list
    List<Projection> projections;

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }


    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getContent_rating() {
        return content_rating;
    }

    public void setContent_rating(String content_rating) {
        this.content_rating = content_rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return this.overall_rating;
    }



    public List<Projection> getProjection() {
        return projections;
    }

    public void addProjection(Projection newProjection){;
        this.projections.add(newProjection);
    }

    public void rateMovie(int rating){
        this.ratings.add(rating);

        // overall_rating is the mean of all the ratings
        this.overall_rating = (float) this.ratings.stream().reduce(0, Integer::sum) /this.ratings.toArray().length;
    }



    public Film(String name, int release_year, String content_rating) {

        this.name = name;
        this.release_year = release_year;
        this.content_rating = content_rating;
        this.projections = new ArrayList<Projection>();
        this.ratings = new ArrayList<Integer>();
    }

    public Film(){
        this.name = "";
        this.projections = new ArrayList<Projection>();
        this.ratings = new ArrayList<Integer>();
    }
}
