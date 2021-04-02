import java.util.ArrayList;
import java.util.List;

public class AllBooksData {

    private static final List<Book> books = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
    }

    public static List<Book> getBooks() {
        return books;
    }

    /**
     * Counts amount of books in a specific category
     *
     * @param checkC
     * @return
     */
    public static int getAmountOfBooksInCategory(String checkC) {

        int result = 0;

        for (Book b : getBooks()) {
            result += b.checkCategorys(checkC);
        }
        return result;
    }


}
