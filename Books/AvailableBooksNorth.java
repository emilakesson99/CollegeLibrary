public class AvailableBooksNorth extends AvailableBooksData {
    @Override
    public void updateAvailableBooks() {
        for (Book book : AllBooksData.getBooks()) {
            if (!checkBook(book) & book.isAvailable() & book.getLocation().equals("NORTH")) {
                super.getBooks().add(book);
            }
        }
    }
}
