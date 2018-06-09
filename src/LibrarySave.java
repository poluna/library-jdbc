import java.util.Scanner;

public class LibrarySave {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Podaj Autora");
        String author = in.nextLine();
        System.out.println("Podaj Tytuł");
        String title = in.nextLine();
        System.out.println("Podaj Rok");
        String year = in.nextLine();
        System.out.println("Podaj ISBN");
        String isbn = in.nextLine();


        if (year.length() == 4) {
            try {
                Integer.parseInt(year);
                Book book = new Book(author, title, year, isbn);

                BookDao dao = new BookDao();

                if (dao.findByIsbn(isbn) == null) {
                    dao.save(book);
                    System.out.println("Książka została zapisana");
                } else {
                    System.out.println("Książka o podanym ISBN już istnieje");
                }
                dao.close();

            } catch (NumberFormatException e) {
                System.out.println("Wprowadzony rok jest niepoprawny");
            }
        } else {
            System.out.println("Wprowadzony rok jest niepoprawny");
        }
    }
}
