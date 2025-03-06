import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**Клас для демонстрації серіалізації/десеріалізації в діалоговому режимі*/
public class Main {
    private Calc calc = new Calc();

    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command");
                System.out.print("'q'quit, 'v'view, 'g'generate, 's'save, 'r'restoree, 'c'calculate binary room dimensions, 'a'add, 'e'subtract: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;

                case 'v':
                    System.out.println("View current.");
                    calc.show();
                    break;

                case 'g':
                    System.out.println("Random generation.");
                    calc.init(Math.random() * 360.0);
                    calc.show();
                    break;

                case 's':
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                    break;
                case 'c':
                    System.out.print("Enter length in binary: ");
                    try {
                        String lengthBinary = in.readLine();
                        if (!isValidBinary(lengthBinary)) {
                            System.out.println("Invalid binary number format for length.");
                            break;
                        }
                        System.out.print("Enter width in binary: ");
                        String widthBinary = in.readLine();
                        if (!isValidBinary(widthBinary)) {
                            System.out.println("Invalid binary number format for width.");
                            break;
                        }
                        System.out.print("Enter height in binary: ");
                        String heightBinary = in.readLine();
                        if (!isValidBinary(heightBinary)) {
                            System.out.println("Invalid binary number format for height.");
                            break;
                        }
                        int length = Integer.parseInt(lengthBinary, 2);
                        int width = Integer.parseInt(widthBinary, 2);
                        int height = Integer.parseInt(heightBinary, 2);
                        int perimeter = 2 * (length + width);
                        System.out.println("Perimeter of the room: " + perimeter);
                        int area = length * width;
                        System.out.println("Area of the room: " + area);
                        int volume = length * width * height;
                        System.out.println("Volume of the room: " + volume);
                    } catch (IOException e) {
                        System.out.println("Input error: " + e);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid binary number format.");
                    }
                    break;
                case 'a':
                    System.out.print("Enter first number: ");
                    try {
                        double num1 = Double.parseDouble(in.readLine());
                        System.out.print("Enter second number: ");
                        double num2 = Double.parseDouble(in.readLine());
                        double result = num1 + num2;
                        System.out.println("Result of addition: " + result);
                    } catch (IOException e) {
                        System.out.println("Input error: " + e);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format.");
                    }
                    break;
                case 'e':
                    System.out.print("Enter first number: ");
                    try {
                        double num1 = Double.parseDouble(in.readLine());
                        System.out.print("Enter second number: ");
                        double num2 = Double.parseDouble(in.readLine());
                        double result = num1 - num2;
                        System.out.println("Result of subtraction: " + result);
                    } catch (IOException e) {
                        System.out.println("Input error: " + e);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format.");
                    }
                    break;
                default:
                    System.out.println("Wrong command.");
            }
        } while (s.charAt(0) != 'q');
    }

    private boolean isValidBinary(String binaryString) {
        return binaryString.matches("[01]+");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
