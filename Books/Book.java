import java.util.ArrayList;
import java.util.List;

public class Book {

    private final String title;
    private final String author;
    private final String language;
    private final List<String> categories = new ArrayList<>();
    private final int id;
    private String location;
    private BookState state;

    public Book(String title, String author, String language, String category, int id, String location) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.id = id;
        this.location = location;
        this.state = null;
        addCategory(category);
        addToStaticBooks();
        setState(new Available());
    }

    private void addToStaticBooks() {
        AllBooksData.addBook(this);
    }

    public void addCategory(String category) {
        categories.add(category);
        AllCategoriesData.addCategory(category);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getCategories() {
        return new ArrayList<>(categories);
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return state.available();
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", categories=" + categories +
                '}';
    }
}
