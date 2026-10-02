import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedFileCopy {
    public static void main(String[] args) {

        try {
            BufferedInputStream bis =
                    new BufferedInputStream(
                            new FileInputStream("input.txt"));

            BufferedOutputStream bos =
                    new BufferedOutputStream(
                            new FileOutputStream("copy.txt"));

            int data;

            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            bos.close();
            bis.close();

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
