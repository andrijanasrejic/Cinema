package back.document;

import java.time.LocalDateTime;

public class Projection {
    private LocalDateTime time;
    private String filmName;
    private float ticketPrice;

    private int theaterSize;

    public Projection(LocalDateTime time, String filmName, float ticketPrice, int theaterSize){
        this.time = time;
        this.filmName = filmName;
        this.ticketPrice = ticketPrice;
        this.theaterSize = theaterSize;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public int getTheaterSize() {
        return theaterSize;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setTheaterSize(int theaterSize) {
        this.theaterSize = theaterSize;
    }
}
