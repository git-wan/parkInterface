package com.ws.parkinterface.charging.controller;

import com.ws.parkinterface.charging.entity.ChargingParams;
import com.ws.parkinterface.charging.entity.PageData;
import com.ws.parkinterface.charging.service.ChargingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: wancheng
 * @date: Created in 2019/11/22 15:06
 * @version: 1.0
 * @modified By:
 */
@RestController
@RequestMapping("/charging")
@Slf4j
public class ChargingController {

    @Autowired
    ChargingService chargingService;

    @PostMapping("/chParkReduction")
    public synchronized PageData chParkReduction(@RequestBody ChargingParams chargingParams){
        log.info("小桔充电传入参数ChargingParams:{}",chargingParams.toString());
        PageData result = chargingService.getParkingResult(chargingParams);
        log.info("小桔充电传出参数result:{}",result.toString());
        return  result;
    }
}
