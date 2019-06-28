package com.demo.controller;


import com.demo.entity.Test;
import com.demo.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 肖钊容
 * @since 2019-06-27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestServiceImpl testService;

    @GetMapping("/list")
    public Object list(){
        return testService.list();
    }

    @PutMapping()
    public Object upById(@RequestBody Test test){
        return testService.updateById(test);
    }

    @PostMapping()
    public Object postById(@RequestBody Test test){
        return testService.save(test);
    }
}
