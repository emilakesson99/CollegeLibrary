import java.util.List;

public class DataWrapper_SouthCampusStanford implements DataWrapper {

    private final BookModel availableBooks;

    public DataWrapper_SouthCampusStanford() {
        this.availableBooks = new AvailableBooksSouth();
    }

    /**
     * Book Operations
     */
    @Override
    public List<Book> getAvailableBooksList() {
        return availableBooks.getAvailableBooks();
    }


    @Override
    public Boolean checkBook(Book book) {
        return availableBooks.checkBook(book);
    }

    @Override
    public <T extends CanBorrow> void lendBook(Book book, T borrower) throws NoBookFoundException {
        availableBooks.lendBook(book, borrower);
    }

    @Override
    public <T extends CanBorrow> void returnBook(Book book, T borrower) throws NoBookFoundException {
        availableBooks.returnBook(book, borrower);
    }

    /**
     * Loan Operations
     */
    @Override
    public List<Loan> getUserSpecificLoans(CanBorrow borrower) {
        return AllLoansData.getUserSpecificLoans(borrower);
    }

}
