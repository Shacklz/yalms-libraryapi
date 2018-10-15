package yalms.libraryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yalms.libraryapi.entities.nodes.AbstractBook;
import yalms.libraryapi.entities.nodes.Book;
import yalms.libraryapi.repositories.AbstractBookRepository;
import yalms.libraryapi.repositories.BookRepository;
import yalms.libraryapi.services.LibraryItemIdService;

import java.time.LocalDate;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    LibraryItemIdService libraryItemIdService;
    @Autowired BookRepository bookRepository;
    @Autowired AbstractBookRepository abstractBookRepository;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Book addBook(@RequestBody Book book, @RequestParam(value = "abstractBookId") Long abstractBookId) {
        AbstractBook abstractBook = abstractBookRepository.findById(abstractBookId).get();
        book.setAbstractBook(abstractBook);
        if(book.getAddedToLibraryDate() == null) {
            book.setAddedToLibraryDate(LocalDate.now());
        }
        book.setUniqueLibraryItemNumber(libraryItemIdService.getNewUniqueLibraryItemId());
        return bookRepository.save(book);
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
