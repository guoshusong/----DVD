import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorld")
public class HelloWorld extends javax.servlet.http.HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello,World!";
    }
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>" + message + "</h1>");
        out.flush();
        out.close();
    }
}
