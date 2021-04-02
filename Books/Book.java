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

    /**
     * Constructoe
     *
     * @param title
     * @param author
     * @param language
     * @param category
     * @param id
     * @param location
     */
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

    /**
     * Adds book to the database
     */
    private void addToStaticBooks() {
        AllBooksData.addBook(this);
    }

    /**
     * Adds new category to book and database
     *
     * @param category
     */
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

    /**
     * Returns copy of categories
     *
     * @return List<String>
     */
    public List<String> getCategories() {
        return new ArrayList<>(categories);
    }

    public int getId() {
        return id;
    }

    /**
     * Return information about book state
     *
     * @return boolean
     */
    public boolean isAvailable() {
        return state.available();
    }

    /**
     * Set book state
     *
     * @param state
     */
    public void setState(BookState state) {
        this.state = state;
    }

    /**
     * Set the location for the book
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the location for the book
     *
     * @return String
     */
    public String getLocation() {
        return location;
    }

    /**
     * Checks if book has a specific category
     *
     * @param c
     * @return int
     */
    public int checkCategorys(String c) {
        if (getCategories().contains(c)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", categories=" + categories +
                ", location='" + location + '\'' +
                ", state=" + state +
                '}';
    }
}
