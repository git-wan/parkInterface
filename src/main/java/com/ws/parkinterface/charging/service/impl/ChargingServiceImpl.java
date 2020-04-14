package com.ws.parkinterface.charging.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.parkinterface.charging.entity.ChargingParams;
import com.ws.parkinterface.charging.entity.PageData;
import com.ws.parkinterface.charging.mapper.ChargingMapper;
import com.ws.parkinterface.charging.service.ChargingService;
import com.ws.parkinterface.utils.ParkUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Slf4j
@Service
@PropertySource(value = {"classpath:application.yml"})
public class ChargingServiceImpl extends ServiceImpl<ChargingMapper, ChargingParams> implements ChargingService {

    @Resource
    ChargingMapper chargingMapper;
    @Value("${signKey}")
    private  String singKey;
    @Value("${merchid}")
    private String merchid;


    @Override
    public PageData getParkingResult(ChargingParams chargingParams) {
        PageData pageData = new PageData();
        PageData result = ParkUtil.isChargingParams(chargingParams,singKey,merchid);
        if (result != null) {
            return result;
        }else {
            result = new PageData();
        }
        pageData.put("AS_PLATENO", chargingParams.getPlateNo());
        pageData.put("AS_MERCHID", chargingParams.getMerchId());
        pageData.put("AS_BIZID", chargingParams.getBizld());
        pageData.put("AS_DURATION", chargingParams.getDuration());
        pageData.put("AS_STARTTIME", chargingParams.getStartChargingTime());
        pageData.put("AS_STOPTIME", chargingParams.getStopChargingTime());
        try {
            chargingMapper.getParkingResult(pageData);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 10005);
            result.put("msg", "停车场错误");
            return result;
        }
        String code = pageData.get("AS_CODE") + "";
        if (StringUtils.isEmpty(code)) {
            result.put("code", 10005);
            result.put("msg", "停车场错误");
            return result;
        }
        result.put("code", code);
        PageData data = new PageData();
        if (code.equals("10002")) {
            result.put("msg", "车辆未入场");
            return result;
        }
        if (code.equals("10000")) {
            result.put("msg", "减免成功");
            data.put("carEntryTime", pageData.get("AS_MSG"));
            result.put("data", data);
            return result;
        }
        if (code.equals("10003")) {
            result.put("msg", "重复减免");
            data.put("carEntryTime", pageData.get("AS_MSG"));
            result.put("data", data);
            return result;
        }
        return result;
    }
}
