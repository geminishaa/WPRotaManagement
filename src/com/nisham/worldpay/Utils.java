package com.nisham.worldpay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by nisham on 16/11/16.
 */
public class Utils {

    public static LocalDate getDate(Scanner scanner, String inputPrompt, String datePattern) {
        LocalDate date = null;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
        while (date == null) {
            System.out.println(inputPrompt + " as " + datePattern);
            String userInput = scanner.nextLine();
            try {
                date = LocalDate.parse(userInput, dateTimeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Date entered : " + userInput + " is wrong - Any key or enter to try again, n to exit");
                String again = scanner.nextLine();
                if (again.equalsIgnoreCase("n") || again.equalsIgnoreCase("no")) {
                    System.exit(0);
                }
            }
        }
        return date;
    }

    public static long getTotalWeeks(LocalDate startWeekDate,LocalDate endWeekDate){
        return ChronoUnit.WEEKS.between(startWeekDate, endWeekDate);
    }

    public static int getWeekNumber(LocalDate date){
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber=date.get(weekFields.weekOfWeekBasedYear());
        return weekNumber;

    }

    public static LocalDate getNextWeek(LocalDate currentWeekDate){
        currentWeekDate=currentWeekDate.plusDays(7);
        return currentWeekDate;
    }

    public static LocalDate getWeekMonday(LocalDate date){
        return date.with(DayOfWeek.MONDAY);
    }

    public static boolean checkEnteredDate(Scanner scanner,LocalDate startWeekDate,LocalDate endWeekDate){
        boolean checkContinue=true;
        if (startWeekDate.isAfter(endWeekDate)) {
            System.out.println("Start Date is less than End Date. Any key or enter to try again, n to exit");
            String again = scanner.nextLine();
            if (again.equalsIgnoreCase("n") || again.equalsIgnoreCase("no")) {
                System.exit(0);
            }
        }
        else{
            checkContinue=false;}

        return checkContinue;
    }



}





