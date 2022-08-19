package com.example.demo.controller;

import com.example.demo.entity.SaleArea;
import com.example.demo.service.ISaleAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/summary")
public class SaleSummary {
    @Autowired
    private ISaleAreaService iSaleAreaService;

    @GetMapping("/area")
    public List<SaleArea> sumByType(
            @RequestParam(value = "type",required = true) Integer typeId,
            @RequestParam(value = "area",required = false,defaultValue = "-1") Integer areaId
    ){
        List<SaleArea> lib = iSaleAreaService.list();
        List<SaleArea> res = new ArrayList<>();
        if(areaId==-1){
            for(SaleArea value : lib){
                if(Objects.equals(value.getSaleCarNameId(), typeId)){
                    res.add(value);
                }
            }
        }else{
            for(SaleArea value : lib){
                if(Objects.equals(value.getSaleCarNameId(), typeId) && Objects.equals(value.getSaleAreaId(), areaId)){
                    res.add(value);
                }
            }
        }
        return res;
    }
}
