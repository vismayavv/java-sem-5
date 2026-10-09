import java.sql.*;

class ResultSetMetaDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            Statement st = con.createStatement();

            ResultSet rs =
                st.executeQuery("SELECT * FROM student");

            ResultSetMetaData md =
                rs.getMetaData();

            int count = md.getColumnCount();

            System.out.println("Columns: " + count);

            for(int i = 1; i <= count; i++) {
                System.out.println(
                    "Column: " + md.getColumnName(i)
                );

                System.out.println(
                    "Type: " + md.getColumnTypeName(i)
                );
            }

            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
