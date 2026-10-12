import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Error extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        try {
            int a = 10 / 0;
            res.getWriter().println(a);
        }
        catch(Exception e) {
            res.sendError(500, "Something went wrong");
        }
    }
}
