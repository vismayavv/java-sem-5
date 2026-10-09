import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentDataStream {
    public static void main(String[] args) {

        int rollNo = 101;
        String name = "Vismaya";
        double marks = 89.5;

        try {
            DataOutputStream dos =
                    new DataOutputStream(
                            new FileOutputStream("student.dat"));

            dos.writeInt(rollNo);
            dos.writeUTF(name);
            dos.writeDouble(marks);

            dos.close();

            DataInputStream dis =
                    new DataInputStream(
                            new FileInputStream("student.dat"));

            int r = dis.readInt();
            String n = dis.readUTF();
            double m = dis.readDouble();

            dis.close();

            System.out.println("Student Details");
            System.out.println("Roll No: " + r);
            System.out.println("Name: " + n);
            System.out.println("Marks: " + m);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
