import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задача 4.1: Подсчет вхождений подстроки в строке
        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();
        System.out.println("Введите подстроку:");
        String substring = scanner.nextLine();
        int count = countOccurrences(inputString, substring);
        System.out.println("Подстрока '" + substring + "' встречается " + count + " раз(а)");

        // Задача 4.2: Замена в строке всех слов "кака" и "бяка"
        System.out.println("Введите строку для замены:");
        String replaceString = scanner.nextLine();
        String modifiedString = replaceWords(replaceString);
        System.out.println(modifiedString);

        // Задача 4.3: Преобразование формата даты
        System.out.println("Введите дату в формате 'дд.мм.гггг':");
        String dateInput = scanner.nextLine();
        String formattedDate = convertDateFormat(dateInput);
        System.out.println(formattedDate);

        // Задача 4.4: Преобразование формата даты с использованием классов Date и SimpleDateFormat
        System.out.println("Введите дату в формате 'дд.мм.гггг' для преобразования с использованием Date и SimpleDateFormat:");
        String dateInput2 = scanner.nextLine();
        convertDateUsingDateFormat(dateInput2);

        scanner.close();
    }

    // Метод для подсчета вхождений подстроки
    public static int countOccurrences(String str, String subStr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }
        return count;
    }

    // Метод для замены слов "кака" и "бяка"
    public static String replaceWords(String str) {
        return str.replace("кака", "вырезано цензурой")
                .replace("бяка", "вырезано цензурой");
    }

    // Метод для преобразования формата даты
    public static String convertDateFormat(String date) {
        String[] parts = date.split("\\.");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }

    // Метод для преобразования формата даты с использованием Date и SimpleDateFormat
    public static void convertDateUsingDateFormat(String date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedDate = inputFormat.parse(date);
            String formattedDate = outputFormat.format(parsedDate);
            System.out.println(formattedDate);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Пожалуйста, используйте 'дд.мм.гггг'.");
        }
    }
}
