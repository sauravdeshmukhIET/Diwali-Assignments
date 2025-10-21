import java.io.IOException;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action != null ? action : "list") {
                case "new":
                    showForm(request, response);
                    break;
                case "insert":
                    insert(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    list(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Book> list = bookDAO.getAllBooks();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-books.jsp");
        dispatcher.forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.getBook(id);
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        Book book = new Book(title, author, price);
        bookDAO.insertBook(book);
        response.sendRedirect("BookServlet");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        Book book = new Book(id, title, author, price);
        bookDAO.updateBook(book);
        response.sendRedirect("BookServlet");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
        response.sendRedirect("BookServlet");
    }
}
