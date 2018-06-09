import java.util.Scanner;

public class LibraryUpdate {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Podaj ISBN");
        String isbn = in.nextLine();
        System.out.println("Podaj nowego Autora");
        String author = in.nextLine();

        BookDao dao = new BookDao();
        Book book = dao.read(isbn);

        if (book == null) {
            System.out.println("Nie ma takiej książki");
        }else{
            book.setAuthor(author);
            dao.update(book);
        }

        dao.close();

        System.out.println("Dane książki zostały zaktualizowane");
    }
}
