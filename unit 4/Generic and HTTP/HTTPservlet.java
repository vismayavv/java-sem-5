import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HttpDemo extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        res.getWriter().println("HTTP Servlet");
    }
}
