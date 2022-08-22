package com.example.demo;

import com.example.demo.service.ICarParameterService;
import com.example.demo.service.IDataSaleNumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaranalysisApplicationTests {

    @Autowired
    private IDataSaleNumService iDataSaleNumService;
    @Test
    void contextLoads() {
        System.out.println(iDataSaleNumService.list());
    }

}
