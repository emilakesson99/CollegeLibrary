public class Student extends Borrower {
    private String campus;

    public Student(String name, int id, String campus) {
        super(name, id);
        this.campus = campus;
    }
}
