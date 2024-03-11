package pl.harrier.LibrarySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.harrier.LibrarySystem.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
