package com.example.calc.service;
import com.example.calc.model.Employee;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class CalcService {
        public double calculateVacationCompensation(Employee employee) {
            return employee.getAverageSalary() / 12 * employee.getVacationDays();
        }

        public double calculateVacationCompensationWithSpecifiedDays(Employee employee, int specifiedVacationDays) {
            int totalVacationDays = employee.getVacationDays() + specifiedVacationDays;
            double compensation = employee.getAverageSalary() / 12 * totalVacationDays;
            int holidays = calculateHolidaysInVacation(employee, specifiedVacationDays);
            int weekends = calculateWeekendsInVacation(employee, specifiedVacationDays);
            compensation -= (holidays + weekends) * employee.getAverageSalary() / 12;
            return compensation;
        }

        private int calculateHolidaysInVacation(Employee employee, int specifiedVacationDays) {
            int holidays = 0;
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(specifiedVacationDays);
            while (!startDate.isAfter(endDate)) {
                if (isHoliday(startDate)) {
                    holidays++;
                }
                startDate = startDate.plusDays(1);
            }
            return holidays;
        }
        private boolean isHoliday(LocalDate date) {
            List<LocalDate> holidays = Arrays.asList(
                    LocalDate.of(date.getYear(), Month.JANUARY, 1),
                    LocalDate.of(date.getYear(), Month.JANUARY, 7),
                    LocalDate.of(date.getYear(), Month.MAY, 1),
                    LocalDate.of(date.getYear(), Month.MAY, 9),
                    LocalDate.of(date.getYear(), Month.JUNE, 12),
                    LocalDate.of(date.getYear(), Month.NOVEMBER, 4)
            );
            return holidays.contains(date);
        }


        private int calculateWeekendsInVacation(Employee employee, int specifiedVacationDays) {
                int weekends = 0;
                LocalDate startDate = LocalDate.now();
                LocalDate endDate = startDate.plusDays(specifiedVacationDays);
                while (!startDate.isAfter(endDate)) {
                    if (isWeekend(startDate)) {
                        weekends++;
                    }
                    startDate = startDate.plusDays(1);
                }
                return weekends;
            }
        private boolean isWeekend(LocalDate date) {
            return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
        }
}
