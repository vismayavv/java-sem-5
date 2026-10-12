import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionDemo extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        HttpSession s = req.getSession();

        s.setAttribute("name", "Anu");

        res.getWriter().println(
            "Welcome " + s.getAttribute("name")
        );
    }
}
