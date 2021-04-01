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


    public LibraryFacade getFacade(String location) {
        return FacadeFactory.buildFactory(location);
    }

    public void showAvailableBooks(String location) {
        List<Book> list = getFacade(location).getAvailableBooks();
        if (list.isEmpty()) {
            System.out.println("No books available");
        } else {
            for (Book book : getFacade(location).getAvailableBooks()) {
                System.out.println(book.toString());
            }
        }

    }

    public void returnBook(Book book, String location) throws NoBookFoundException, NoBookIssuedException {
        getFacade(location).returnBooks(book, this);
    }

    public void borrowBook(Book book, String location) throws NoBookFoundException, LibraryClosed, NoBookAvailableException, NoBookIssuedException {
        getFacade(location).borrowBooks(book, this);
    }

    public void showLoans(String location) {
        List<Loan> list = getFacade(location).checkYourLoans(this);
        if (list.isEmpty()) {
            System.out.println("No books lent");
        } else {
            for (Loan l : getFacade(location).checkYourLoans(this)) {
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
