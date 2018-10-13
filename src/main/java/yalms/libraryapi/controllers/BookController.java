package yalms.libraryapi.controllers;

import org.springframework.web.bind.annotation.*;
import yalms.libraryapi.entities.nodes.AbstractBook;
import yalms.libraryapi.entities.nodes.Book;
import yalms.libraryapi.repositories.AbstractBookRepository;
import yalms.libraryapi.repositories.BookRepository;

import java.time.LocalDate;

@RestController
@RequestMapping("/book")
public class BookController {

    BookRepository bookRepository;
    AbstractBookRepository abstractBookRepository;

    public BookController(BookRepository bookRepository, AbstractBookRepository abstractBookRepository) {
        this.bookRepository = bookRepository;
        this.abstractBookRepository = abstractBookRepository;
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Book addBook(@RequestBody Book book, @RequestParam(value = "abstractBookId") Long abstractBookId) {
        AbstractBook abstractBook = abstractBookRepository.findById(abstractBookId).get();
        book.setAbstractBook(abstractBook);
        if(book.getAddedToLibraryDate() == null) {
            book.setAddedToLibraryDate(LocalDate.now());
        }
        return bookRepository.save(book);
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
