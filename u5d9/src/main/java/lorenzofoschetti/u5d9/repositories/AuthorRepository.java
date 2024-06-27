package lorenzofoschetti.u5d9.repositories;


import lorenzofoschetti.u5d9.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findByEmail(String email);
}
