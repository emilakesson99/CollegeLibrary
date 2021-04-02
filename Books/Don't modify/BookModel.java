import java.util.List;

public interface BookModel {

    void updateAvailableBooks(String libraryName);

    Boolean checkBook(Book book);

    <T extends CanBorrow> void borrowBook(Book book, T borrower) throws NoBookFoundException;

    <T extends CanBorrow> void returnBook(Book book, T borrower) throws NoBookFoundException;

    List<Book> getAvailableBooks();

}
