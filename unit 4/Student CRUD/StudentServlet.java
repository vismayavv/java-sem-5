import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root", "root"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            out.println("<h2>Student Records</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Mark</th></tr>");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt(1) +
                    "</td><td>" + rs.getString(2) +
                    "</td><td>" + rs.getInt(3) +
                    "</td></tr>");
            }

            out.println("</table>");
            out.println("<br><a href='index.jsp'>Go Back</a>");

            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String action = req.getParameter("action");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root", "root"
            );

            PreparedStatement ps;

            if ("add".equals(action)) {
                int mark = Integer.parseInt(req.getParameter("mark"));

                ps = con.prepareStatement(
                    "INSERT INTO student VALUES(?,?,?)"
                );
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, mark);
                ps.executeUpdate();

                out.println("Student Added Successfully!");
            }
            else if ("update".equals(action)) {
                int mark = Integer.parseInt(req.getParameter("mark"));

                ps = con.prepareStatement(
                    "UPDATE student SET name=?, mark=? WHERE id=?"
                );
                ps.setString(1, name);
                ps.setInt(2, mark);
                ps.setInt(3, id);
                int rows = ps.executeUpdate();

                out.println(rows > 0 ? "Student Updated!" : "Student Not Found!");
            }
            else if ("delete".equals(action)) {
                ps = con.prepareStatement(
                    "DELETE FROM student WHERE id=?"
                );
                ps.setInt(1, id);
                int rows = ps.executeUpdate();

                out.println(rows > 0 ? "Student Deleted!" : "Student Not Found!");
            }

            con.close();
            out.println("<br><a href='index.jsp'>Go Back</a>");
            out.println("<br><a href='StudentServlet'>View Students</a>");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
                  }
