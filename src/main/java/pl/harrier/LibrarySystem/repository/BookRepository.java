package pl.harrier.LibrarySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.harrier.LibrarySystem.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}
