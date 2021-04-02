/**
 * Interface to be implemented by a client who is allowed to use library functions
 */
public interface CanBorrow {
    LibraryFacade getFacade(String location);

    void returnBook(Book book, String location) throws NoBookFoundException, NoBookIssuedException;

    void borrowBook(Book book, String location) throws NoBookFoundException, LibraryClosed, NoBookAvailableException, NoBookIssuedException;

    void showLoans();
}
