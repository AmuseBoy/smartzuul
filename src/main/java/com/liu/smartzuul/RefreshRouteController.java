package com.liu.smartzuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RefreshRouteController
 * @Description TODO
 * @Author 刘培振
 * @Date 2020-07-13 14:54
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class RefreshRouteController {

    @Autowired
    private RefreshRouteService refreshRouteService;

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public String refresh(){
        refreshRouteService.refreshRoute();
        return "success";
    }
}
