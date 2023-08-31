package back.controller;

import back.document.Projection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import back.document.Film;
import back.repository.FilmRepository;
import org.springframework.web.client.ResourceAccessException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class FilmController {

    private final FilmRepository filmRepository;
    @Autowired
    public FilmController(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }
    @GetMapping("/films")
    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    @GetMapping("/films/{name}")
    public ResponseEntity<Film> getFilmByName(@PathVariable(value = "name") String name) throws ResourceAccessException {
        Film film;
        try {
          film = (Film) filmRepository.findByName(name);
        } catch (Exception e){
            return (ResponseEntity<Film>) ResponseEntity.notFound().header("Film not found");
        }


        System.out.println(film.getName());
        return ResponseEntity.ok().body(film);
    }

    @GetMapping("/films/week")
    public ResponseEntity<List<Film>> getFilmByWeek() {
        List<Film> result = new ArrayList<>();
        List<Film> films = getAllFilms();

        LocalDateTime now = LocalDateTime.now(); // Current date and time
        LocalDateTime startOfWeek = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).with(LocalTime.MIN);
        LocalDateTime endOfWeek = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).with(LocalTime.MAX);

        for (Film film : films) {
            if(film.getProjection() != null) {
                for (Projection projection : film.getProjection()) {
                    LocalDateTime projectionTime = projection.getTime();
                    if (projectionTime.isAfter(startOfWeek) && projectionTime.isBefore(endOfWeek)) {
                        result.add(film);
                        break; // No need to check further projection_times for this film
                    }
                }
            }
        }

        return ResponseEntity.ok().body(result);
    }

    
    @PostMapping("/films/upload/{name}")
    public Film addFilm(@PathVariable(value = "name") String name) {
        Film film = new Film(name);

        return filmRepository.save(film);
    }

    @PutMapping("/films/updateFilm/{name}/{rating}")
    public ResponseEntity<Film> rateMovie(@PathVariable(value = "name") String name, @PathVariable(value = "rating") int new_rating)
        throws ResourceAccessException {
        Film film;
        try {
            film = filmRepository.findByName(name);
        }catch (Exception e){
            return (ResponseEntity<Film>) ResponseEntity.notFound().header("Film not found");
        }
        film.rateMovie(new_rating);
        final Film updateFilm = filmRepository.save(film);
        return ResponseEntity.ok(updateFilm);
    }

    @PutMapping("/films/projection/{name}/{time}/{size}/{price}")
    public ResponseEntity<String> addProjectionTime(@PathVariable(value = "name") String name,
                                                    @PathVariable(value = "time") String time,
                                                    @PathVariable(value = "size") Integer size,
                                                    @PathVariable(value = "price") Float price){
        Film film;

        try {
            film = filmRepository.findByName(name);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Film not found!");
        }
        System.out.println(film.getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);

        Projection projection = new Projection(dateTime, name, price, size);
        System.out.println(projection.getTime());


        film.addProjection(projection);


        filmRepository.save(film);

        return ResponseEntity.ok("Added new projection");
    }
}
