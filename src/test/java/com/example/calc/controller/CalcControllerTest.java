package com.example.calc.controller;
import com.example.calc.model.Employee;
import com.example.calc.service.CalcService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcControllerTest {
    private CalcService calcService;
    private CalcController calcController;


    @BeforeEach
    public void setup(){
        calcService = new CalcService();
        calcController = new CalcController(calcService);
    }

    @Test
    public void testCalculateVacationCompensation() {
        Employee employee = new Employee();
        employee.setAverageSalary(1000);
        employee.setVacationDays(20);

        double compensation = calcController.calculateVacationCompensation(employee, null);

        assertEquals(500.0, compensation, 0.01);
    }

    @Test
    public void testCalculateVacationCompensationWithStartDate() {
        Employee employee = new Employee();
        employee.setAverageSalary(1000);
        employee.setVacationDays(20);
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        double expected = 1500.0;
        double delta = 0.01;
        double actual = calcController.calculateVacationCompensation(employee, startDate);
        double roundedActual = Math.round(actual * 100.0) / 100.0;
        assertEquals(expected, roundedActual, delta);
    }
}
