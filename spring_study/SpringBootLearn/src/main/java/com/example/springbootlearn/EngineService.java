package com.example.springbootlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ewen on 2017/12/22.
 */
@Component     //等同于同时加上了@Controller和@ResponseBody
public class EngineService {
    private int a = 0;
    public int add(int l, int r) {
        if (l > 0) {
            return l + r;
        }
        else {
            return r + l;
        }
    }
    public int get() {
        return a++;
    }
}
