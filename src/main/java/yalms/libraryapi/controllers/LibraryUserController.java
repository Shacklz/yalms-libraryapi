package yalms.libraryapi.controllers;

import org.springframework.web.bind.annotation.*;
import yalms.libraryapi.entities.nodes.LibraryUser;
import yalms.libraryapi.repositories.LibraryUserRepository;

import java.time.LocalDate;

@RestController
@RequestMapping("/libraryUser")
public class LibraryUserController {

    LibraryUserRepository libraryUserRepository;

    public LibraryUserController(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public LibraryUser addLibraryUser(@RequestBody LibraryUser libraryUser) {
        if(libraryUser.getMemberSinceDate() == null) {
            libraryUser.setMemberSinceDate(LocalDate.now());
        }
        return libraryUserRepository.save(libraryUser);
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public Iterable<LibraryUser> getAllLibraryUsers() {
        return libraryUserRepository.findAll();
    }
}
