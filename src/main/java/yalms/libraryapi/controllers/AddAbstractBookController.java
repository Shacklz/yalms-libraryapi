package yalms.libraryapi.controllers;

import org.springframework.web.bind.annotation.*;
import yalms.libraryapi.entities.AbstractBook;
import yalms.libraryapi.repositories.AbstractBookRepository;

@RestController
@RequestMapping("/abstractBook")
public class AddAbstractBookController {

    AbstractBookRepository abstractBookRepository;

    public AddAbstractBookController(AbstractBookRepository abstractBookRepository) {
        this.abstractBookRepository = abstractBookRepository;
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public AbstractBook addAbstractBook(@RequestBody AbstractBook abstractBook) {
        return abstractBookRepository.save(abstractBook);
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public Iterable<AbstractBook> getAllAbstractBooks() {
        return abstractBookRepository.findAll();
    }

}
