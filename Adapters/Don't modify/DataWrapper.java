import java.util.List;

public interface DataWrapper {

    /**
     * Book operations
     */

    List<Book> getAvailableBooksList();

    Boolean checkBook(Book book);

    <T extends CanBorrow> void lendBook(Book book, T borrower) throws NoBookFoundException;

    <T extends CanBorrow> void returnBook(Book book, T borrower) throws NoBookFoundException;

    /**
     * Loan Operations
     */

    List<Loan> getUserSpecificLoans(CanBorrow borrower);

    /**
     * Get library name
     *
     * @return String
     */
    String getLibraryName();
}
