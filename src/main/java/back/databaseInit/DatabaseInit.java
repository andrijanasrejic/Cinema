package back.databaseInit;

import back.document.Film;
import back.document.User;
import back.repository.FilmRepository;
import back.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class DatabaseInit implements CommandLineRunner {
    private final FilmRepository filmRepository;
    private final UserRepository userRepository;
    public DatabaseInit(FilmRepository filmRepository, UserRepository userRepository) {
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
    }

    public void run(String... args) throws IOException {


        //User admin = new User("Andrijana", "123", "andrijana@srejic.com");
        //admin.setAdmin();
        //userRepository.save(admin);
    }
}
