import java.util.List;

public abstract class PublicData implements DataWrapper {
    //User data accessible
    private final BookModel availableBooks;

    public PublicData(BookModel bookModel) {
        this.availableBooks = bookModel;
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
    public abstract List<Loan> getUserSpecificLoans(CanBorrow borrower);
}
