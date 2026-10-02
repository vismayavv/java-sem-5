import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeRecord {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            DataOutputStream dos =
                    new DataOutputStream(
                            new FileOutputStream("employees.dat"));

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            dos.writeInt(id);
            dos.writeUTF(name);
            dos.writeDouble(salary);

            dos.close();

            System.out.println("\nEmployee details stored successfully.");

            DataInputStream dis =
                    new DataInputStream(
                            new FileInputStream("employees.dat"));

            System.out.println("\nEmployee Details:");

            try {
                while (true) {
                    int empId = dis.readInt();
                    String empName = dis.readUTF();
                    double empSalary = dis.readDouble();

                    System.out.println("ID: " + empId);
                    System.out.println("Name: " + empName);
                    System.out.println("Salary: " + empSalary);
                }
            } catch (EOFException e) {
                // End of file reached
            }

            dis.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
