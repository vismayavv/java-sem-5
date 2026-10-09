import java.sql.*;
import java.io.*;

class BlobClobDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root"
            );

            // Insert image and text
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO files VALUES(?,?,?)"
            );

            ps.setInt(1, 1);

            FileInputStream image =
                new FileInputStream("image.jpg");

            ps.setBinaryStream(2, image);

            FileReader text =
                new FileReader("document.txt");

            ps.setCharacterStream(3, text);

            ps.executeUpdate();

            System.out.println("File stored!");

            image.close();
            text.close();

            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
