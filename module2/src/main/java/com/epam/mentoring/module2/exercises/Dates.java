package com.epam.mentoring.module2.exercises;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dates {

    private static LocalDate getMonthStartDate() {
        return LocalDate.now().withDayOfMonth(1);
    }

    private static LocalDate getMonthEndDate() {
        return LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
    }

    private static List<LocalDate> getDatesOfMonth(LocalDate date, LocalDate endDate) {
        List<LocalDate> dates = new ArrayList<>();
        while (date.isBefore(endDate) || date.isEqual(endDate)) {
            dates.add(date);
            date = date.plusDays(1);
        }
        return dates;
    }

    private static boolean isWorkingDay(LocalDate date) {
        return !(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY));
    }

    public static void main(String[] args) {
        getDatesOfMonth(getMonthStartDate(), getMonthEndDate())
                .stream()
                .filter(Dates::isWorkingDay)
                .forEach(date -> System.out.println(date + ": " + date.getDayOfWeek()));
    }
}
