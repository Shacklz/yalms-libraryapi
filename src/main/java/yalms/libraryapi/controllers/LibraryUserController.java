package yalms.libraryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yalms.libraryapi.entities.nodes.LibraryUser;
import yalms.libraryapi.repositories.LibraryUserRepository;
import yalms.libraryapi.services.UniqueIdService;

import java.time.LocalDate;

@RestController
@RequestMapping("/libraryUser")
public class LibraryUserController {

    @Autowired private UniqueIdService uniqueIdService;
    @Autowired private LibraryUserRepository libraryUserRepository;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public LibraryUser addLibraryUser(@RequestBody LibraryUser libraryUser) {
        if(libraryUser.getMemberSinceDate() == null) {
            libraryUser.setMemberSinceDate(LocalDate.now());
        }
        libraryUser.setLibraryUserId(uniqueIdService.getNewLibraryUserId());
        return libraryUserRepository.save(libraryUser);
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public Iterable<LibraryUser> getAllLibraryUsers() {
        return libraryUserRepository.findAll();
    }
}
