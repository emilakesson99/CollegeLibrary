import java.util.ArrayList;
import java.util.List;

public class CampusLibrary extends Library implements StanfordCollegeLibrary {

   //List of students at the college
    private final List<Student> registeredStudents = new ArrayList<>();

    //Data model for the library to access their available books
    //To be updated with another data model that doesn't include unnecessary methods
    BookModel books;

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(this.registeredStudents);
    }

    @Override
    public void addStudent(Student s) {
        registeredStudents.add(s);
    }

    /**
     * Constructor passes the right books from the database
     * @param libraryName
     */
    public CampusLibrary(String libraryName) {
        this.books = new AvailableBooks(libraryName);
    }
}
