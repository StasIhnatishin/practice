import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ваше ім'я: ");
        String name = scanner.nextLine();
        System.out.println("Привіт, " + name + "!");
        scanner.close();
    }
}
