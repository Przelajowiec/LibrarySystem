package pl.harrier.LibrarySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.harrier.LibrarySystem.entity.Publisher;
import pl.harrier.LibrarySystem.repository.PublisherRepository;

import java.util.List;
@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublishreById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono wydawcy"));
        return publisher;
    }

    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(findPublishreById(id).getId());
    }
}
