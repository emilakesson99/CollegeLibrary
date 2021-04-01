import java.util.ArrayList;
import java.util.List;

public class NorthCampusLibrary extends Library implements StanfordCollegeLibrary {

    private static final NorthCampusLibrary lib = new NorthCampusLibrary();
    private final List<Student> registeredStudents = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(this.registeredStudents);
    }

    @Override
    public void addStudent(Student s) {
        registeredStudents.add(s);
    }

    public static NorthCampusLibrary getInstance() {
        return lib;
    }
}