package de.carstenkremser.neuefische.springrecapproject.repo;

import de.carstenkremser.neuefische.springrecapproject.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<Todo, Integer> {
    Optional<Todo> findTopByOrderByIdDesc();

}
