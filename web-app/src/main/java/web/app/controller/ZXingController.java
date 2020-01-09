package web.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.app.facde.IZXingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "二维码")
@RestController("ZxingController.v1")
@RequestMapping("/v1/ZxingController")
public class ZXingController {
    private static final Logger log = LogManager.getLogger(ZXingController.class);

    @Autowired
    public IZXingService ZxingService;


    @ApiOperation(value = "获取二维码")
    @GetMapping
    public HttpServletResponse handleRequest(HttpServletResponse resp, HttpServletRequest request){
        return ZxingService.getRCode(resp);
    }

}
