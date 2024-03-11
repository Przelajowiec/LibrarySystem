package pl.harrier.LibrarySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.harrier.LibrarySystem.entity.Author;
import pl.harrier.LibrarySystem.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono autora"));
        return author;
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(findAuthorById(id).getId());
    }
}
