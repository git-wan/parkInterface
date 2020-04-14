package com.ws.parkinterface.charging.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.parkinterface.charging.entity.PageData;
import com.ws.parkinterface.charging.entity.Test;
import com.ws.parkinterface.charging.mapper.TestMapper;
import com.ws.parkinterface.charging.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: wancheng
 * @date: Created in 2019/11/22 15:27
 * @version: 1.0
 * @modified By:
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Resource
    TestMapper testMapper;
/*    @Override
    public void test(Test test) {

         testMapper.test(test);
    }*/
}
