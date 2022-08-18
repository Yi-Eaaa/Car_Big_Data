package com.example.demo;

import com.example.demo.service.ICarParameterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaranalysisApplicationTests {

    @Autowired
    private ICarParameterService iCarParameterService;
    @Test
    void contextLoads() {
        System.out.println(iCarParameterService.list());
    }

}
