import java.sql.*;
import java.util.*;

class ExceptionDemo {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter name: ");
            String name = sc.next();

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            PreparedStatement ps =
                con.prepareStatement(
                    "INSERT INTO student VALUES(?,?,?)"
                );

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, 80);

            ps.executeUpdate();

            System.out.println("Student inserted!");

            con.close();
        }

        catch(InputMismatchException e) {
            System.out.println("Invalid input!");
        }

        catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate ID!");
        }

        catch(SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
