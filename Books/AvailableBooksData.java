import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvailableBooksData implements BookModel {

    private final List<Book> books = new ArrayList<>();

    public AvailableBooksData() {
        updateAvailableBooks();
    }

    public void updateAvailableBooks() {
        for (Book book : AllBooksData.getBooks()) {
            if (!checkBook(book) & book.isAvailable()) {
                books.add(book);
            }
        }
    }

    public Boolean checkBook(Book book) {
        return books.contains(book);
    }

    public <T extends CanBorrow> void lendBook(Book book, T borrower) throws NoBookFoundException {
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

    public <T extends CanBorrow> void returnBook(Book book, T borrower) throws NoBookFoundException {
        for (Loan l : AllLoansData.getUserSpecificLoans(borrower)) {
            if (l.book == book) {
                book.setState(new Available());
                books.add(book);
                AllLoansData.removeLoan(l);
                break;
            } else {
                throw new NoBookFoundException();
            }
        }

    }

    public List<Book> getAvailableBooks() {
        return new ArrayList<>(books);
    }
}
