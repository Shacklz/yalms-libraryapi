package yalms.libraryapi.services;

public interface BorrowService {
    boolean borrowLibraryItem(Long libraryUserId, Long uniqueLibraryItemNumber);

    boolean bringBackLibraryItem(Long uniqueLibraryItemNumber);
}
