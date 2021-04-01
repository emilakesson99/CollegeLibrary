public class AvailableBooksSouth extends AvailableBooksData {
    @Override
    public void updateAvailableBooks() {
        for (Book book : AllBooksData.getBooks()) {
            if (!checkBook(book) & book.isAvailable() & book.getLocation().equals("SOUTH")) {
                super.getBooks().add(book);
            }
        }
    }
}
