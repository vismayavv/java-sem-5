import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter index: ");

        try {
            int index = sc.nextInt();

            int result = arr[index] / index;

            System.out.println("Result = " + result);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
        finally {
            System.out.println("Exception handling completed");
        }
    }
}
