

public class NotAvailable implements BookState {

    @Override
    public boolean available() {
        return false;
    }
}
