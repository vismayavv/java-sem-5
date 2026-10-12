import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestResponse extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        String name = req.getParameter("name");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("Welcome " + name);
    }
}
