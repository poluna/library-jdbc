import java.sql.*;
import java.util.ArrayList;

public class BookDao {
    private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Admin123";
    private Connection connection;

    public BookDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) {
        final String sql = "insert into books(author, title, year, isbn) values(?, ?, ?,?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getAuthor());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setString(3, book.getYear());
            prepStmt.setString(4, book.getIsbn());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public Book read(String isbn) {
        final String sql = "select id, author, title, year, isbn from books where isbn = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, isbn);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                Book book = new Book();
                book.setId(result.getLong("id"));
                book.setAuthor(result.getString("author"));
                book.setTitle(result.getString("title"));
                book.setYear(result.getString("year"));
                book.setIsbn(result.getString("isbn"));
                return book;
            }
        } catch (SQLException e) {
            System.out.println("Could not get book");
        }
        return null;
        // lub ElementNotFoundException
    }


    public ArrayList<Book> readAll() {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM books");
            while (result.next()) {
                Book book = new Book();
                book.setId(result.getLong("id"));
                book.setAuthor(result.getString("author"));
                book.setTitle(result.getString("title"));
                book.setYear(result.getString("year"));
                book.setIsbn(result.getString("isbn"));

                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void update(Book book) {
        final String sql = "update books set author=?, title=?, year=? where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getAuthor());
            prepStmt.setString(2, book.getTitle());
            prepStmt.setString(3, book.getYear());
            prepStmt.setLong(4, book.getId());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record");
        }
    }

    public void delete(String isbn) {
        final String sql = "delete from books where isbn = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, isbn);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
        }
    }
}