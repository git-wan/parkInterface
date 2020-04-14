package com.ws.parkinterface.charging.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.parkinterface.charging.entity.ChargingParams;
import com.ws.parkinterface.charging.entity.PageData;


public interface ChargingService extends IService<ChargingParams> {

    PageData getParkingResult(ChargingParams chargingParams);


}
