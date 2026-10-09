import java.sql.*;

class DatabaseMetaDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            DatabaseMetaData md =
                con.getMetaData();

            System.out.println(
                "Database: " +
                md.getDatabaseProductName()
            );

            System.out.println(
                "Version: " +
                md.getDatabaseProductVersion()
            );

            System.out.println(
                "Driver: " +
                md.getDriverName()
            );

            System.out.println(
                "Driver Version: " +
                md.getDriverVersion()
            );

            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
