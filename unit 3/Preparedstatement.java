import java.sql.*;
import java.util.*;

class PreparedDemo {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            // Insert student
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter mark: ");
            int mark = sc.nextInt();

            PreparedStatement ps =
                con.prepareStatement(
                    "INSERT INTO student VALUES(?,?,?)"
                );

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, mark);

            ps.executeUpdate();

            System.out.println("Student inserted!");

            // Search student
            System.out.print("Enter ID to search: ");
            int search = sc.nextInt();

            PreparedStatement ps2 =
                con.prepareStatement(
                    "SELECT * FROM student WHERE id=?"
                );

            ps2.setInt(1, search);

            ResultSet rs = ps2.executeQuery();

            while(rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3)
                );
            }

            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
