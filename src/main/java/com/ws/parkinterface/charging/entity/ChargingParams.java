package com.ws.parkinterface.charging.entity;

import lombok.Data;


@Data
public class ChargingParams {
    private static final long serialVersionUID = 1L;

    private String plateNo;

    private String merchId;

    private Integer duration;

    private String bizld;

    private String startChargingTime;

    private String stopChargingTime;

    private String sign;

}
