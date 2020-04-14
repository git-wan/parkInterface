package com.ws.parkinterface.charging.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ws.parkinterface.charging.entity.ChargingParams;
import com.ws.parkinterface.charging.entity.PageData;



public interface ChargingMapper extends BaseMapper<ChargingParams> {

    void getParkingResult(PageData pageData);

}
