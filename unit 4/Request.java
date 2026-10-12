import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestDemo extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        res.getWriter().println("GET Request");
    }

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws IOException {
        res.getWriter().println("POST Request");
    }

    public void doHead(HttpServletRequest req,
                       HttpServletResponse res)
                       throws IOException {
        res.setContentType("text/html");
        res.setHeader("X-Message", "HEAD Request");
    }
}
