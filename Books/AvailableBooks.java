public class AvailableBooks extends AvailableBooksData {

    /**
     * Gets the available books from the database relevant to the library in question
     *
     * @param libraryName
     */
    @Override
    public void updateAvailableBooks(String libraryName) {
        for (Book book : AllBooksData.getBooks()) {
            if (!checkBook(book) & book.isAvailable() & book.getLocation().equals(libraryName)) {
                super.getBooks().add(book);
            }
        }
    }

    public AvailableBooks(String libraryName) {
        super(libraryName);
    }
}
