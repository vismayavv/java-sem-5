import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        Student s = new Student();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Student Details</h2>");
        out.println("Name: " + s.name);
        out.println("<br>Mark: " + s.mark);
    }
}
