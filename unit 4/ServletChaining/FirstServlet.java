import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException, ServletException {
        req.setAttribute("name", "Anu");

        req.getRequestDispatcher("SecondServlet")
           .forward(req, res);
    }
}
