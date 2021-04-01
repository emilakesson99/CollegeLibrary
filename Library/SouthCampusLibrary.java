import java.util.ArrayList;
import java.util.List;

public class SouthCampusLibrary extends Library implements StanfordCollegeLibrary {

    private final List<Student> registeredStudents = new ArrayList<>();
    BookModel books = new AvailableBooksSouth();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(this.registeredStudents);
    }

    @Override
    public void addStudent(Student s) {
        registeredStudents.add(s);
    }

}