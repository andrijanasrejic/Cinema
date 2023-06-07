package back.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import back.document.Film;
@Repository
public interface FilmRepository extends MongoRepository<Film, String> {
}
