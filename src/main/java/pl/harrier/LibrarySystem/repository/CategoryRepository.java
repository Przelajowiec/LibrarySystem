package pl.harrier.LibrarySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.harrier.LibrarySystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
