import java.util.List;

public class DataWrapperUser extends PublicData {
    public DataWrapperUser(String libraryName) {
        super(new AvailableBooks(libraryName));
    }

    @Override
    public List<Loan> getUserSpecificLoans(CanBorrow borrower) {
        return AllLoansData.getUserSpecificLoans(borrower);
    }
}
