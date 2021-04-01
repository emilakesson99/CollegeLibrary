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

        for (Book b : getBooks()) {
            for (int i = 0; i < b.getCategories().size(); i++) {
                String C = b.getCategories().get(i);
                if (C.equals(checkC)) {
                    result++;
                }
            }
        }
        return result;
    }


}
