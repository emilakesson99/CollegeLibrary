public class App {

    public static void main(String[] args) throws NoBookFoundException, LibraryClosed, NoBookAvailableException, NoBookIssuedException {


        Book book1 = new Book("LORD OF THE RINGS", "JRR TOLKIEN", "ENGLISH", "FANTASY", 1, "NORTH");
        book1.addCategory("EPIC");

        Book book2 = new Book("LORD OF THE RINGS II", "JRR TOLKIEN", "ENGLISH", "FANTASY", 2, "SOUTH");
        book2.addCategory("EPIC");

        Book book3 = new Book("DAS TAGEBUCH DER ANNE FRANK", "ANNE FRANK", "GERMAN", "HISTORY", 3, "NORTH");
        book3.addCategory("WORLD WAR II");

        StanfordCollegeLibrary stanfordNorth = new CampusLibrary("NORTH");
        StanfordCollegeLibrary stanfordSouth = new CampusLibrary("SOUTH");


        Borrower student = new Student("ANDREW GARCIA ", 1, "NORTH");

        student.showAvailableBooks("NORTH");
        student.showAvailableBooks("SOUTH");
        System.out.println();
        student.borrowBook(book1, "NORTH");
        student.borrowBook(book2, "SOUTH");
        student.showLoans();
        System.out.println();
        student.showAvailableBooks("NORTH");
        student.showAvailableBooks("SOUTH");

        System.out.println(AllBooksData.getAmountOfBooksInCategory("FANTASY"));

    }
}
