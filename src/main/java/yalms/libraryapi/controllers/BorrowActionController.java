package yalms.libraryapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yalms.libraryapi.services.BorrowService;

@RestController
@RequestMapping("/borrowAction")
public class BorrowActionController {

    @Autowired private BorrowService borrowService;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Boolean borrowLibraryItem(@RequestParam(value = "libraryUserId") Long libraryUserId, @RequestParam(value = "uniqueLibraryItemNumber") Long uniqueLibraryItemNumber) {
        return borrowService.borrowLibraryItem(libraryUserId, uniqueLibraryItemNumber);
    }

    @PostMapping(path = "/remove", consumes = "application/json", produces = "application/json")
    public Boolean bringBackLibraryItem(@RequestParam(value = "uniqueLibraryItemNumber") Long uniqueLibraryItemNumber) {
        return borrowService.bringBackLibraryItem(uniqueLibraryItemNumber);
    }
}
