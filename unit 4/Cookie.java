import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Cookie extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        Cookie c = new Cookie("username", "Anu");
        res.addCookie(c);

        res.getWriter().println("Cookie created");
    }
}
