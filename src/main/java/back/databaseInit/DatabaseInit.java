package back.databaseInit;

import back.document.Film;
import back.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final FilmRepository filmRepository;

    public DatabaseInit(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void run(String... args){
        Film film1 = new Film("Kursadzije");
        film1.addProjection(24);
        filmRepository.save(film1);
    }
}
