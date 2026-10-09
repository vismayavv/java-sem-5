import java.sql.*;

class TransactionDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            con.setAutoCommit(false);

            try {
                // Deduct money
                PreparedStatement p1 =
                    con.prepareStatement(
                        "UPDATE account SET balance=balance-1000 WHERE id=1"
                    );

                p1.executeUpdate();

                // Add money
                PreparedStatement p2 =
                    con.prepareStatement(
                        "UPDATE account SET balance=balance+1000 WHERE id=2"
                    );

                p2.executeUpdate();

                con.commit();

                System.out.println("Transaction successful!");

            }
            catch(Exception e) {
                con.rollback();
                System.out.println("Transaction failed!");
            }

            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
