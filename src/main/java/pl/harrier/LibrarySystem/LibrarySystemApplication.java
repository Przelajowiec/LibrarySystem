package pl.harrier.LibrarySystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.harrier.LibrarySystem.entity.Author;
import pl.harrier.LibrarySystem.entity.Book;
import pl.harrier.LibrarySystem.entity.Category;
import pl.harrier.LibrarySystem.entity.Publisher;
import pl.harrier.LibrarySystem.service.BookService;

@SpringBootApplication
public class LibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return(args) -> {
			Book book1 = new Book("ISBN12345098", "Wprowadzenie do Javy", "Programowanie i struktury danych");
			Author author1 = new Author("Liang Daniel Y.", "Wykładowca z Purdue");
			Category category1 = new Category("Java, programowanie");
			Publisher publisher1 = new Publisher("Helion");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ISBN12345123", "Dallas 63", "Najlepsza moim zdaniem Kinga");
			Author author2 = new Author("King Stephen", "Mistrz horroru");
			Category category2 = new Category("Horror");
			Publisher publisher2 = new Publisher("Prószyński i S-ka");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("ISBN123450987", "Władca Pierścieni", "Bilbo lata z pierścieniem w towarzystwie niezłej gromadki");
			Author author3 = new Author("J.R.R. Tolkien", "Legendarny Brytyjski pisarz");
			Category category3 = new Category("Fantasy");
			Publisher publisher3 = new Publisher("Czytelnik");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);
		};
	}

}
