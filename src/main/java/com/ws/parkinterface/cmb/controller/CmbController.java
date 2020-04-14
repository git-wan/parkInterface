package com.ws.parkinterface.cmb.controller;

import com.ws.parkinterface.cmb.client.CmbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CmbController {
    @Autowired
    CmbClient cmbClient;
    @RequestMapping("/helloworld")
    public String  helloworld(){
//        String str  =  cmbClient.hello();
        String str1 = cmbClient.testss();
        return "";

    }
    @RequestMapping("/hello")
    public String hello(){
        return "111";
    }
}
