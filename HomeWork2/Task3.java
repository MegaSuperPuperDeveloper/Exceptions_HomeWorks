// Напишите программу для выполнения арифметической операции деления двух целых чисел a и b.
// При этом программа должна проверить, что делитель b не равен нулю, и выполнить деление только в этом случае.
// Если b равен нулю, программа должна вернуть результат равный нулю.
// После выполнения операции деления, программа также должна вывести сумму чисел a и b с помощью метода printSum.
// Если аргументы не переданы через командную строку, используйте значения по умолчанию.

package HomeWork2;

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task3 {
    public static void main(String[] args) {
        int a;
        int b;

        if (args.length == 0) {
            a = 7;
            b = 0; // Default values if no arguments are provided
        } else {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        } 

        double result = Expr.expr(a, b);
        System.out.println(result);
    }
}

class Expr {

    public static double expr(int a, int b) {
        // Введите свое решение ниже
        printSum(a, b);
        if (b == 0) {
            return 0d;
        }
        return (double)a / (double)b;
    }

    public static void printSum(int a, int b) {
        // Введите свое решение ниже
        System.out.println(a + b);
    }

}