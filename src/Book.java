import java.util.Objects;

public class Book {

    private long id;
    private String title;
    private String author;
    private String year;
    private String isbn;

    public Book(){}

    public Book(String author, String title, String year, String isbn) {
        this.id=id;
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "id=" + id + ", author: " + author + ", title: " + title + ", year: " + year + ", isbn: " + isbn;
    }
}


