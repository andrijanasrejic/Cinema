package back.controller;
import java.sql.*;
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

    private FilmRepository filmRepository;

    @GetMapping("/filmovi")
    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    @GetMapping("/filmovi/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable(value = "id") String id) throws ResourceAccessException {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Film for this id is not found: " + id));
        return ResponseEntity.ok().body(film);
    }

    @PostMapping
    public Film createFilm(@RequestBody Film film){
        return filmRepository.save(film);
    }

    @PutMapping("/filmovi/{id}")
    public ResponseEntity<Film> rateMovie(@PathVariable(value = "id") String id, @RequestBody int new_rating)
        throws ResourceAccessException {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Film for this id is not found: " + id));
        film.rateMovie(new_rating);
        final Film updateFilm = filmRepository.save(film);
        return ResponseEntity.ok(updateFilm);
    }
}
