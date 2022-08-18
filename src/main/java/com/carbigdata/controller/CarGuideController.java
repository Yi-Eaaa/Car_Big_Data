package com.carbigdata.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.carbigdata.entity.CarParameter;
import com.carbigdata.service.ICarParameterService;
import com.carbigdata.service.impl.CarParameterServiceImpl;
import com.carbigdata.utils.CommonPage;
import com.carbigdata.utils.CommonUtils;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hongyi
 * @since 2022-08-16
 */
@Controller
@RequestMapping("/CarGuide")
public class CarGuideController {

    @Autowired
    private ICarParameterService carParameterService;

//    @GetMapping("/test")
//    @ResponseBody
//    public String index() {
//       return "/viewtest";
//    }

    @GetMapping("/test/search")
    @ResponseBody
    public String ManufactorGuide(HttpServletRequest request, Integer pageNumber, String manufactor, Model model){
        if (StrUtil.isBlank(manufactor)) {
            return "/";
        }
        manufactor = manufactor.trim();
        model.addAttribute("manufactor", manufactor);
        if (Objects.isNull(pageNumber) || pageNumber < 1) {
            pageNumber = 1;
        }

//        //查询到的文章列表
//        List<CarParameter> carParameterList = new ArrayList<>();

        //拆分搜索词,查询生产商
        List<Word> words = WordSegmenter.seg(manufactor);
        List<String> manufactorList = words.stream().map(Word::getText).collect(Collectors.toList());
        manufactorList.add(manufactor);
        List<String> carParameterIdList = carParameterService.list(Wrappers.<CarParameter>lambdaQuery()
                .in(CarParameter::getSysParaManufactor, manufactorList)
                .select(CarParameter::getSysParaCarId)).stream().map(CarParameter::getSysParaCarId).collect(Collectors.toList());


        //分页查询
        IPage<CarParameter> carParameterPage = new Page<>(pageNumber, 12);
        LambdaQueryWrapper<CarParameter> queryWrapper = Wrappers.<CarParameter>lambdaQuery()
                .like(CarParameter::getSysParaManufactor, manufactor)
                .select(CarParameter::getSysParaCarId,
                        CarParameter::getSysParaCarName,
                        CarParameter::getSysParaProductiveYear,
                        CarParameter::getSysParaType,
                        CarParameter::getSysParaManufactor,
                        CarParameter::getSysParaPowerType);
        if (CollUtil.isNotEmpty(carParameterIdList)) {
            queryWrapper.or().in(CarParameter::getSysParaCarId, carParameterIdList);
        }

        IPage<CarParameter> carParameterIPage = carParameterService.page(carParameterPage, queryWrapper);
        model.addAttribute("carParameterIPage", CommonPage.restPage(carParameterIPage));

        return "/viewtest";

    }

}
