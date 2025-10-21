import java.sql.*;
import java.util.*;

public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bookdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root@123";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Book> getAllBooks() throws Exception {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book b = new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price")
                );
                list.add(b);
            }
        }
        return list;
    }

    public void insertBook(Book book) throws Exception {
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice());
            stmt.executeUpdate();
        }
    }

    public Book getBook(int id) throws Exception {
        String sql = "SELECT * FROM books WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price")
                    );
                }
            }
        }
        return null;
    }

    public void updateBook(Book book) throws Exception {
        String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice());
            stmt.setInt(4, book.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteBook(int id) throws Exception {
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
