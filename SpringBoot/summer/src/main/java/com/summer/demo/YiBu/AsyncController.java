package com.summer.demo.YiBu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class AsyncController {

    @Autowired
    AysncService aysncService;

    @RequestMapping("/heelo")
    public String heool(){
        aysncService.hello();
        return "success";
    }
}
