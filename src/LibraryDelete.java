import java.util.Scanner;

public class LibraryDelete {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Podaj ISBN");
        String isbn = in.nextLine();

        BookDao dao = new BookDao();

        if (dao.findByIsbn(isbn) != null) {
            dao.delete(isbn);
            System.out.println("Książka została usunięta");
        } else {
            System.out.println("Nie ma takiej książki");
        }

        dao.close();
    }
}
