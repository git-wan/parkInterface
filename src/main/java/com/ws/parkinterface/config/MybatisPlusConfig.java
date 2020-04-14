package com.ws.parkinterface.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: wancheng
 * @date: Created in 2019/11/22 15:01
 * @version: 1.0
 * @modified By:
 */
@Configuration
@MapperScan(value = {"com.ws.parkinterface.**.mapper"})
public class MybatisPlusConfig {
    //分页插件
}
