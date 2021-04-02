import java.util.List;

public abstract class PublicData implements DataWrapper {
    //User data accessible
    private final BookModel availableBooks;
    private final String libraryName;

    public PublicData(BookModel bookModel, String libraryName) {
        this.availableBooks = bookModel;
        this.libraryName = libraryName;
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
        availableBooks.borrowBook(book, borrower);
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

    public String getLibraryName() {
        return libraryName;
    }
}
