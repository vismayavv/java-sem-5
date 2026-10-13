import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        PrintWriter out = res.getWriter();

        if("admin".equals(user) &&
           "123".equals(pass)) {
            out.println("Login Successful");
        }
        else {
            out.println("Invalid Login");
        }
    }
}
