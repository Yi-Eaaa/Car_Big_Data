package com.example.demo;

import com.example.demo.controller.DataUpdateController;
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
        //System.out.println(iDataSaleNumService.list());
        DataUpdateController.readCsv("C:\\traditionalD\\education\\地区销售数据.csv");
    }

}
