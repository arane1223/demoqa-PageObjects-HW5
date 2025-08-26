package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class RandomDateGeneratorUtils {
    String day;
    String month;
    String year;

    public RandomDateGeneratorUtils() {
        generateRandomDate();
    }

    public void generateRandomDate() {
        // Создаем генератор случайных чисел
        Random random = new Random();

        // Генерируем случайный год в диапазоне 1900-2025
        this.year = String.valueOf(1900 + random.nextInt(126));

        // Генерируем случайный месяц (1-12)
        String monthNumber = String.valueOf(1 + random.nextInt(12));

        // Генерируем случайный день с учетом количества дней в месяце
        this.day = generateRandomDay(this.year, monthNumber);

        // Создаем объект LocalDate из строк
        LocalDate date = LocalDate.parse(this.year + "-" +
                (monthNumber.length() == 1 ? "0" + monthNumber : monthNumber) + "-" +
                (this.day.length() == 1 ? "0" + this.day : this.day));

        // Получаем полное название месяца
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
        this.month = date.format(monthFormatter);
    }

    // Метод для генерации корректного дня месяца с учетом високосных годов
    private String generateRandomDay(String yearStr, String monthStr) {
        Random random = new Random();
        int yearInt = Integer.parseInt(yearStr);
        int monthInt = Integer.parseInt(monthStr);
        int maxDays;

        switch (monthInt) {
            case 2: // Февраль
                maxDays = isLeapYear(yearInt) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11: // Апрель, Июнь, Сентябрь, Ноябрь
                maxDays = 30;
                break;
            default: // Все остальные месяцы
                maxDays = 31;
        }

        return String.valueOf(1 + random.nextInt(maxDays));
    }

    // Метод для проверки високосного года
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}