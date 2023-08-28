package back.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import back.document.Film;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
    Film findByName(String name);
}
