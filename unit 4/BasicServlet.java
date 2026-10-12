import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BasicServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Student Details</h2>");
        out.println("Name: Fayhaa<br>");
        out.println("Mark: 90");
    }
}
