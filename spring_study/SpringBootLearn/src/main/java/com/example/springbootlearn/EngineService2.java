package com.example.springbootlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ewen on 2017/12/22.
 */
@Component     //等同于同时加上了@Controller和@ResponseBody
public class EngineService2 {
    @Autowired
    private EngineService service;
    public int get() {
        return service.get();
    }
}
