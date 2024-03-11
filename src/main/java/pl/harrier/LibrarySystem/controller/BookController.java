package pl.harrier.LibrarySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.harrier.LibrarySystem.entity.Author;
import pl.harrier.LibrarySystem.entity.Book;
import pl.harrier.LibrarySystem.entity.Category;
import pl.harrier.LibrarySystem.entity.Publisher;
import pl.harrier.LibrarySystem.service.AuthorService;
import pl.harrier.LibrarySystem.service.BookService;
import pl.harrier.LibrarySystem.service.CategoryService;
import pl.harrier.LibrarySystem.service.PublisherService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/books")
    public String findAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook(Book book, Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }
//
//    @GetMapping("/categories")
//    public String categories(Category category, Model model) {
//        List<Category> categories = categoryService.findAllCategories();
//        model.addAttribute("categories" , categories);
//        return "categories";
//    }
//
//    @GetMapping("/remove-category/{id}")
//    public String deleteCategory(@PathVariable Long id, Model model) {
//        categoryService.deleteCategory(id);
//        model.addAttribute("categories", categoryService.findAllCategories());
//        return "categories";
//    }
//
//    @GetMapping("/update-category/{id}")
//    public String updateCategory(@PathVariable Long id, Model model) {
//        Category category = categoryService.findCategoryById(id);
//        model.addAttribute("category", category);
//        return "update-category";
//    }
//
//    @PostMapping("/update-category/{id}")
//    public String updateCategory(@PathVariable Long id, Category category, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "update-category";
//        }
//        categoryService.updateCategory(category);
//        model.addAttribute("categories", categoryService.findAllCategories());
//        return "redirect:/categories";
//    }
//
//    @GetMapping("/add-category")
//    public String addCategory(Category category, Model model) {
//        model.addAttribute("categories", categoryService.findAllCategories());
//        return "add-category";
//    }
//
//    @PostMapping("/save-category")
//    public String saveCategory(Category category, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-category";
//        }
//        categoryService.createCategory(category);
//        model.addAttribute("categories", categoryService.findAllCategories());
//        return "redirect:/categories";
//    }
//
//    @GetMapping("/authors")
//    public String authors(Author author, Model model) {
//        List<Author> authors = authorService.findAllAuthors();
//        model.addAttribute("authors" , authors);
//        return "authors";
//    }
//
//    @GetMapping("/remove-author/{id}")
//    public String deleteAuthor(@PathVariable Long id, Model model) {
//        authorService.deleteAuthor(id);
//        model.addAttribute("authors", authorService.findAllAuthors());
//        return "authors";
//    }
//
//    @GetMapping("/update-author/{id}")
//    public String updateAuthor(@PathVariable Long id, Model model) {
//        Author author = authorService.findAuthorById(id);
//        model.addAttribute("author", author);
//        return "update-author";
//    }
//
//    @PostMapping("/update-author/{id}")
//    public String updateAuthor(@PathVariable Long id, Author author, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "update-author";
//        }
//        authorService.updateAuthor(author);
//        model.addAttribute("authors", authorService.findAllAuthors());
//        return "redirect:/authors";
//    }
//
//    @GetMapping("/add-author")
//    public String addCategory(Author author, Model model) {
//        model.addAttribute("authors", authorService.findAllAuthors());
//        return "add-author";
//    }
//
//    @PostMapping("/save-author")
//    public String saveAuthor(Author author, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-author";
//        }
//        authorService.createAuthor(author);
//        model.addAttribute("authors", authorService.findAllAuthors());
//        return "redirect:/authors";
//    }
//
//    @GetMapping("/publishers")
//    public String publishers(Publisher publisher, Model model) {
//        List<Publisher> publishers = publisherService.findAllPublishers();
//        model.addAttribute("publishers" , publishers);
//        return "publishers";
//    }
//
//    @GetMapping("/remove-publisher/{id}")
//    public String deletePublisher(@PathVariable Long id, Model model) {
//        publisherService.deletePublisher(id);
//        model.addAttribute("publishers", publisherService.findAllPublishers());
//        return "publishers";
//    }
//
//    @GetMapping("/update-publisher/{id}")
//    public String updatePublisher(@PathVariable Long id, Model model) {
//        Publisher publisher = publisherService.findPublishreById(id);
//        model.addAttribute("publisher", publisher);
//        return "update-publisher";
//    }
//
//    @PostMapping("/update-publisher/{id}")
//    public String updatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "update-publisher";
//        }
//        publisherService.updatePublisher(publisher);
//        model.addAttribute("publishers", publisherService.findAllPublishers());
//        return "redirect:/publishers";
//    }
//
//    @GetMapping("/add-publisher")
//    public String addPublisher(Publisher publisher, Model model) {
//        model.addAttribute("publishers", publisherService.findAllPublishers());
//        return "add-publisher";
//    }
//
//    @PostMapping("/save-publisher")
//    public String savePublisher(Publisher publisher, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add-publisher";
//        }
//        publisherService.createPublisher(publisher);
//        model.addAttribute("publishers", publisherService.findAllPublishers());
//        return "redirect:/publishers";
//    }
}
