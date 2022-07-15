package com.example.Controller;

import com.example.entity.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    ConfigInfo configInfo;

    @Value("${school.name}")
    String schoolName;

    @Value("${school.websit}")
    String websit;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return schoolName + "     " + websit;
    }

    @ResponseBody
    @RequestMapping("/configInfo")
    public String configInfo() {
        return configInfo.getName() + "     " + configInfo.getWebsit();
    }
}
