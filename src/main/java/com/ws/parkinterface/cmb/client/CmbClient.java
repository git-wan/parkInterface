package com.ws.parkinterface.cmb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cmbClient",url="http://121.15.180.72/CmbBank_B2B/UI/NetPay")
public interface CmbClient {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(method = RequestMethod.POST,value = "/DoBusiness.ashx",consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public String testss();
}
