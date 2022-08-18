package com.carbigdata;

import com.carbigdata.entity.CarParameter;
import com.carbigdata.service.ICarParameterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private ICarParameterService iCarParameterService;

    @Test
    void mytest() {
        List<CarParameter> list = iCarParameterService.list();
        for(CarParameter carParameter:list){
            System.out.println(carParameter.getSysParaCarId());
        }
    }

    @Test
    void contextLoads() {
    }

}
