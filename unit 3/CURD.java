import java.sql.*;

class CRUD {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            Statement st = con.createStatement();

            // INSERT
            st.executeUpdate(
                "INSERT INTO student VALUES(1,'Anu',80)"
            );

            // UPDATE
            st.executeUpdate(
                "UPDATE student SET mark=90 WHERE id=1"
            );

            // DELETE
            // st.executeUpdate("DELETE FROM student WHERE id=1");

            // SELECT
            ResultSet rs = st.executeQuery(
                "SELECT * FROM student"
            );

            while(rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("mark")
                );
            }

            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
