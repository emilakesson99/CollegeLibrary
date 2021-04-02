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

    public static int getAmountOfBooksInCategory(String checkC) {

        int result = 0;
        //Possible violation against LOD
        for (Book b : getBooks()) {
            if (b.getCategories().contains(checkC)) {
                result++;
            }
        }
        return result;
    }


}
