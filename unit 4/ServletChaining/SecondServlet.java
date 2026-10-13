import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecondServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        String name = (String) req.getAttribute("name");
        res.getWriter().println("Welcome " + name);
    }
}
