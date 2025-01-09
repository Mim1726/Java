import java.util.ArrayList;
import java.util.List;
/* Problem: Library Management System
You are tasked with building a Library Management System that allows the management of various
types of users and books. The system should allow operations like borrowing, returning, and
displaying book details based on the type of user.
Requirements:
1. Users:
There are two types of users in the system:
● Student: Can borrow up to 3 books at a time.
● Faculty: Can borrow up to 10 books at a time.
Create a common User interface that defines the following methods:
● borrowBook(Book book): Handles borrowing a book.
● returnBook(Book book): Handles returning a book.
● getBorrowedBooks(): Returns a list of currently borrowed books.
Both Student and Faculty should implement this interface, with specific borrowing limits for each.
2. Books:
There are two types of books in the library:
● PrintedBook: Requires a physical copy to be borrowed.
● EBook: Can be borrowed digitally without limits on the library stock.
Create an abstract Book class that defines the common properties of a book:
● title: The title of the book.
● author: The author of the book.
● isAvailable: (For physical books only) Tracks whether the book is available or already
borrowed.
Include an abstract method:
● getDetails(): Prints details of the book.
Implement two subclasses: PrintedBook and EBook, each with specific details and behaviors.3. Library Operations:
● Use polymorphism to allow both Student and Faculty users to borrow either type of book
through the same interface.
● If a Student tries to borrow more than 3 books or a Faculty tries to borrow more than 10
books, the system should reject the request with an appropriate message.
● For PrintedBook, check availability before allowing borrowing. For EBook, no availability
check is needed.
4. Display Book Details:
● Use a method displayBookDetails(Book book) to display book information, taking
advantage of polymorphism to show specific details for either PrintedBook or EBook.
5. Implementation Notes:
● Demonstrate the use of inheritance for PrintedBook and EBook.
● Use interfaces for user behavior.
● Use polymorphism to handle different user types and book types seamlessly.
*/
// Abstract class for Book
abstract class Book {
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract void getDetails();
}

// Subclass for PrintedBook
class PrintedBook extends Book {
    private boolean isAvailable;

    public PrintedBook(String title, String author) {
        super(title, author);
        this.isAvailable = true; // By default, the book is available
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public void getDetails() {
        System.out.println("Printed Book: " + title + " by " + author + " | Available: " + isAvailable);
    }
}

// Subclass for EBook
class EBook extends Book {
    public EBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void getDetails() {
        System.out.println("E-Book: " + title + " by " + author);
    }
}

// User Interface
interface User {
    void borrowBook(Book book);

    void returnBook(Book book);

    List<Book> getBorrowedBooks();
}

// Student Implementation
class Student implements User {
    private static final int BORROW_LIMIT = 3;
    private List<Book> borrowedBooks;

    public Student() {
        borrowedBooks = new ArrayList<>();
    }

    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks.size() >= BORROW_LIMIT) {
            System.out.println("Borrowing limit reached! Students can borrow up to " + BORROW_LIMIT + " books.");
            return;
        }

        if (book instanceof PrintedBook) {
            PrintedBook printedBook = (PrintedBook) book;
            if (!printedBook.isAvailable()) {
                System.out.println("Book '" + printedBook.title + "' is not available.");
                return;
            }
            printedBook.setAvailable(false);
        }

        borrowedBooks.add(book);
        System.out.println("Book '" + book.title + "' borrowed successfully.");
    }

    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            if (book instanceof PrintedBook) {
                PrintedBook printedBook = (PrintedBook) book;
                printedBook.setAvailable(true);
            }
            System.out.println("Book '" + book.title + "' returned successfully.");
        } else {
            System.out.println("You did not borrow this book.");
        }
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

// Faculty Implementation
class Faculty implements User {
    private static final int BORROW_LIMIT = 10;
    private List<Book> borrowedBooks;

    public Faculty() {
        borrowedBooks = new ArrayList<>();
    }

    @Override
    public void borrowBook(Book book) {
        if (borrowedBooks.size() >= BORROW_LIMIT) {
            System.out.println("Borrowing limit reached! Faculty members can borrow up to " + BORROW_LIMIT + " books.");
            return;
        }

        if (book instanceof PrintedBook) {
            PrintedBook printedBook = (PrintedBook) book;
            if (!printedBook.isAvailable()) {
                System.out.println("Book '" + printedBook.title + "' is not available.");
                return;
            }
            printedBook.setAvailable(false);
        }

        borrowedBooks.add(book);
        System.out.println("Book '" + book.title + "' borrowed successfully.");
    }

    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            if (book instanceof PrintedBook) {
                PrintedBook printedBook = (PrintedBook) book;
                printedBook.setAvailable(true);
            }
            System.out.println("Book '" + book.title + "' returned successfully.");
        } else {
            System.out.println("You did not borrow this book.");
        }
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void displayBookDetails(Book book) {
        book.getDetails();
    }

    public static void main(String[] args) {
        // Create books
        PrintedBook book1 = new PrintedBook("To Kill a Mockingbird", "Harper Lee");
        PrintedBook book2 = new PrintedBook("1984", "George Orwell");
        EBook ebook1 = new EBook("Digital Fortress", "Dan Brown");

        // Create users
        User student = new Student();
        User faculty = new Faculty();

        // Display book details
        displayBookDetails(book1);
        displayBookDetails(book2);
        displayBookDetails(ebook1);

        // Student borrows books
        student.borrowBook(book1);
        student.borrowBook(book2);
        student.borrowBook(ebook1);
        student.borrowBook(new PrintedBook("Extra Book", "Author")); // Exceeds limit

        // Faculty borrows books
        faculty.borrowBook(book1); // Already borrowed
        faculty.borrowBook(ebook1);

        // Return books
        student.returnBook(book1);
        faculty.returnBook(ebook1);

        // Display borrowed books
        System.out.println("Student's borrowed books:");
        for (Book book : student.getBorrowedBooks()) {
            System.out.println(book.title);
        }

        System.out.println("Faculty's borrowed books:");
        for (Book book : faculty.getBorrowedBooks()) {
            System.out.println(book.title);
        }
    }
}
