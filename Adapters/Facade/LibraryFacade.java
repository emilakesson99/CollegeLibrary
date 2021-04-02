import java.util.List;

public class LibraryFacade {

    private DataWrapper data;

    /**
     * Constructor inits the data meant to be public
     *
     * @param data
     */
    public LibraryFacade(DataWrapper data) {
        this.data = data;

    }

    /**
     * Checks if Library is active and that Book is available
     *
     * @param book
     * @throws LibraryClosed
     * @throws NoBookAvailableException
     */
    void checkAccess(Book book) throws NoBookAvailableException {
        if (!book.isAvailable()) {
            throw new NoBookAvailableException();
        }
    }

    /**
     * If user only wants to check their loans, they dont need the data.
     *
     * @throws NoBookIssuedException
     */
    void checkDataNotNull() throws NoBookIssuedException {
        if (data == null) {
            throw new NoBookIssuedException();
        }
    }

    /**
     * Returns book to library
     *
     * @param book
     */
    public <T extends CanBorrow> void returnBooks(Book book, T borrower) throws NoBookFoundException, NoBookIssuedException {
        checkDataNotNull();
        book.setState(new Available());
        data.returnBook(book, borrower);
    }

    /**
     * Borrows Book from library. Creates a new loan instance.
     *
     * @param book
     * @param borrower
     * @param <T>
     * @throws NoBookFoundException
     * @throws LibraryClosed
     * @throws NoBookAvailableException
     */
    public <T extends CanBorrow> void borrowBooks(Book book, T borrower) throws NoBookFoundException, LibraryClosed, NoBookAvailableException, NoBookIssuedException {
        checkDataNotNull();
        checkAccess(book);
        book.setState(new NotAvailable());
        data.lendBook(book, borrower);
    }

    /**
     * Returns user loans.
     *
     * @param borrower
     * @param <T>
     * @return
     */
    public <T extends Borrower> List<Loan> checkYourLoans(T borrower) {
        return AllLoansData.getUserSpecificLoans(borrower);
    }

    public List<Book> getAvailableBooks() throws NoBookIssuedException {
        checkDataNotNull();
        return data.getAvailableBooksList();
    }
}
