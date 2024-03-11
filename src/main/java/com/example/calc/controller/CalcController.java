package com.example.calc.controller;
import com.example.calc.model.Employee;
import com.example.calc.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CalcController {

    private final CalcService calcService;

    @Autowired
    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/calculate")
    public double calculateVacationCompensation(@ModelAttribute Employee employee,
                                                @RequestParam(value = "startDate", required = false) LocalDate startDate) {
        if (startDate != null) {
            return calcService.calculateVacationCompensationWithSpecifiedDays(employee, 0, startDate);
        } else {
            return calcService.calculateVacationCompensation(employee);
        }
    }
}