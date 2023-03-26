package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Main class
 *
 * Calculates employee salary and raises warning on incorrect parameters
 *
 * @author Goran J.
 */

public class Main {
    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(Main.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("log.txt", true);
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            LOGGER.warning("Log datoteka se nije uspijela kreirati: " + e.getMessage());
        }

        Employee employee1 = new Employee("Marko", "Mara", 30, 160);
        Employee employee2 = new Employee("Ivo", "Ivek", -45, 140);
        Employee employee3 = new Employee("Lulek", "Lula", 50, 150);

        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);


        try {
            LOGGER.info("Pokrenut program");
            for (Employee emp : employeeArrayList) {
                LOGGER.info(emp.getIme() + " " + emp.getPrezime());
                System.out.println(emp.getIme() + " " + emp.getPrezime() + ", PLACA: "
                        + calculateSalary(emp.getSatnica(), emp.getBrojRadnihSati()));
            }
        } catch (InputMismatchException e) {
            System.out.println("Greska: Uneseno slovo umjesto broja" + e.getMessage());
            LOGGER.warning("Greska: " + e.getMessage());
        } catch (IncorrectHourlyRateException e) {
            System.out.println("Greska: " + e.getMessage());
            LOGGER.warning("Greska: " + e.getMessage());
        } finally {
            System.out.println("Kraj programa.");
            LOGGER.info("Kraj programa.");
        }

    }


    /**
     * Calculate salary method
     *
     * Calculates hourly rate and working hours of month
     *
     * @param hourlyRate
     * @param workingHours
     * @throws IncorrectHourlyRateException
     */
    public static Integer calculateSalary(int hourlyRate, int workingHours) throws IncorrectHourlyRateException {
        int sum = hourlyRate * workingHours;
        if (hourlyRate < 0) {
            throw new IncorrectHourlyRateException("Zaposlenik nemože imati negativnu plaću");
        } else {
            return sum;
        }
    }
}
