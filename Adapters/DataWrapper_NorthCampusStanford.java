import java.util.List;

public class DataWrapper_NorthCampusStanford extends PublicData {
    public DataWrapper_NorthCampusStanford() {
        super(new AvailableBooksNorth());
    }

    @Override
    public List<Loan> getUserSpecificLoans(CanBorrow borrower) {
        return AllLoansData.getUserSpecificLoans(borrower);
    }
}
