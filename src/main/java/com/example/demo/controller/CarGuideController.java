package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.entity.CarParameter;
import com.example.demo.entity.DataSaleNum;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/carguide")
public class CarGuideController {
    @Autowired
    private ICarParameterService iCarParameterService;
    @Autowired
    private ISaleAreaService iSaleAreaService;
    @Autowired
    private ISaleCarService iSaleCarService;
    @Autowired
    private ISaleDayService iSaleDayService;
    @Autowired
    private ISaleMonthService iSaleMonthService;
    @Autowired
    private ISaleYearService iSaleYearService;

    private List<CarParameter> carInfoBuffer = new ArrayList<>();

    private void buffInit(){
        carInfoBuffer.clear();
    }

    @GetMapping("/testAll")
    public List<CarParameter> testAll(){
        return iCarParameterService.list();
    }

    @GetMapping("/searchbyname")
    public List<CarParameter> searchByName(@RequestParam(value="name") String name){
        buffInit();
        List<CarParameter> lib = iCarParameterService.list();
        List<CarParameter> res = new ArrayList<>();
        for(CarParameter value : lib){
            if(value.getSysParaCarName().contains(name)){
                res.add(value);
            }
        }
        carInfoBuffer.addAll(res);
        return res;
    }

    @GetMapping("/searchbytype")
    public List<CarParameter> searchByType(@RequestParam(value="type") String type){
        buffInit();
        List<CarParameter> lib = iCarParameterService.list();
        List<CarParameter> res = new ArrayList<>();
        for(CarParameter value : lib){
            if(value.getSysParaType().contains(type)){
                res.add(value);
            }
        }
        carInfoBuffer.addAll(res);
        return res;
    }

    @GetMapping("/searchbymanufactor")
    public List<CarParameter> searchByManufactor(@RequestParam(value="manufactor") String manufactor){
        buffInit();
        List<CarParameter> lib = iCarParameterService.list();
        List<CarParameter> res = new ArrayList<>();
        for(CarParameter value : lib){
            if(value.getSysParaManufactor().contains(manufactor)){
                res.add(value);
            }
        }
        carInfoBuffer.addAll(res);
        return res;
    }

    @GetMapping("/search")
    public List<CarParameter> search(
            @RequestParam(value = "name",required = false,defaultValue = "") String name,
            @RequestParam(value = "type",required = false,defaultValue = "") String type,
            @RequestParam(value = "manufactor",required = false,defaultValue = "") String manufactor,
            @RequestParam(value = "speedmax",required = false,defaultValue = "-1") Double speedmax,
            @RequestParam(value = "speedmin",required = false,defaultValue = "-1") Double speedmin,
            @RequestParam(value = "torquemax",required = false,defaultValue = "-1") Double torquemax,
            @RequestParam(value = "torquemin",required = false,defaultValue = "-1") Double torquemin,
            @RequestParam(value = "energymin",required = false,defaultValue = "-1") Double energymin,
            @RequestParam(value = "energymax",required = false,defaultValue = "-1") Double energymax,
            @RequestParam(value = "pricemin",required = false,defaultValue = "-1") Double pricemin,
            @RequestParam(value = "pricemax",required = false,defaultValue = "-1") Double pricemax

    ){
        buffInit();
        QueryWrapper<CarParameter> dataSaleNumQueryWrapper = new QueryWrapper<>();
        dataSaleNumQueryWrapper
                .like(StringUtils.isNotEmpty(name),"sys_para_car_name",name)
                .eq(StringUtils.isNotEmpty(type),"sys_para_type",type)
                .eq(StringUtils.isNotEmpty(manufactor),"sys_para_manufactor",manufactor)
                .le(speedmax>=0,"sys_para_maxspeed",speedmax)
                .ge(speedmin>=0,"sys_para_maxspeed",speedmin)
                .le(torquemax>=0,"sys_para_torque",torquemax)
                .ge(torquemin>=0,"sys_para_torque",torquemin)
                .le(energymax>=0,"sys_para_km_energy",energymax)
                .ge(energymin>=0,"sys_para_km_energy",energymin)
                .le(pricemax>=0,"sys_para_guide_price",pricemax)
                .ge(pricemin>=0,"sys_para_guide_price",pricemin);
        List<CarParameter> res = iCarParameterService.list(dataSaleNumQueryWrapper);
        carInfoBuffer = res;
        return res;
    }

    @GetMapping("/changepage")
    public List<CarParameter> changePage(@RequestParam(value="page") Integer page,@RequestParam(value="size") Integer size){
        List<CarParameter> lib = carInfoBuffer;
        List<CarParameter> res = new ArrayList<>();
        Integer listsize = lib.size();
        if((page-1)*size<=listsize&&page*size<=listsize){
            res = lib.subList((page-1)*size,page*size);
        }else if((page-1)*size<=listsize&&page*size>listsize){
            res = lib.subList((page-1)*size,listsize);
        }else{
            //全都越界了，还找什么找？！
        }
        return res;
    }




}
