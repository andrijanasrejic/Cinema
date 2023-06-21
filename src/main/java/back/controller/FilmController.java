package back.controller;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import back.document.Film;
import back.repository.FilmRepository;
import org.springframework.web.client.ResourceAccessException;

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
        Film film = (Film) filmRepository.findByName(name)
                .orElseThrow(() -> new ResourceAccessException("Films for this name are not found: " + name));
        return ResponseEntity.ok().body(film);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film){
        return filmRepository.save(film);
    }

    @PutMapping("/films/nesto/{id}")
    public ResponseEntity<Film> rateMovie(@PathVariable(value = "id") String id, @RequestBody int new_rating)
        throws ResourceAccessException {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Film for this id is not found: " + id));
        film.rateMovie(new_rating);
        final Film updateFilm = filmRepository.save(film);
        return ResponseEntity.ok(updateFilm);
    }
}
