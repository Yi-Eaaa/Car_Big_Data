package com.carbigdata.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hongyi
 * @since 2022-08-16
 */
@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "hongyi";
    }
}
