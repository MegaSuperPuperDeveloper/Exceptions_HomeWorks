//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
//Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
//Метод divisionByZero - Деление на 0
//Метод numberFormatException - Ошибка преобразования строки в число
//Важно: они не должны принимать никаких аргументов

class Answer1 {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] c = new int[1];
        System.out.println(c[1]);
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        System.out.println(0 / 0);
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        int b = Integer.parseInt("dasdasdsa");
    }
}

public class Task1 {
    public static void main(String[] args) {
        Answer1 ans = new Answer1();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}