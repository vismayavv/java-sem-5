import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        try {
            FileOutputStream fos =
                    new FileOutputStream("output.txt", true);

            fos.write((text + System.lineSeparator()).getBytes());

            fos.close();

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        sc.close();
    }
}
