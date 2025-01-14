import java.util.Arrays;

abstract class Book{
    String title;
    String author;
    public Book(String title,String author){
        this.title=title;
        this.author=author;
    }
    public abstract void getDetails();
}

class PrintedBook extends Book{
    private boolean isAvailable;
    public PrintedBook(String title,String author){
        super(title, author);
        isAvailable=true;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void setAvailable(boolean available){
        this.isAvailable = available;
    }
    public void getDetails(){
        System.out.println("Printed Book: " + title + " by " + author + " | Available: " + isAvailable);
    }
}

class EBook extends Book{
    public EBook(String title,String author){
        super(title, author);
    }
    public void getDetails(){
        System.out.println("E-Book: " + title + " by " + author);
    }
}

interface User{
    void borrowBook(Book book);

    void returnBook(Book book);

    Book[] getBorrowedBooks();
}

class Student implements User{
    private static final int limit=3;
    int cnt=0;
    int printed_book_cnt=0;
    Book arr[]=new Book[20];
    public void borrowBook(Book book){
        if(book instanceof PrintedBook){
            if(printed_book_cnt>=limit){
                System.out.println("Borrowing limit reached! Students can borrow up to "+limit+" books.");
                return;
            }
            printed_book_cnt++;
        }
        arr[cnt]=book;
        cnt++;
        System.out.println("Book '" + book.title + "' borrowed successfully.");
    }
    public void returnBook(Book book){
        boolean found=false;
        for(int i=0;i<cnt;i++){
            if(arr[i]==book){
                if(book instanceof PrintedBook){
                    printed_book_cnt--;
                }
                for(int j=i;j<cnt-1;j++){
                    arr[j]=arr[j+1];
                }
                arr[cnt-1]=null;
                cnt--;
                found=true;
                System.out.println("Book '" + book.title + "' returned successfully.");
                break;
            }
        }
        if(!found){
            System.out.println("Book '" + book.title + "' not found in borrowed books.");
        }
    }
    public Book[] getBorrowedBooks(){
        return Arrays.copyOf(arr, cnt);
    }
}

class Faculty implements User{
    private static final int limit=10;
    int cnt=0;
    int printed_book_cnt=0;
    Book arr[]=new Book[20];
    public void borrowBook(Book book){
        if(book instanceof PrintedBook){
            if(printed_book_cnt>=limit){
                System.out.println("Borrowing limit reached! Faculty can borrow up to "+limit+" books.");
                return;
            }
            printed_book_cnt++;
        }
        arr[cnt]=book;
        cnt++;
        System.out.println("Book '" + book.title + "' borrowed successfully.");
    }
    public void returnBook(Book book){
        boolean found=false;
        for(int i=0;i<cnt;i++){
            if(arr[i]==book){
                if(book instanceof PrintedBook){
                    printed_book_cnt--;
                }
                for(int j=i;j<cnt-1;j++){
                    arr[j]=arr[j+1];
                }
                arr[cnt-1]=null;
                cnt--;
                found=true;
                System.out.println("Book '" + book.title + "' returned successfully.");
                break;
            }
        }
        if(!found){
            System.out.println("Book '" + book.title + "' not found in borrowed books.");
        }
    }
    public Book[] getBorrowedBooks(){
        return Arrays.copyOf(arr, cnt);
    }
}

public class Main{
    public static void displayBookDetails(Book book){
        book.getDetails();
    }
    public static void main(String[] args){
        PrintedBook book1=new PrintedBook("Amar Chelebela", "Humayun Ahmed");
        PrintedBook book2=new PrintedBook("Devdas", "Sarat Chandra Chattopadhyay");

        EBook ebook1=new EBook("Bidrohi", "Kazi Najrul Islam");
        EBook ebook2=new EBook("Gitanjali", "Rabindranath Thagore");

        User student=new Student();
        User faculty=new Faculty();

        displayBookDetails(book1);
        displayBookDetails(book2);
        displayBookDetails(ebook1);

        student.borrowBook(book1);
        student.borrowBook(book2);
        student.borrowBook(ebook1);
        student.borrowBook(new PrintedBook("Book Title", "Author"));

        student.returnBook(ebook1);

        faculty.borrowBook(ebook2);

        System.out.println("Student's borrowed books:");
        for(Book book : student.getBorrowedBooks()){
            System.out.println(book.title);
        }

        System.out.println("Faculty's borrowed books:");
        for(Book book : faculty.getBorrowedBooks()){
            System.out.println(book.title);
        }
    }
}
