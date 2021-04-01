

public interface CanBorrow {
    LibraryFacade getFacade(String location);

    void returnBook(Book book, String location) throws NoBookFoundException;

    void borrowBook(Book book, String location) throws NoBookFoundException, LibraryClosed, NoBookAvailableException;

    void showLoans(String location);
}
