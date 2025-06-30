package standard;

import variables.Defines;

import java.time.LocalDate;

public class StandardZodiac extends Defines {

    public static String getZodiac(int year, int month, int dayOfMonth) {
                localDate = LocalDate.of(year,month,dayOfMonth);
        if (!localDate.isBefore(LocalDate.of(year, 3, 21)) && !localDate.isAfter(LocalDate.of(year, 4, 19))) {
            return "Aries";
        } else if (!localDate.isBefore(LocalDate.of(year, 4, 20)) && !localDate.isAfter(LocalDate.of(year, 5, 20))) {
            return "Taurus";
        } else if (!localDate.isBefore(LocalDate.of(year, 5, 21)) && !localDate.isAfter(LocalDate.of(year, 6, 20))) {
            return "Gemini";
        } else if (!localDate.isBefore(LocalDate.of(year, 6, 21)) && !localDate.isAfter(LocalDate.of(year, 7, 22))) {
            return "Cancer";
        } else if (!localDate.isBefore(LocalDate.of(year, 7, 23)) && !localDate.isAfter(LocalDate.of(year, 8, 22))) {
            return "Leo";
        } else if (!localDate.isBefore(LocalDate.of(year, 8, 23)) && !localDate.isAfter(LocalDate.of(year, 9, 22))) {
            return "Virgo";
        } else if (!localDate.isBefore(LocalDate.of(year, 9, 23)) && !localDate.isAfter(LocalDate.of(year, 10, 22))) {
            return "Libra";
        } else if (!localDate.isBefore(LocalDate.of(year, 10, 23)) && !localDate.isAfter(LocalDate.of(year, 11, 21))) {
            return "Scorpio";
        } else if (!localDate.isBefore(LocalDate.of(year, 11, 22)) && !localDate.isAfter(LocalDate.of(year, 12, 21))) {
            return "Sagittarius";
        } else if (!localDate.isBefore(LocalDate.of(year, 12, 22)) || !localDate.isAfter(LocalDate.of(year, 1, 19))) {
            return "Capricorn";
        } else if (!localDate.isBefore(LocalDate.of(year, 1, 20)) && !localDate.isAfter(LocalDate.of(year, 2, 18))) {
            return "Aquarius";
        } else if (!localDate.isBefore(LocalDate.of(year, 2, 19)) && !localDate.isAfter(LocalDate.of(year, 3, 20))) {
            return "Pisces";
        } else {
            return "";
        }
    }

}
