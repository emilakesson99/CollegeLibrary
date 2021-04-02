import java.util.List;

public class Borrower implements CanBorrow {

    private final String name;
    private final int id;

    public Borrower getBorrower() {
        return new Borrower(getName(), getId());
    }

    public Borrower(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public LibraryFacade getFacade(String libraryName) {
        return FacadeFactory.buildFactory(libraryName);
    }

    public void showAvailableBooks(String libraryName) throws NoBookIssuedException {
        List<Book> list = getFacade(libraryName).getAvailableBooks();
        if (list.isEmpty()) {
            System.out.println("No books available");
        } else {
            for (Book book : getFacade(libraryName).getAvailableBooks()) {
                System.out.println(book.toString());
            }
        }

    }

    public void returnBook(Book book, String libraryName) throws NoBookFoundException, NoBookIssuedException {
        getFacade(libraryName).returnBooks(book, this);
    }

    public void borrowBook(Book book, String libraryName) throws NoBookFoundException, LibraryClosed, NoBookAvailableException, NoBookIssuedException {
        getFacade(libraryName).borrowBooks(book, this);
    }

    public void showLoans() {
        List<Loan> list = getFacade("null").checkYourLoans(this);
        if (list.isEmpty()) {
            System.out.println("No books lent");
        } else {
            for (Loan l : list) {
                System.out.println(l.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
