import java.util.List;

public interface BookModel {

    Boolean checkBook(Book book);

    <T extends CanBorrow> void lendBook(Book book, T borrower) throws NoBookFoundException;

    <T extends CanBorrow> void returnBook(Book book, T borrower) throws NoBookFoundException;

    List<Book> getAvailableBooks();

}
