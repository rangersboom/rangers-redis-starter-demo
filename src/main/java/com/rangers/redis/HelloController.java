package com.rangers.redis;

import com.rangers.redis.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/setObject/{name}")
    public ResultUtil setObject(@PathVariable(value = "name") String name) {
        User user = helloService.setObject(name);
        return ResultUtil.success(user);
    }

    @GetMapping("/setMap/{name}")
    public ResultUtil setMap(@PathVariable(value = "name") String name) {
        Map<String,User> res = helloService.setMap(name);
        return ResultUtil.success(res);
    }

    @GetMapping("/setHash/{name}")
    public ResultUtil setHash(@PathVariable(value = "name") String name) {
        Map<String,User> s = helloService.setHash(name);
        return ResultUtil.success(s);
    }

    @GetMapping("/setList/{name}")
    public ResultUtil setList(@PathVariable(value = "name") String name) {
        List<User> s = helloService.setList(name);
        return ResultUtil.success(s);
    }

}

