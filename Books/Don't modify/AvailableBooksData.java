import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvailableBooksData implements BookModel {

    private final String libraryName;
    private final List<Book> books = new ArrayList<>();

    /**
     * Constructor
     *
     * @param libraryName
     */
    public AvailableBooksData(String libraryName) {
        this.libraryName = libraryName;
        updateAvailableBooks(libraryName);
    }

    /**
     * Adds books available from the database related to specific library
     */
    @Override
    public void updateAvailableBooks(String libraryName) {
        for (Book book : AllBooksData.getBooks()) {
            if (!checkBook(book) & book.isAvailable() & book.getLocation().equals(libraryName)) {
                getBooks().add(book);
            }
        }
    }

    public Boolean checkBook(Book book) {
        return books.contains(book);
    }

    /**
     * Borrow a Book
     *
     * @param book
     * @param borrower
     * @param <T>
     * @throws NoBookFoundException
     */
    public <T extends CanBorrow> void borrowBook(Book book, T borrower) throws NoBookFoundException {

        if (!checkBook(book)) {
            throw new NoBookFoundException();
        }

        for (Book b : books) {
            if (b == book) {
                b.setState(new NotAvailable());
                books.remove(b);
                break;
            }

        }
        AllLoansData.addLoan(new Loan(borrower, book, LocalDate.now(), LocalDate.now().plusMonths(2)));


    }

    /**
     * Return a book
     *
     * @param book
     * @param borrower
     * @param <T>
     * @throws NoBookFoundException
     */
    public <T extends CanBorrow> void returnBook(Book book, T borrower) throws NoBookFoundException {
        for (Loan l : AllLoansData.getUserSpecificLoans(borrower)) {
            if (l.book == book) {
                //change book status
                books.add(book);
                book.setLocation(libraryName);
                book.setState(new Available());
                //remove loan
                AllLoansData.removeLoan(l);

                break;
            } else {
                throw new NoBookFoundException();
            }
        }

    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        return new ArrayList<>(books);
    }
}
