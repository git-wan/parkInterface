package com.ws.parkinterface.utils;

import com.ws.parkinterface.charging.entity.ChargingParams;
import com.ws.parkinterface.charging.entity.PageData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ParkUtil {


    public static String getSign(Map<String, Object> mapParams, String signKey) {
        String[] keyArray = new String[mapParams.keySet().size()];
        mapParams.keySet().toArray(keyArray);
        Arrays.sort(keyArray);
        StringBuffer sb = new StringBuffer();
        for (String key : keyArray) {
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(mapParams.get(key) + "")) {
                sb.append(key).append("=").append(mapParams.get(key)).append("&");
            }
        }
        sb.append("key=").append(DigestUtils.md5Hex(signKey));
        log.info("param:{}", sb.toString());
        String sign = DigestUtils.md5Hex(sb.toString()).toUpperCase();
        log.info("param:{} sign:{}", sb.toString(), sign);
        return sign;
    }

    public static   PageData isChargingParams(ChargingParams chargingParams,String signKey,String merchid) {
        PageData result = new PageData();
        Map<String, Object> map = new HashMap<>();
        result.put("code", 10009);
        result.put("msg", "调用停车场失败");
        if (StringUtils.isEmpty(chargingParams.getPlateNo())) {
            return result;
        } else {
            map.put("plateNo", chargingParams.getPlateNo());
        }
        if (StringUtils.isEmpty(chargingParams.getMerchId())) {
            return result;
        } else {
            map.put("merchId", chargingParams.getMerchId());
        }
        if (chargingParams.getDuration() == null) {
            return result;
        } else {
            map.put("duration", chargingParams.getDuration());
        }
        if (StringUtils.isEmpty(chargingParams.getBizld())) {
            return result;
        }
        if (StringUtils.isEmpty(chargingParams.getStartChargingTime())) {
            return result;
        }
        if (StringUtils.isEmpty(chargingParams.getStopChargingTime())) {
            return result;
        }
        if (StringUtils.isEmpty(chargingParams.getSign())) {
            return result;
        } else {
            //比对签名，正确继续，错误返回对象
            String sign = getSign(map, signKey);
            if (!sign.equals(chargingParams.getSign())) {
                result.put("code", 10007);
                result.put("msg", "签名错误");
                return result;
            }
            if (!merchid.equals(chargingParams.getMerchId())) {
                result.put("code", 10006);
                result.put("msg", "没有对应站");
                return result;
            }
        }
        return null;
    }
}
