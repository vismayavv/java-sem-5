import java.sql.*;

class ResultSetNavigation {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs =
                st.executeQuery("SELECT * FROM student");

            // first()
            rs.first();
            System.out.println("First: " + rs.getString(2));

            // last()
            rs.last();
            System.out.println("Last: " + rs.getString(2));

            // previous()
            rs.previous();
            System.out.println("Previous: " + rs.getString(2));

            // next()
            rs.next();
            System.out.println("Next: " + rs.getString(2));

            // absolute()
            rs.absolute(2);
            System.out.println("Second: " + rs.getString(2));

            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
