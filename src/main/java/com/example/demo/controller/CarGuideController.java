package com.example.demo.controller;


import cn.hutool.db.Page;
import com.example.demo.entity.CarParameter;
import com.example.demo.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
            @RequestParam(value = "manufactor",required = false,defaultValue = "") String manufactor
    ){
        buffInit();
        List<CarParameter> lib = iCarParameterService.list();
        List<CarParameter> res = new ArrayList<>();
        if(!name.isEmpty()) {
            for (CarParameter value : lib) {
                if (value.getSysParaCarName().contains(name)) {
                    res.add(value);
                }
            }
            if (!type.isEmpty()) {
                res.clear();
                for (CarParameter value : lib) {
                    if (value.getSysParaCarName().contains(name) && value.getSysParaType().contains(type)) {
                        res.add(value);
                    }
                }
                if (!manufactor.isEmpty()) {
                    res.clear();
                    for (CarParameter value : lib) {
                        if (value.getSysParaCarName().contains(name) && value.getSysParaType().contains(type) && value.getSysParaManufactor().contains(manufactor)) {
                            res.add(value);
                        }
                    }
                    carInfoBuffer.addAll(res);
                    return res;
                }
                carInfoBuffer.addAll(res);
                return res;
            }
            carInfoBuffer.addAll(res);
            return res;
        }else{
            carInfoBuffer.addAll(lib);
            return lib;
        }
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
