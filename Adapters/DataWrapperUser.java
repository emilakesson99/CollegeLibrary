import java.util.List;

public class DataWrapperUser extends PublicData {
    public DataWrapperUser(String libraryName) {
        super(new AvailableBooks(libraryName));
    }

    /**
     * This datawrapper is for the AllLoansData, data.
     * implement another version of this method for access to another dataset
     *
     * @param borrower
     * @return
     */
    @Override
    public List<Loan> getUserSpecificLoans(CanBorrow borrower) {
        return AllLoansData.getUserSpecificLoans(borrower);
    }
}
