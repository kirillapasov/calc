package com.example.calc.controller;
import com.example.calc.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CalcController {

    private final CalcService calcService;

    @Autowired
    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }


}