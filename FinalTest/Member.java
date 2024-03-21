import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import MyExceptions.IncorrectEnter;
import MyExceptions.IncorrectLength;

public class Member { // Люди с регистрацией
    private String lastName;
    private String name;
    private String patronymic;
    private String birthday;
    private long number;
    private char sex;

    public Member() throws IOException { // Конструктор
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные форматом <Фамилия> <Имя> <Отчество> <дата_рождения> <номер_телефона> <пол>");
            String registration = scanner.nextLine();
            String[] data = registration.split(" ");
            if (data.length != 6) throw new IncorrectLength();
            
            // Вписывание информации для экземпляра
            SetBirthday(data[3]);
            SetNumber(data[4]);
            SetSex(data[5]);
            this.name = data[1];
            this.lastName = data[0];
            this.patronymic = data[2];

            CreateOfLog(registration);
        }
    }

    public void SetBirthday(String data) { // Функция для ввода даты рождения
        String[] birthdayString = data.split(Pattern.quote("."));
        int[] birthday = new int[birthdayString.length];
        if (birthdayString.length != 3) { // Первая проверка на формат даты
            throw new IncorrectLength("Данные введены неверно для даты рождения");
        }
        try { // Конвертация даты рождения в числа + проверка на наличие цифр
            for (int i = 0; i < birthday.length; i++) { 
                birthday[i] = Integer.parseInt(birthdayString[i]);
            }
        } catch(NumberFormatException exception) {
            throw new IncorrectEnter("В дате рождения должны быть цифры!");
        }
        if (birthday[0] >= 1 && birthday[0] <= 31 // Проверка на корректность данных
            && birthday[1] >= 1 && birthday[1] <= 12
            && birthday[2] < 2025 && birthday[2] >= 1850) 
            {
            this.birthday = String.format("%d.%d.%d", birthday[0], birthday[1], birthday[2]);
        } else {
            throw new IncorrectEnter("Вы не могли родиться в этот день.");
        }
    }

    public String GetBirthday() {
        return this.birthday;
    }

    public void SetNumber(String data) { // Функция нужна для ввода номера телефона
        long number = Long.parseLong(data);
        if(data.length() != 10) throw new IncorrectEnter("Нужно ввести номер длиной 10 цифр, без формата");
        if (number / 1000000000 == 7) throw new IncorrectEnter("Нужно ввести номер без форматирования");
        if (number / 1000000000 != 9) throw new IncorrectEnter("Первая цифра номера должна начинаться на 9!");
        this.number = number;
    }

    public long GetNumber() {
        return this.number;
    }

    public void SetSex(String data) { // Функция нужна для установки пола.
        if (data.length() != 1) throw new IncorrectEnter("Введите первую букву своего пола m/f."); 
        char sex = data.charAt(0);
        if (sex == 'm' || sex == 'f') this.sex = sex;
        else throw new IncorrectEnter("Введите m или f.");
    }

    public char GetSex() {
        return this.sex;
    }

    public String GetName() {
        return this.name;
    }

    public String GetLastName() {
        return this.lastName;
    }

    public String GetPatronymic() {
        return this.patronymic;
    }

    public void CreateOfLog(String registration) throws IOException {
        // Создание или добавление информации для файла
        // Если новая фамилия, то создать новый файл
        // Если нет, то добавить информацию в файл с такой же фамилией
        File file = new File(lastName + ".txt");
        if (!file.exists()) {
            file.createNewFile();
            try(FileWriter writer = new FileWriter(file)) {
                writer.write(registration + "\n");
            }
        } else {
            try(FileWriter writer = new FileWriter(file, true)) {
                writer.write(registration + "\n");
            }
        }
    }

}
