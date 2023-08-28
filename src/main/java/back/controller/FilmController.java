package back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import back.document.Film;
import back.repository.FilmRepository;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/films/week/{week}")
    public ResponseEntity<List<Film>> getFilmByWeek(@PathVariable(value = "week") String week) throws ResourceAccessException {
        List<Film> result = new ArrayList<Film>();
        List<Film> films = getAllFilms();
        int weekInt;
        try {
            weekInt = Integer.parseInt(week);
        }
        catch (NumberFormatException e) {
            weekInt = 0;
        }
        for(Film film : films){

            if(film.getProjection_times().contains(weekInt)){
                result.add(film);
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
}
