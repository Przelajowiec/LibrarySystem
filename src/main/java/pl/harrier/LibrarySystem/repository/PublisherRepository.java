package pl.harrier.LibrarySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.harrier.LibrarySystem.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
