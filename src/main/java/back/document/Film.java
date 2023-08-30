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
    private float overall_rating;

    private byte[] poster;
    List<Integer> ratings;

    // Repertoire list
    List<LocalDateTime> projection_times;

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return this.overall_rating;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public List<LocalDateTime> getProjection_times() {
        return projection_times;
    }

    public void addProjection(LocalDateTime new_time){
        this.projection_times.add(new_time);
    }

    public void rateMovie(int rating){
        this.ratings.add(rating);

        // overall_rating is the mean of all the ratings
        this.overall_rating = (float) this.ratings.stream().reduce(0, Integer::sum) /this.ratings.toArray().length;
    }



    public Film(String name) {
        super();

        this.name = name;
        this.projection_times = new ArrayList<LocalDateTime>();
        this.ratings = new ArrayList<Integer>();
        this.overall_rating = 0;
    }

    public Film(){
        super();
    }
}
