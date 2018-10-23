package yalms.libraryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yalms.libraryapi.entities.nodes.AbstractBook;
import yalms.libraryapi.repositories.AbstractBookRepository;

@RestController
@RequestMapping("/abstractBook")
public class AddAbstractBookController {

    @Autowired private AbstractBookRepository abstractBookRepository;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public AbstractBook addAbstractBook(@RequestBody AbstractBook abstractBook) {
        return abstractBookRepository.save(abstractBook);
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public Iterable<AbstractBook> getAllAbstractBooks() {
        return abstractBookRepository.findAll();
    }

}
