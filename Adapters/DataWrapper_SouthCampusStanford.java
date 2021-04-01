import java.util.List;

public class DataWrapper_SouthCampusStanford extends PublicData {
    public DataWrapper_SouthCampusStanford() {
        super(new AvailableBooksSouth());
    }

    @Override
    public List<Loan> getUserSpecificLoans(CanBorrow borrower) {
        return AllLoansData.getUserSpecificLoans(borrower);
    }
}
