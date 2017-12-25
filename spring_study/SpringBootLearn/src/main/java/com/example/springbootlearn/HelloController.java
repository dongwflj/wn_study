package com.example.springbootlearn;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController     //等同于同时加上了@Controller和@ResponseBody
@Api("Ewen 服务相关api")
@EnableSwagger2
public class HelloController {
    @ApiOperation("Hello interface")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = {"/hello","/hi"},method = GET,produces = "text/plain;charset=UTF-8")
    public String say(){
        return bookAuthor;
    }

    @Value(value = "${book.author}")
    private String bookAuthor;
}