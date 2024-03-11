package com.example.calc.service;
import com.example.calc.model.Employee;
import org.springframework.stereotype.Service;
@Service
public class CalcService {
        public double calculateVacationCompensation(Employee employee) {
            return 0;
        }

        public double calculateVacationCompensationWithSpecifiedDays(Employee employee, int specifiedVacationDays) {
            double compensation = 0;
            return compensation;
        }

        private int calculateHolidaysInVacation(Employee employee, int specifiedVacationDays) {
            int holidays = 0;
            return holidays;
        }


        private int calculateWeekendsInVacation(Employee employee, int specifiedVacationDays) {
            int weekends = 0;
            return weekends;
        }
}
