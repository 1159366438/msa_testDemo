package com.example.Controller;


import com.example.service.OidInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RedisController {

    @Autowired
    private OidInstanceService oidInstanceService;

    /**
     * 请求地址：
     * http://localhost:9090/016-springboot-redis//springboot/allStudentCount
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/springboot/allCodeCount")
    public Object allCodeCount(HttpServletRequest request) {

        Long allCodeCount = oidInstanceService.queryAllCodeCount();

        return "学生总人数：" + allCodeCount;
    }
}
