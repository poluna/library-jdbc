import java.util.ArrayList;
import java.util.Scanner;

public class LibraryRead {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Podaj ISBN");
        String isbn = in.nextLine();

        BookDao dao = new BookDao();
        Book book = dao.read(isbn);
        dao.close();

        if (book == null) {
            System.out.println("Nie ma takiej książki");
        }
    }

    public static void readAll() {
        BookDao dao = new BookDao();
        ArrayList<Book> bookList = dao.readAll();
        //bookList.forEach(book -> System.out.println(book));
        bookList.forEach(System.out::println);
    }
}
