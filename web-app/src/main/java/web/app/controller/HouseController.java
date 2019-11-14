package web.app.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/12 10:19
 * @Version:1.0
 * @deseription:
 **/
@RestController
public class HouseController {
    private static final Logger log = LogManager.getLogger(HouseController.class);


    @RequestMapping("/info")
    public String handleRequest(){
        System.out.println("----HouseController executed----");

        return "re/index";
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.println("index!!!");
       return new ModelAndView("/index");
    }

    @RequestMapping("/getHeaderAndCookie")
    public String testHeaderAndCookie(
            @RequestHeader(value = "User-Agent",required = false,defaultValue ="attribute") String userAgent,
            @CookieValue(value = "JSESSIONID",required = true ,defaultValue ="MyJsessionId")String jsessionId
    ){
        System.out.println("User-Agent: " + userAgent);
        System.out.println("JSESSIONID: " + jsessionId);
        return "index";
    }

}
