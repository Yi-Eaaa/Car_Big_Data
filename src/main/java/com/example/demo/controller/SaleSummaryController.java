package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.*;
import com.example.demo.service.*;
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
public class SaleSummaryController {
    @Autowired
    private ISaleAreaService iSaleAreaService;
    @Autowired
    private ISaleYearService iSaleYearService;
    @Autowired
    private ISaleMonthService iSaleMonthService;
    @Autowired
    private ISaleDayService iSaleDayService;
    @Autowired
    private IDataSaleNumService iDataSaleNumService;
    @Autowired
    private IBrandSaleService iBrandSaleService;
    @Autowired
    private IBrandCarSaleService iBrandCarSaleService;

    @GetMapping("/branddata")
    public List<BrandSale> getAllBrandSaleData(){
        List<BrandSale> res = iBrandSaleService.list( new QueryWrapper<BrandSale>().orderByDesc("sale_num"));
        int rank = 1;
        for(BrandSale value: res){
            value.setId(rank++);
        }
        return res;
    }

    @GetMapping("/brandcardata")
    public List<BrandCarSale> getAllBrandCarSaleData(
            @RequestParam(value = "brand",required = true) String brand
    ){
        QueryWrapper<BrandCarSale> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("brand_name",brand).orderByDesc("sale_num");
        List<BrandCarSale> res = iBrandCarSaleService.list(queryWrapper);
        int rank = 1;
        for(BrandCarSale value: res){
            value.setId(rank++);
        }
        return res;
    }
    @GetMapping("/areadata")
    public DataSaleNum getAreaSaleData(
            @RequestParam(value = "carname",required = true) String carname,
            @RequestParam(value = "area",required = true) String area
    ){
        QueryWrapper<DataSaleNum> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("province",area).like("carname",carname);
        List<DataSaleNum> dataList = iDataSaleNumService.list(queryWrapper);
        Integer cnt = 0;
        for(DataSaleNum value : dataList){
            cnt+=value.getSaleCnt();
        }
        DataSaleNum res = new DataSaleNum();
        res.setSaleCnt(cnt);
        res.setProvince(area);
        res.setCarname(carname);
        return res;
    }

    @GetMapping("/saledata")
    public List sumSaleData(
            @RequestParam(value = "type",required = true) Integer type,
            @RequestParam(value = "year",required = false,defaultValue = "-1") Integer year,
            @RequestParam(value = "month",required = false,defaultValue = "-1") Integer month,
            @RequestParam(value = "day",required = false,defaultValue = "-1") Integer day
    ){

        List<SaleYear> yearlib = iSaleYearService.list();
        List<SaleYear> res = new ArrayList<>();
        for(SaleYear value : yearlib){
            if(value.getSaleCarNameId().equals(type)){
                //yearlib.remove(value);
                res.add(value);
            }
        }
        if(year!=-1){
            Integer yearId = 0;
            List<SaleYear> resyear = new ArrayList<>();
            for(SaleYear value : yearlib){
                if((value.getSaleCarNameId().equals(type)&&value.getSaleYear().equals(year))){
                    resyear.add(value);
                    yearId = value.getSaleYearId();
                }
            }
            if(month!=-1){
                Integer monthId = 0;
                List<SaleMonth> monthlib = iSaleMonthService.list();
                List<SaleMonth> resmonth = new ArrayList<>();
                for(SaleMonth value : monthlib){
                    if((value.getSaleCarNameId().equals(type)&&value.getSaleYearId().equals(yearId)&&value.getSaleMonth().equals(month))){
                        resmonth.add(value);
                        monthId = value.getSaleMonthId();
                    }
                }
                if(day!=-1){
                    List<SaleDay> daylib = iSaleDayService.list();
                    List<SaleDay> resday = new ArrayList<>();
                    for(SaleDay value : daylib){
                        if((value.getSaleCarNameId().equals(type)&&value.getSaleYearId().equals(yearId)&&value.getSaleMonthId().equals(monthId)&&value.getSaleDay().equals(day))){
                            resday.add(value);
                        }
                    }
                    return resday;
                }
                return resmonth;
            }
            return resyear;
        }
        return res;
    }

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
