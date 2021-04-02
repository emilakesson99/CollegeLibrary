import java.util.ArrayList;
import java.util.List;

public class AllLoansData {
    /**
     * Database for all loans
     */
    private static final List<Loan> loans = new ArrayList<>();

    public static List<Loan> getUserSpecificLoans(CanBorrow borrower) {

        List<Loan> copyLoans = new ArrayList<>(loans);
        List<Loan> yourLoans = new ArrayList<>();

        for (Loan loan : copyLoans) {
            if (loan.borrower == borrower) {
                yourLoans.add(loan);
            }
        }
        return yourLoans;
    }

    public static void removeLoan(Loan loan) {
        loans.removeIf(l -> l == loan);
    }

    public static void addLoan(Loan loan) {
        loans.add(loan);
    }
}
