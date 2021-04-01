

public interface CanBorrow {
    LibraryFacade getFacade(String location);

    void returnBook(Book book, String location) throws NoBookFoundException, NoBookIssuedException;

    void borrowBook(Book book, String location) throws NoBookFoundException, LibraryClosed, NoBookAvailableException, NoBookIssuedException;

    void showLoans(String location);
}
