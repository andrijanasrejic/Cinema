package back.document;

import java.time.LocalDateTime;

public class Projection {
    private LocalDateTime time;
    private Film film;
    private float ticketPrice;

    private int theaterSize;

    Projection(LocalDateTime time, Film film, float ticketPrice, int theaterSize){
        this.time = time;
        this.film = film;
        this.ticketPrice = ticketPrice;
        this.theaterSize = theaterSize;
    }

    
}
