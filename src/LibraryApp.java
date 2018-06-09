import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz opcję:\n" + "1 - Dodaj nowy rekord\n" +
                    "2 - Wyświetl wszystkie książki\n" + "3 - Usuwanie\n" + "4 - Aktualizacja");
            try {
                Long id = in.nextLong();
                if (id == 1) {
                    LibrarySave.main(null);
                } else if (id == 2) {
                    LibraryRead.readAll();
                } else if (id == 3) {
                    LibraryDelete.main(null);
                } else if (id == 4) {
                    LibraryUpdate.main(null);
                } else {
                    System.out.println("Wprowadź liczbę z zakresu 1-4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadź poprawną wartość");
                in.nextLine();
            }
        }
    }
}
