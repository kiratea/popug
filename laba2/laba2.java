import java.util.Scanner;

public class laba2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long a = getLong();
        sqrt(a);
    }

    static void sqrt(long a) {
        double b = a;
        int i = 0;
        while ((b * b > a) && (i < 200)) {
            b = (b + a / b) / 2;
            i++;
        }
        System.out.println("Квадратный корень из этого числа равен:");
        System.out.println(b);
    }

    public static long getLong() {
        System.out.println("Введите число:");
        long num;
        if (scanner.hasNextLong()) {
            num = scanner.nextLong();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getLong();
        }
        return num;
    }

}