package com.example.calc.controller;
import com.example.calc.service.CalcService;
import org.junit.jupiter.api.BeforeEach;
public class CalcControllerTest {
    private CalcService calcService;
    private CalcController calcController;

    @BeforeEach
    public void setup(){
        calcService = new CalcService();
        calcController = new CalcController(calcService);

    }
}
