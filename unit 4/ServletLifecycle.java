import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LifeCycle extends HttpServlet {
    public void init() {
        System.out.println("Servlet Initialized");
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res)
                        throws IOException {
        res.getWriter().println("Service Method");
    }

    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}
