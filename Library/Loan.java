import java.time.LocalDate;

public class Loan<T extends CanBorrow> {

    T borrower;
    Book book;
    LocalDate lentDay;
    LocalDate returnDay;

    /**
     * Constructor
     *
     * @param borrower
     * @param book
     * @param lentDay
     * @param returnDay
     */
    public Loan(T borrower, Book book, LocalDate lentDay, LocalDate returnDay) {
        this.borrower = borrower;
        this.book = book;
        this.lentDay = lentDay;
        this.returnDay = returnDay;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "borrower=" + borrower.toString() +
                ", book=" + book +
                ", lentDay=" + lentDay +
                ", returnDay=" + returnDay +
                '}';
    }
}
