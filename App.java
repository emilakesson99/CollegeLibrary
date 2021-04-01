public class App {

    public static void main(String[] args) throws NoBookFoundException, LibraryClosed, NoBookAvailableException {


        Book book1 = new Book("LORD OF THE RINGS", "JRR TOLKIEN", "ENGLISH", "FANTASY", 1, "NORTH");
        book1.addCategory("EPIC");

        Book book2 = new Book("LORD OF THE RINGS II", "JRR TOLKIEN", "ENGLISH", "FANTASY", 2, "SOUTH");
        book2.addCategory("EPIC");

        Book book3 = new Book("DAS TAGEBUCH DER ANNE FRANK", "ANNE FRANK", "GERMAN", "HISTORY", 3, "NORTH");
        book3.addCategory("WORLD WAR II");

        AllBooksData.addBook(book1);
        AllBooksData.addBook(book2);
        AllBooksData.addBook(book3);

        Library stanford = new NorthCampusLibrary();

        Student student = new Student("ANDREW GARCIA ", 1, "NORTH");
        Borrower teacher = new Student("MARY WILLYS", 2, "NORTH");

        student.borrowBook(book1, "NORTH");
        student.borrowBook(book2, "SOUTH");
        student.showLoans("NORTH");
        student.showAvailableBooks("NORTH");

        System.out.println();

        student.returnBook(book1, "NORTH");
        student.showLoans("NORTH");

        System.out.println();

        teacher.borrowBook(book3, "NORTH");
        teacher.borrowBook(book1, "NORTH");
        teacher.showLoans("NORTH");

    }
}
