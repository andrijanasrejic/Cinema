package back.databaseInit;

import back.document.Film;
import back.repository.FilmRepository;
import back.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final FilmRepository filmRepository;
    private final UserRepository userRepository;
    public DatabaseInit(FilmRepository filmRepository, UserRepository userRepository) {
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
    }

    public void run(String... args){
        /*
        filmRepository.deleteAll();
        userRepository.deleteAll();

         */
        Film film = new Film("Mrk");
        filmRepository.save(film);
    }
}
