package design.elux;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class ScannerValidation {
    static Scanner input = new Scanner(System.in);

    private ScannerValidation() {

    }

    public static int getNumber(String message) {
        int num;
        while (true) {
            System.out.println(message);
            try {
                num = input.nextInt();
                //check it
                if(num == -1) {
                    System.exit(0);
                }
                if(!ScannerValidation.isRightNumber(num)) {
                    System.out.println("Wrong input");
                } else {
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Wrong input type");
                input = new Scanner(System.in);
            }
        }
        return num;
    }

        private static boolean isRightNumber(int i) {
            return i >=1 && i <=3;
    }
}



